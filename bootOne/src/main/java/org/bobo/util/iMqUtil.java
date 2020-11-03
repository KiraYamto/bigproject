package org.bobo.util;

public interface iMqUtil {
    public <T>void syncSendMessage(String topic,T message);
    public <T>void syncSendMessage(String topic,String key,T message);

}
