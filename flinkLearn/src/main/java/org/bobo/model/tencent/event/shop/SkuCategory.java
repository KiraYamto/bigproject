package org.bobo.model.tencent.event.shop;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class SkuCategory {

    @JsonProperty("sku_cat_id")
    private String skuCatId;
    @JsonProperty("sku_cat_name")
    private String skuCatName;
    @JsonProperty("sku_parent_cat_id")
    private String skuParentCatId;
    public void setSkuCatId(String skuCatId) {
         this.skuCatId = skuCatId;
     }
     public String getSkuCatId() {
         return skuCatId;
     }

    public void setSkuCatName(String skuCatName) {
         this.skuCatName = skuCatName;
     }
     public String getSkuCatName() {
         return skuCatName;
     }

    public void setSkuParentCatId(String skuParentCatId) {
         this.skuParentCatId = skuParentCatId;
     }
     public String getSkuParentCatId() {
         return skuParentCatId;
     }

}