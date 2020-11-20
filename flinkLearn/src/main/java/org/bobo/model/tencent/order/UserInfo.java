package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class UserInfo {

    @JsonProperty("open_id")
    private String openId;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("union_id")
    private String unionId;
    @JsonProperty("user_phone")
    private String userPhone;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("member_id")
    private String memberId;
    @JsonProperty("user_first_order_time")
    private String userFirstOrderTime;
    public void setOpenId(String openId) {
         this.openId = openId;
     }
     public String getOpenId() {
         return openId;
     }

    public void setAppId(String appId) {
         this.appId = appId;
     }
     public String getAppId() {
         return appId;
     }

    public void setUnionId(String unionId) {
         this.unionId = unionId;
     }
     public String getUnionId() {
         return unionId;
     }

    public void setUserPhone(String userPhone) {
         this.userPhone = userPhone;
     }
     public String getUserPhone() {
         return userPhone;
     }

    public void setUserId(String userId) {
         this.userId = userId;
     }
     public String getUserId() {
         return userId;
     }

    public void setMemberId(String memberId) {
         this.memberId = memberId;
     }
     public String getMemberId() {
         return memberId;
     }

    public void setUserFirstOrderTime(String userFirstOrderTime) {
         this.userFirstOrderTime = userFirstOrderTime;
     }
     public String getUserFirstOrderTime() {
         return userFirstOrderTime;
     }

}