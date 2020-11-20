package org.bobo.function.flatmap;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TencentDataFlatFunc implements FlatMapFunction<String, Tuple2<String,String>> {
    private static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");
    private static final Logger logger = LoggerFactory.getLogger(TencentDataFlatFunc.class);

    @Override
    public void flatMap(String s, Collector<Tuple2<String,String>> collector) throws Exception {

    }
}

