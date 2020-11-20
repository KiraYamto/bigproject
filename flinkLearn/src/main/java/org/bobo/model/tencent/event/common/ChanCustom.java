package org.bobo.model.tencent.event.common;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ChanCustom {

    @JsonProperty("chan_custom_id")
    private Date chanCustomId;
    @JsonProperty("chan_custom_id_desc")
    private String chanCustomIdDesc;
    @JsonProperty("chan_custom_cat_3")
    private String chanCustomCat3;
    @JsonProperty("chan_custom_cat_3_desc")
    private String chanCustomCat3Desc;
    @JsonProperty("chan_custom_cat_2")
    private String chanCustomCat2;
    @JsonProperty("chan_custom_cat_2_desc")
    private String chanCustomCat2Desc;
    @JsonProperty("chan_custom_cat_1")
    private String chanCustomCat1;
    @JsonProperty("chan_custom_cat_1_desc")
    private String chanCustomCat1Desc;
    public void setChanCustomId(Date chanCustomId) {
         this.chanCustomId = chanCustomId;
     }
     public Date getChanCustomId() {
         return chanCustomId;
     }

    public void setChanCustomIdDesc(String chanCustomIdDesc) {
         this.chanCustomIdDesc = chanCustomIdDesc;
     }
     public String getChanCustomIdDesc() {
         return chanCustomIdDesc;
     }

    public void setChanCustomCat3(String chanCustomCat3) {
         this.chanCustomCat3 = chanCustomCat3;
     }
     public String getChanCustomCat3() {
         return chanCustomCat3;
     }

    public void setChanCustomCat3Desc(String chanCustomCat3Desc) {
         this.chanCustomCat3Desc = chanCustomCat3Desc;
     }
     public String getChanCustomCat3Desc() {
         return chanCustomCat3Desc;
     }

    public void setChanCustomCat2(String chanCustomCat2) {
         this.chanCustomCat2 = chanCustomCat2;
     }
     public String getChanCustomCat2() {
         return chanCustomCat2;
     }

    public void setChanCustomCat2Desc(String chanCustomCat2Desc) {
         this.chanCustomCat2Desc = chanCustomCat2Desc;
     }
     public String getChanCustomCat2Desc() {
         return chanCustomCat2Desc;
     }

    public void setChanCustomCat1(String chanCustomCat1) {
         this.chanCustomCat1 = chanCustomCat1;
     }
     public String getChanCustomCat1() {
         return chanCustomCat1;
     }

    public void setChanCustomCat1Desc(String chanCustomCat1Desc) {
         this.chanCustomCat1Desc = chanCustomCat1Desc;
     }
     public String getChanCustomCat1Desc() {
         return chanCustomCat1Desc;
     }

}