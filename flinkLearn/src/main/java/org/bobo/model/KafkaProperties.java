package org.bobo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public  class KafkaProperties {
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private static String servers;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private static boolean enableAutoCommit;
    @Value("${spring.kafka.consumer.session-time-out}")
    private static String sessionTimeout;
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private static String autoCommitInterval;
    @Value("${spring.kafka.consumer.group-id}")
    private static String groupId;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private static String autoOffsetReset;
    @Value("${spring.kafka.consumer.concurrency}")
    private static int concurrency;

    @Value("${spring.kafka.producer.retries}")
    private static int retries;
    @Value("${spring.kafka.producer.batch-size}")
    private static int batchSize;
    @Value("${spring.kafka.producer.linger}")
    private static int linger;
    @Value("${spring.kafka.producer.buffer-memory}")
    private static int bufferMemory;
    @Value("${spring.kafka.producer.acks}")
    private static String ack;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;
    @Value("${spring.kafka.template.input-topic}")
    private String inputTopic;
    @Value("${spring.kafka.template.output-topic}")
    private String outputTopic;
    @Value("${spring.kafka.template.flink-input}")
    private String flinkIn;
    @Value("${spring.kafka.template.flink-output}")
    private String flinkOut;

    public static String getAck() {
        return ack;
    }

    public static void setAck(String ack) {
        KafkaProperties.ack = ack;
    }

    public static String getServers() {
        return servers;
    }

    public static void setServers(String servers) {
        KafkaProperties.servers = servers;
    }

    public static boolean isEnableAutoCommit() {
        return enableAutoCommit;
    }

    public static void setEnableAutoCommit(boolean enableAutoCommit) {
        KafkaProperties.enableAutoCommit = enableAutoCommit;
    }

    public static String getSessionTimeout() {
        return sessionTimeout;
    }

    public static void setSessionTimeout(String sessionTimeout) {
        KafkaProperties.sessionTimeout = sessionTimeout;
    }

    public static String getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public static void setAutoCommitInterval(String autoCommitInterval) {
        KafkaProperties.autoCommitInterval = autoCommitInterval;
    }

    public static String getGroupId() {
        return groupId;
    }

    public static void setGroupId(String groupId) {
        KafkaProperties.groupId = groupId;
    }

    public static String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public static void setAutoOffsetReset(String autoOffsetReset) {
        KafkaProperties.autoOffsetReset = autoOffsetReset;
    }

    public static int getConcurrency() {
        return concurrency;
    }

    public static void setConcurrency(int concurrency) {
        KafkaProperties.concurrency = concurrency;
    }

    public static int getRetries() {
        return retries;
    }

    public static void setRetries(int retries) {
        KafkaProperties.retries = retries;
    }

    public static int getBatchSize() {
        return batchSize;
    }

    public static void setBatchSize(int batchSize) {
        KafkaProperties.batchSize = batchSize;
    }

    public static int getLinger() {
        return linger;
    }

    public static void setLinger(int linger) {
        KafkaProperties.linger = linger;
    }

    public static int getBufferMemory() {
        return bufferMemory;
    }

    public static void setBufferMemory(int bufferMemory) {
        KafkaProperties.bufferMemory = bufferMemory;
    }
}
