package org.bobo.model.tencent.event.order;

import java.io.Serializable;

public class Order implements Serializable {
    private String order_id;
    private String order_time;
    private String cancel_pay_time;
    private String cancel_time;
    private String pay_time;
    private String refund_time;
    private String order_status;

    public String getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(String cancel_time) {
        this.cancel_time = cancel_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getCancel_pay_time() {
        return cancel_pay_time;
    }

    public void setCancel_pay_time(String cancel_pay_time) {
        this.cancel_pay_time = cancel_pay_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
