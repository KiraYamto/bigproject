package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class CouponDetail {

    @JsonProperty("external_coupon_id")
    private String externalCouponId;
    @JsonProperty("coupon_batch_id")
    private String couponBatchId;
    @JsonProperty("coupon_name")
    private String couponName;
    @JsonProperty("coupon_amount")
    private int couponAmount;
    public void setExternalCouponId(String externalCouponId) {
         this.externalCouponId = externalCouponId;
     }
     public String getExternalCouponId() {
         return externalCouponId;
     }

    public void setCouponBatchId(String couponBatchId) {
         this.couponBatchId = couponBatchId;
     }
     public String getCouponBatchId() {
         return couponBatchId;
     }

    public void setCouponName(String couponName) {
         this.couponName = couponName;
     }
     public String getCouponName() {
         return couponName;
     }

    public void setCouponAmount(int couponAmount) {
         this.couponAmount = couponAmount;
     }
     public int getCouponAmount() {
         return couponAmount;
     }

}