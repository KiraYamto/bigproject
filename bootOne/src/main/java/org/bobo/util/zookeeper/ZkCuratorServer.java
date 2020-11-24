package org.bobo.util.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: bobo
 * @Date: 2020/11/23 14:51
 */
@Component
public class ZkCuratorServer {

    private static final Logger logger = LoggerFactory.getLogger(ZkCuratorServer.class);
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
    private int heartBeat ;

    private int sleepTime = 1000;
    private int maxRetries = 3;


    ZooKeeper zkCli = null;

    @PostConstruct
    private void init(){

        //重试策略，重试时间为1s，重试10次
        CuratorFramework cf = getClient();
        listenParentNode(cf,parentNodePath,false);
        listenChildrenNode(cf,nodePath,false);
      //  listenTree(cf,parentNodePath,false);
    }

    private  CuratorFramework getClient(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(sleepTime,maxRetries);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zkAddress)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(sessionTimeOut)
                .connectionTimeoutMs(connectionTimeOut)
                .build();
        client.start();
        return client;
    }
    public void listenParentNode(CuratorFramework cf,String parentNodePath,boolean cacheData){
        NodeCache nodeCache = new NodeCache(cf, parentNodePath, cacheData);

        try {
            NodeCacheListener listener = new FmRuleNodeCacheListener(nodeCache);
            nodeCache.getListenable().addListener(listener);
            nodeCache.start(true);//true代表缓存当前节点
            if(nodeCache.getCurrentData() != null){
                System.out.println("节点的初始化数据为："+new String(nodeCache.getCurrentData().getData()));
            }else{
                System.out.println("节点初始化数据为空。。。");
            }

        } catch (Exception e) {
            logger.error("创建NodeCache监听失败, path={}", parentNodePath);
        }
    }

    public void listenChildrenNode(CuratorFramework cf,String path, boolean cacheData) {
        try {
            PathChildrenCache pathChildrenCache = new PathChildrenCache(cf, parentNodePath, cacheData);
            PathChildrenCacheListener childrenCacheListener = new FmRulePathChildrenCacheListener(parentNodePath,heartBeat);
            pathChildrenCache.getListenable().addListener(childrenCacheListener);
            pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        } catch (Exception e) {
            logger.error("PathCache监听失败, path=", path);
        }
    }
    public void listenTree(CuratorFramework cf,String path, boolean cacheData) {
         TreeCache treeCache = new TreeCache(cf, parentNodePath);
        try {
            treeCache.start();
            treeCache.getListenable().addListener(new FmRuleTreeCacheListener());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
