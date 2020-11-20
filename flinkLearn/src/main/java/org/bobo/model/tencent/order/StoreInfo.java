package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class StoreInfo {

    @JsonProperty("external_store_id")
    private String externalStoreId;
    @JsonProperty("store_name")
    private String storeName;
    @JsonProperty("store_city")
    private String storeCity;
    public void setExternalStoreId(String externalStoreId) {
         this.externalStoreId = externalStoreId;
     }
     public String getExternalStoreId() {
         return externalStoreId;
     }

    public void setStoreName(String storeName) {
         this.storeName = storeName;
     }
     public String getStoreName() {
         return storeName;
     }

    public void setStoreCity(String storeCity) {
         this.storeCity = storeCity;
     }
     public String getStoreCity() {
         return storeCity;
     }

}