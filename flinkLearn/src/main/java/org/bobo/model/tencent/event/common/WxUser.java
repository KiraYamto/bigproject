package org.bobo.model.tencent.event.common;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class WxUser {

    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("open_id")
    private String openId;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("union_id")
    private String unionId;
    @JsonProperty("local_id")
    private String localId;
    private List<Tag> tag;
    public void setAppId(String appId) {
         this.appId = appId;
     }
     public String getAppId() {
         return appId;
     }

    public void setOpenId(String openId) {
         this.openId = openId;
     }
     public String getOpenId() {
         return openId;
     }

    public void setUserId(String userId) {
         this.userId = userId;
     }
     public String getUserId() {
         return userId;
     }

    public void setUnionId(String unionId) {
         this.unionId = unionId;
     }
     public String getUnionId() {
         return unionId;
     }

    public void setLocalId(String localId) {
         this.localId = localId;
     }
     public String getLocalId() {
         return localId;
     }

    public void setTag(List<Tag> tag) {
         this.tag = tag;
     }
     public List<Tag> getTag() {
         return tag;
     }

}