package org.bobo.util.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZkServer {
    private static final Logger logger = LoggerFactory.getLogger(ZkServer.class);

    @Value("${zookeeper.address}")
    private String zkAddress ;
    @Value("${zookeeper.timeout}")
    private int timeout ;
    // 定义父节点
    @Value("${zookeeper.node-path}")
    private String nodePath ;
    ZooKeeper zkCli = null;
    // 定义父节
    @Value("${zookeeper.parent-node-path}")
    private String parentNodePath ;
    // 1.连接zkServer 服务端初始化 创建父节点
    public void init() throws Exception {

        zkCli = new ZooKeeper(zkAddress, timeout, new NodeWatcher());
        if(zkCli.exists(parentNodePath,false) == null){
            logger.info("zookeeper parent node {} does not exists ! it will be created !",parentNodePath);
            zkCli.create(parentNodePath, parentNodePath.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            if(zkCli.exists(parentNodePath,false) != null) {
                logger.info("zookeeper parent node {}  created success!",parentNodePath);
            }
        }
        String[] nodeArr = nodePath.split(",");
        for (String node:nodeArr){
            zkCli.exists(node,true);
        }

    }

}