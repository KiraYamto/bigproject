package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ChanWxapp {

    @JsonProperty("chan_scene")
    private String chanScene;
    public void setChanScene(String chanScene) {
         this.chanScene = chanScene;
     }
     public String getChanScene() {
         return chanScene;
     }

}