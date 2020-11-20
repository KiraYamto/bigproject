package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ExpressPage {

    @JsonProperty("miniprogram_path")
    private String miniprogramPath;
    @JsonProperty("miniprogram_appid")
    private String miniprogramAppid;
    @JsonProperty("miniprogram_h5")
    private String miniprogramH5;
    public void setMiniprogramPath(String miniprogramPath) {
         this.miniprogramPath = miniprogramPath;
     }
     public String getMiniprogramPath() {
         return miniprogramPath;
     }

    public void setMiniprogramAppid(String miniprogramAppid) {
         this.miniprogramAppid = miniprogramAppid;
     }
     public String getMiniprogramAppid() {
         return miniprogramAppid;
     }

    public void setMiniprogramH5(String miniprogramH5) {
         this.miniprogramH5 = miniprogramH5;
     }
     public String getMiniprogramH5() {
         return miniprogramH5;
     }

}