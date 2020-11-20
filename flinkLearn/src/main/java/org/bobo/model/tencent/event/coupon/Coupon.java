package org.bobo.model.tencent.event.coupon;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 13:55:15
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Coupon {

    @JsonProperty("coupon_id")
    private String couponId;
    @JsonProperty("coupon_name")
    private String couponName;
    public void setCouponId(String couponId) {
         this.couponId = couponId;
     }
     public String getCouponId() {
         return couponId;
     }

    public void setCouponName(String couponName) {
         this.couponName = couponName;
     }
     public String getCouponName() {
         return couponName;
     }

}