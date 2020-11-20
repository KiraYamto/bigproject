package org.bobo.function.flatmap;

import com.alibaba.fastjson.JSON;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.bobo.model.tencent.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrdersFlatFunc implements FlatMapFunction<String, Tuple2<String,Order>>{
    private static final Logger logger  = LoggerFactory.getLogger(OrdersFlatFunc.class);
    @Override
    public void flatMap(String value, Collector<Tuple2<String, Order>> collector) throws Exception {
        logger.debug("OrdersFlatFunc---flatmap receive value is {}",value);
        System.out.println("OrdersFlatFunc---flatmap receive value is "+value);
        Order order = JSON.parseObject(value,Order.class);
        collector.collect(new Tuple2<>(order.getUserInfo().getUserId(), order));
    }
}
