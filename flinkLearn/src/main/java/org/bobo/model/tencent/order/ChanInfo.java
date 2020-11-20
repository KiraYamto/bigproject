package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ChanInfo {

    @JsonProperty("chan_wxapp")
    private ChanWxapp chanWxapp;
    @JsonProperty("chan_custom")
    private ChanCustom chanCustom;
    @JsonProperty("chan_id")
    private String chanId;
    @JsonProperty("chan_refer_app_id")
    private String chanReferAppId;
    public void setChanWxapp(ChanWxapp chanWxapp) {
         this.chanWxapp = chanWxapp;
     }
     public ChanWxapp getChanWxapp() {
         return chanWxapp;
     }

    public void setChanCustom(ChanCustom chanCustom) {
         this.chanCustom = chanCustom;
     }
     public ChanCustom getChanCustom() {
         return chanCustom;
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

}