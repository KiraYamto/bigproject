package org.bobo.model.tencent.order;

import com.alibaba.fastjson.JSON;
import org.bobo.util.FileUtil;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Order {

    @JsonProperty("external_order_id")
    private String externalOrderId;
    @JsonProperty("create_time")
    private String createTime;
    @JsonProperty("order_source")
    private String orderSource;
    @JsonProperty("order_type")
    private Integer orderType;
    @JsonProperty("brand_id")
    private String brandId;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("goods_num_total")
    private Integer goodsNumTotal;
    @JsonProperty("goods_weight")
    private Integer goodsWeight;
    @JsonProperty("goods_amount_total")
    private Integer goodsAmountTotal;
    @JsonProperty("freight_amount")
    private Integer freightAmount;
    @JsonProperty("order_amount")
    private Float orderAmount;
    @JsonProperty("payable_amount")
    private Float payableAmount;
    @JsonProperty("payment_amount")
    private Float paymentAmount;
    @JsonProperty("order_status")
    private String orderStatus;
    @JsonProperty("user_info")
    private UserInfo userInfo;
    @JsonProperty("goods_info")
    private List<GoodsInfo> goodsInfo;
    @JsonProperty("promotion_info")
    private List<PromotionInfo> promotionInfo;
    @JsonProperty("coupon_info")
    private List<CouponInfo> couponInfo;
    @JsonProperty("payment_info")
    private List<PaymentInfo> paymentInfo;
    @JsonProperty("express_info")
    private ExpressInfo expressInfo;
    private List<Invoice> invoice;
    @JsonProperty("points_total")
    private Float pointsTotal;
    @JsonProperty("is_deleted")
    private Integer isDeleted;

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getGoodsNumTotal() {
        return goodsNumTotal;
    }

    public void setGoodsNumTotal(Integer goodsNumTotal) {
        this.goodsNumTotal = goodsNumTotal;
    }

    public Integer getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Integer goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public Integer getGoodsAmountTotal() {
        return goodsAmountTotal;
    }

    public void setGoodsAmountTotal(Integer goodsAmountTotal) {
        this.goodsAmountTotal = goodsAmountTotal;
    }

    public Integer getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Float getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Float payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<GoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public List<PromotionInfo> getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(List<PromotionInfo> promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public List<CouponInfo> getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(List<CouponInfo> couponInfo) {
        this.couponInfo = couponInfo;
    }

    public List<PaymentInfo> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public ExpressInfo getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(ExpressInfo expressInfo) {
        this.expressInfo = expressInfo;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public Float getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(Float pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}