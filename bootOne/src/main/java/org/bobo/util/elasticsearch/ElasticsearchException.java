package org.bobo.util.elasticsearch;

/**
 * @Author: bobo
 * @Date: 2020/11/27 15:44
 */
public class ElasticsearchException  extends RuntimeException{

    public ElasticsearchException(String message) {
        super(message);
    }

    public ElasticsearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
