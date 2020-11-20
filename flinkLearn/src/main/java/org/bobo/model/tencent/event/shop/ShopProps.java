package org.bobo.model.tencent.event.shop;
import java.io.Serializable;
import java.util.List;

import org.bobo.model.tencent.event.common.Chan;
import org.bobo.model.tencent.event.common.Component;
import org.bobo.model.tencent.event.common.WxUser;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ShopProps implements Serializable {


    private Sku sku;
    private Spu spu;
    @JsonProperty("sku_category")
    private List<SkuCategory> skuCategory;
    @JsonProperty("shipping_shop")
    private ShippingShop shippingShop;
    private Sale sale;
    private String primary_image_url;
    //加购
    @JsonProperty("sku_num")
    private int skuNum;
    @JsonProperty("action_type")
    private String actionType;


    private String page;
    private String page_title;
    private String sr_sdk_version;
    private String time;
    private WxUser wx_user;
    private Chan chan;
    private Component component;


    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<SkuCategory> getSkuCategory() {
        return skuCategory;
    }

    public void setSkuCategory(List<SkuCategory> skuCategory) {
        this.skuCategory = skuCategory;
    }

    public ShippingShop getShippingShop() {
        return shippingShop;
    }

    public void setShippingShop(ShippingShop shippingShop) {
        this.shippingShop = shippingShop;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getPrimary_image_url() {
        return primary_image_url;
    }

    public void setPrimary_image_url(String primary_image_url) {
        this.primary_image_url = primary_image_url;
    }

    public int getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(int skuNum) {
        this.skuNum = skuNum;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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