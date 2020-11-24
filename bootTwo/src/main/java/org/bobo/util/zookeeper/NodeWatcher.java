package org.bobo.util.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: bobo
 * @Date: 2020/11/23 14:46
 */
//ZK自带的标准化监听，只能监听一次事件，某节点发生了一次事件之后，监听失效
public class NodeWatcher implements Watcher{
	private static final Logger logger = LoggerFactory.getLogger(NodeWatcher.class);


	private ZooKeeper zkCli;



	public NodeWatcher() {
	}

	public NodeWatcher(ZooKeeper zkCli) {
		this.zkCli = zkCli;
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDeleted) {
			//临时节点被删除了，则节点不在线；触发后，watcher被删除，继续添加watcher
			logger.info("node {} was deleted",event.getPath());
			System.out.println("节点" + event.getPath() + "掉线");

			//监控到掉线之后 后面就是应急处理
			//dosomething
		}else if (event.getType() == EventType.NodeCreated) {
			//临时节点被创建了，则节点上线了；触发后，watcher被删除，继续添加watcher
			logger.info("node {} was created",event.getPath());
			System.out.println("节点" + event.getPath() + "上线");

		}

	}

	public ZooKeeper getZkCli() {
		return zkCli;
	}

	public void setZkCli(ZooKeeper zkCli) {
		this.zkCli = zkCli;
	}
	
}