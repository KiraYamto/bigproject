package org.bobo.model.tencent.event.shop;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Spu {

    @JsonProperty("spu_id")
    private String spuId;
    @JsonProperty("spu_name")
    private String spuName;
    public void setSpuId(String spuId) {
         this.spuId = spuId;
     }
     public String getSpuId() {
         return spuId;
     }

    public void setSpuName(String spuName) {
         this.spuName = spuName;
     }
     public String getSpuName() {
         return spuName;
     }

}