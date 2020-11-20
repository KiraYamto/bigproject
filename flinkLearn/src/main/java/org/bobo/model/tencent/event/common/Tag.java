package org.bobo.model.tencent.event.common;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Tag {

    @JsonProperty("tag_id")
    private String tagId;
    @JsonProperty("tag_name")
    private String tagName;
    public void setTagId(String tagId) {
         this.tagId = tagId;
     }
     public String getTagId() {
         return tagId;
     }

    public void setTagName(String tagName) {
         this.tagName = tagName;
     }
     public String getTagName() {
         return tagName;
     }

}