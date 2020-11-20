package org.bobo.model.tencent;

import org.bobo.constant.EventType;

public class TencentData<T> {

    private EventType type;
    private T props;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public T getProps() {
        return props;
    }

    public void setProps(T props) {
        this.props = props;
    }
}
