package org.bobo.model.tencent.event.coupon;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bobo.model.tencent.event.common.Chan;
import org.bobo.model.tencent.event.common.Component;
import org.bobo.model.tencent.event.common.WxUser;

import java.io.Serializable;

public class CouponProps implements Serializable {

    private Coupon coupon;
    @JsonProperty("coupon_batch")
    private CouponBatch couponBatch;
    private String page;
    private String page_title;
    private String sr_sdk_version;
    private String time;
    private WxUser wx_user;
    private Chan chan;
    private Component component;

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public CouponBatch getCouponBatch() {
        return couponBatch;
    }

    public void setCouponBatch(CouponBatch couponBatch) {
        this.couponBatch = couponBatch;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getSr_sdk_version() {
        return sr_sdk_version;
    }

    public void setSr_sdk_version(String sr_sdk_version) {
        this.sr_sdk_version = sr_sdk_version;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WxUser getWx_user() {
        return wx_user;
    }

    public void setWx_user(WxUser wx_user) {
        this.wx_user = wx_user;
    }

    public Chan getChan() {
        return chan;
    }

    public void setChan(Chan chan) {
        this.chan = chan;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }
}
