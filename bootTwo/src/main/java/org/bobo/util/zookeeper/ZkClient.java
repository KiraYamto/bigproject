package org.bobo.util.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ZkClient {

    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);
    @Value("${zookeeper.address}")
    private String zkAddress ;
    @Value("${zookeeper.timeout}")
    private int timeout ;
    @Value("${zookeeper.node-path}")
    private String nodePath ;
    ZooKeeper zkCli = null;
    @Value("${zookeeper.parent-node-path}")
    private String parentNodePath ;
    //@PostConstruct
    private void init(){
        try {
            zkCli = new ZooKeeper(zkAddress, timeout, new NodeWatcher());
          /*  if(zkCli.exists(nodePath,false) != null){
                System.out.println("节点"+nodePath +"存在");
                zkCli.setData(nodePath,"boot-one".getBytes(),1);
                zkCli.setData(parentNodePath,parentNodePath.getBytes(),1);
            }*/
            zkCli.create("/fm-rule/boot-one/bb","/fm-rule/boot-one/bb".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zkCli.create("/fm-rule/boot-three","/fm-rule/boot-three".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        } catch (KeeperException e) {
            logger.error("register zk client occer error!",e);
        } catch (InterruptedException e) {
            logger.error("register zk client occer error!",e);
        } catch (IOException e) {
            logger.error("register zk client occer error!",e);
        }

    }


}