package org.bobo.model.tencent.order;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class JsonsRootBean {

    @JsonProperty("dataSourceId")
    private String datasourceid;
    private List<Order> orders;
    public void setDatasourceid(String datasourceid) {
         this.datasourceid = datasourceid;
     }
     public String getDatasourceid() {
         return datasourceid;
     }

    public void setOrders(List<Order> orders) {
         this.orders = orders;
     }
     public List<Order> getOrders() {
         return orders;
     }

}