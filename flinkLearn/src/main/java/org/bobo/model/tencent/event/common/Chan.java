package org.bobo.model.tencent.event.common;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Chan {

    @JsonProperty("chan_wxapp_scene")
    private int chanWxappScene;
    @JsonProperty("chan_id")
    private String chanId;
    @JsonProperty("chan_refer_app_id")
    private String chanReferAppId;
    @JsonProperty("chan_shop_id")
    private String chanShopId;
    @JsonProperty("chan_shop_name")
    private String chanShopName;
    @JsonProperty("chan_custom")
    private ChanCustom chanCustom;
    public void setChanWxappScene(int chanWxappScene) {
         this.chanWxappScene = chanWxappScene;
     }
     public int getChanWxappScene() {
         return chanWxappScene;
     }

    public void setChanId(String chanId) {
         this.chanId = chanId;
     }
     public String getChanId() {
         return chanId;
     }

    public void setChanReferAppId(String chanReferAppId) {
         this.chanReferAppId = chanReferAppId;
     }
     public String getChanReferAppId() {
         return chanReferAppId;
     }

    public void setChanShopId(String chanShopId) {
         this.chanShopId = chanShopId;
     }
     public String getChanShopId() {
         return chanShopId;
     }

    public void setChanShopName(String chanShopName) {
         this.chanShopName = chanShopName;
     }
     public String getChanShopName() {
         return chanShopName;
     }

    public void setChanCustom(ChanCustom chanCustom) {
         this.chanCustom = chanCustom;
     }
     public ChanCustom getChanCustom() {
         return chanCustom;
     }

}