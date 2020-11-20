package org.bobo.model.tencent.event.coupon;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 13:55:15
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class CouponBatch {

    @JsonProperty("coupon_batch_id")
    private String couponBatchId;
    @JsonProperty("coupon_batch_name")
    private String couponBatchName;
    public void setCouponBatchId(String couponBatchId) {
         this.couponBatchId = couponBatchId;
     }
     public String getCouponBatchId() {
         return couponBatchId;
     }

    public void setCouponBatchName(String couponBatchName) {
         this.couponBatchName = couponBatchName;
     }
     public String getCouponBatchName() {
         return couponBatchName;
     }

}