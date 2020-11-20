package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class PromotionInfo {

    @JsonProperty("promotion_type")
    private int promotionType;
    @JsonProperty("external_promotion_id")
    private String externalPromotionId;
    @JsonProperty("promotion_name")
    private String promotionName;
    @JsonProperty("promotion_amount")
    private int promotionAmount;
    public void setPromotionType(int promotionType) {
         this.promotionType = promotionType;
     }
     public int getPromotionType() {
         return promotionType;
     }

    public void setExternalPromotionId(String externalPromotionId) {
         this.externalPromotionId = externalPromotionId;
     }
     public String getExternalPromotionId() {
         return externalPromotionId;
     }

    public void setPromotionName(String promotionName) {
         this.promotionName = promotionName;
     }
     public String getPromotionName() {
         return promotionName;
     }

    public void setPromotionAmount(int promotionAmount) {
         this.promotionAmount = promotionAmount;
     }
     public int getPromotionAmount() {
         return promotionAmount;
     }

}