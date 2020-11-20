package org.bobo.util.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeWatcher implements Watcher{
	private static final Logger logger = LoggerFactory.getLogger(NodeWatcher.class);


	public NodeWatcher() {
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
	
	
}