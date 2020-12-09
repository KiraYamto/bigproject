package org.bobo.util.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: bobo
 * @Date: 2020/11/23 14:51
 */
@Component
public class ZkCuratorServer {

    private static final Logger logger = LoggerFactory.getLogger(ZkCuratorServer.class);
    public static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    @Value("${zookeeper.address}")
    private String zkAddress ;
    @Value("${zookeeper.session-timeout}")
    private int sessionTimeOut ;
    @Value("${zookeeper.connect-timeout}")
    private int connectionTimeOut ;
    // 定义父节点
    @Value("${zookeeper.node-path}")
    private String nodePath ;
    @Value("${zookeeper.parent-node-path}")
    private String parentNodePath ;
    @Value("${zookeeper.namespace}")
    private String namespace ;
    @Value("${zookeeper.heart-beat}")
    private int heartTime ;
    private int sleepTime = 1000;
    private int maxRetries = 3;

    private

    ZooKeeper zkCli = null;

    @PostConstruct
    private void init(){
        //重试策略，重试时间为1s，重试10次
        CuratorFramework cf = getClient();
        register(cf);
        HeartBeatTask task = new HeartBeatTask(cf,nodePath);
        executor.scheduleAtFixedRate(task,heartTime,heartTime, TimeUnit.SECONDS);
    }

    private  CuratorFramework getClient(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(sleepTime,maxRetries);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zkAddress)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(sessionTimeOut)
                .connectionTimeoutMs(connectionTimeOut)
               // .namespace(namespace)
                .build();
        client.start();
        return client;
    }

    private void register(CuratorFramework cf){
        try {
            long timestamp = System.currentTimeMillis();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String heartBeatTime = format.format(timestamp);

            Stat stat = cf.checkExists().forPath(nodePath);
            if(stat == null){
                logger.info("node {} does not exist,prepare to create it",nodePath);
                cf.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(nodePath,heartBeatTime.getBytes());
            }else {
                logger.info("node {} exist,set heartbeat timestamp",nodePath);

                cf.setData().forPath(nodePath,heartBeatTime.getBytes());
            }
        } catch (Exception e) {
            logger.error("register zk client error!",e);
        }

    }


/*    public void listenParentNode(CuratorFramework cf,String parentNodePath,boolean cacheData){
        NodeCache nodeCache = new NodeCache(cf, parentNodePath, cacheData);
        try {
            FmRuleNodeCacheListener listener = new FmRuleNodeCacheListener(nodeCache);
            nodeCache.getListenable().addListener(listener);
            nodeCache.start();//true代表缓存当前节点
        } catch (Exception e) {
            logger.error("创建NodeCache监听失败, path={}", parentNodePath);
        }
    }

    public void listenChildrenNode(CuratorFramework cf,String path, boolean cacheData) {
        String[] nodePathArr = path.split(",");
        for (String nodePathChild:nodePathArr){
            try {
                PathChildrenCache pathChildrenCache = new PathChildrenCache(cf, nodePathChild, cacheData);
                PathChildrenCacheListener childrenCacheListener = new FmRulePathChildrenCacheListener();
                pathChildrenCache.getListenable().addListener(childrenCacheListener);
                pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            } catch (Exception e) {
                logger.error("PathCache监听失败, path=", path);
            }
        }


    }*/

}
