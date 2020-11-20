package org.bobo.model.tencent.order;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class CouponInfo {

    @JsonProperty("coupon_type")
    private int couponType;
    @JsonProperty("coupon_amount_total")
    private int couponAmountTotal;
    @JsonProperty("coupon_detail")
    private List<CouponDetail> couponDetail;
    public void setCouponType(int couponType) {
         this.couponType = couponType;
     }
     public int getCouponType() {
         return couponType;
     }

    public void setCouponAmountTotal(int couponAmountTotal) {
         this.couponAmountTotal = couponAmountTotal;
     }
     public int getCouponAmountTotal() {
         return couponAmountTotal;
     }

    public void setCouponDetail(List<CouponDetail> couponDetail) {
         this.couponDetail = couponDetail;
     }
     public List<CouponDetail> getCouponDetail() {
         return couponDetail;
     }

}