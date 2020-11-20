package org.bobo.util.zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZkServer {
    @Value("${zookeeper.address}")
    private String zkAddress ;
    @Value("${zookeeper.timeout}")
    private int timeout ;
    // 定义父节点
    @Value("${zookeeper.node-path}")
    private String nodePath ;
    ZooKeeper zkCli = null;

    // 1.连接zkServer
    @PostConstruct
    public void init() throws Exception {
        zkCli = new ZooKeeper(zkAddress, timeout, new NodeWatcher());
        String[] nodeArr = nodePath.split(",");
        for (String node:nodeArr){
            zkCli.exists(node,true);
        }
    }

}