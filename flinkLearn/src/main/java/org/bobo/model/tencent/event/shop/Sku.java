package org.bobo.model.tencent.event.shop;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Sku {

    @JsonProperty("sku_id")
    private String skuId;
    @JsonProperty("sku_name")
    private String skuName;
    public void setSkuId(String skuId) {
         this.skuId = skuId;
     }
     public String getSkuId() {
         return skuId;
     }

    public void setSkuName(String skuName) {
         this.skuName = skuName;
     }
     public String getSkuName() {
         return skuName;
     }

}