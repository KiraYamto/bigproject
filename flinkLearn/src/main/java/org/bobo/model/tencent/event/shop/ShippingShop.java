package org.bobo.model.tencent.event.shop;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ShippingShop {

    @JsonProperty("shipping_shop_id")
    private String shippingShopId;
    @JsonProperty("shipping_shop_name")
    private String shippingShopName;
    public void setShippingShopId(String shippingShopId) {
         this.shippingShopId = shippingShopId;
     }
     public String getShippingShopId() {
         return shippingShopId;
     }

    public void setShippingShopName(String shippingShopName) {
         this.shippingShopName = shippingShopName;
     }
     public String getShippingShopName() {
         return shippingShopName;
     }

}