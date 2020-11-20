package org.bobo.model.tencent.event.shop;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Sale {

    @JsonProperty("original_price")
    private double originalPrice;
    @JsonProperty("current_price")
    private int currentPrice;
    public void setOriginalPrice(double originalPrice) {
         this.originalPrice = originalPrice;
     }
     public double getOriginalPrice() {
         return originalPrice;
     }

    public void setCurrentPrice(int currentPrice) {
         this.currentPrice = currentPrice;
     }
     public int getCurrentPrice() {
         return currentPrice;
     }

}