package org.bobo.model.tencent.order;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class ExpressPackageInfo {

    @JsonProperty("express_company_code")
    private String expressCompanyCode;
    @JsonProperty("express_company_name")
    private String expressCompanyName;
    @JsonProperty("express_code")
    private String expressCode;
    @JsonProperty("ship_time")
    private String shipTime;
    @JsonProperty("express_page")
    private ExpressPage expressPage;
    @JsonProperty("express_package_info")
    private List<ExpressPackageInfo> expressPackageInfo;
    public void setExpressCompanyCode(String expressCompanyCode) {
         this.expressCompanyCode = expressCompanyCode;
     }
     public String getExpressCompanyCode() {
         return expressCompanyCode;
     }

    public void setExpressCompanyName(String expressCompanyName) {
         this.expressCompanyName = expressCompanyName;
     }
     public String getExpressCompanyName() {
         return expressCompanyName;
     }

    public void setExpressCode(String expressCode) {
         this.expressCode = expressCode;
     }
     public String getExpressCode() {
         return expressCode;
     }

    public void setShipTime(String shipTime) {
         this.shipTime = shipTime;
     }
     public String getShipTime() {
         return shipTime;
     }

    public void setExpressPage(ExpressPage expressPage) {
         this.expressPage = expressPage;
     }
     public ExpressPage getExpressPage() {
         return expressPage;
     }

    public void setExpressPackageInfo(List<ExpressPackageInfo> expressPackageInfo) {
         this.expressPackageInfo = expressPackageInfo;
     }
     public List<ExpressPackageInfo> getExpressPackageInfo() {
         return expressPackageInfo;
     }

}