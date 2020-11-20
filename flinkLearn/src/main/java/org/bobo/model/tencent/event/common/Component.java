package org.bobo.model.tencent.event.common;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-06 10:53:52
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Component {

    @JsonProperty("component_id")
    private String componentId;
    @JsonProperty("component_name")
    private String componentName;
    public void setComponentId(String componentId) {
         this.componentId = componentId;
     }
     public String getComponentId() {
         return componentId;
     }

    public void setComponentName(String componentName) {
         this.componentName = componentName;
     }
     public String getComponentName() {
         return componentName;
     }

}