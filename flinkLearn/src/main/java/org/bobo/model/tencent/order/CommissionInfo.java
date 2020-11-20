package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class CommissionInfo {

    @JsonProperty("commission_type")
    private int commissionType;
    @JsonProperty("commission_fee")
    private int commissionFee;
    public void setCommissionType(int commissionType) {
         this.commissionType = commissionType;
     }
     public int getCommissionType() {
         return commissionType;
     }

    public void setCommissionFee(int commissionFee) {
         this.commissionFee = commissionFee;
     }
     public int getCommissionFee() {
         return commissionFee;
     }

}