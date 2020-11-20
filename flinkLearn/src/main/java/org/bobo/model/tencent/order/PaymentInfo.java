package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class PaymentInfo {

    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("trans_id")
    private String transId;
    @JsonProperty("trans_amount")
    private int transAmount;
    public void setPaymentType(String paymentType) {
         this.paymentType = paymentType;
     }
     public String getPaymentType() {
         return paymentType;
     }

    public void setTransId(String transId) {
         this.transId = transId;
     }
     public String getTransId() {
         return transId;
     }

    public void setTransAmount(int transAmount) {
         this.transAmount = transAmount;
     }
     public int getTransAmount() {
         return transAmount;
     }

}