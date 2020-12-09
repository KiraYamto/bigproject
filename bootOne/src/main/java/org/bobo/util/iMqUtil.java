package org.bobo.util;

public interface iMqUtil {
    <T>void syncSendMessage(String topic, T message);
    <T>void syncSendMessage(String topic, String key, T message);

}
