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
public class ExpressInfo {

    @JsonProperty("logistics_status")
    private String logisticsStatus;
    @JsonProperty("goods_total_weight")
    private int goodsTotalWeight;
    @JsonProperty("receiver_name")
    private String receiverName;
    @JsonProperty("receiver_phone")
    private String receiverPhone;
    @JsonProperty("receiver_address")
    private String receiverAddress;
    @JsonProperty("receiver_country_code")
    private String receiverCountryCode;
    @JsonProperty("receiver_province_code")
    private String receiverProvinceCode;
    @JsonProperty("receiver_city_code")
    private String receiverCityCode;
    @JsonProperty("receiver_district_code")
    private String receiverDistrictCode;
    @JsonProperty("expected_delivery_time")
    private String expectedDeliveryTime;
    @JsonProperty("expected_delivery_date")
    private String expectedDeliveryDate;
    @JsonProperty("express_package_info")
    private List<ExpressPackageInfo> expressPackageInfo;
    public void setLogisticsStatus(String logisticsStatus) {
         this.logisticsStatus = logisticsStatus;
     }
     public String getLogisticsStatus() {
         return logisticsStatus;
     }

    public void setGoodsTotalWeight(int goodsTotalWeight) {
         this.goodsTotalWeight = goodsTotalWeight;
     }
     public int getGoodsTotalWeight() {
         return goodsTotalWeight;
     }

    public void setReceiverName(String receiverName) {
         this.receiverName = receiverName;
     }
     public String getReceiverName() {
         return receiverName;
     }

    public void setReceiverPhone(String receiverPhone) {
         this.receiverPhone = receiverPhone;
     }
     public String getReceiverPhone() {
         return receiverPhone;
     }

    public void setReceiverAddress(String receiverAddress) {
         this.receiverAddress = receiverAddress;
     }
     public String getReceiverAddress() {
         return receiverAddress;
     }

    public void setReceiverCountryCode(String receiverCountryCode) {
         this.receiverCountryCode = receiverCountryCode;
     }
     public String getReceiverCountryCode() {
         return receiverCountryCode;
     }

    public void setReceiverProvinceCode(String receiverProvinceCode) {
         this.receiverProvinceCode = receiverProvinceCode;
     }
     public String getReceiverProvinceCode() {
         return receiverProvinceCode;
     }

    public void setReceiverCityCode(String receiverCityCode) {
         this.receiverCityCode = receiverCityCode;
     }
     public String getReceiverCityCode() {
         return receiverCityCode;
     }

    public void setReceiverDistrictCode(String receiverDistrictCode) {
         this.receiverDistrictCode = receiverDistrictCode;
     }
     public String getReceiverDistrictCode() {
         return receiverDistrictCode;
     }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
         this.expectedDeliveryTime = expectedDeliveryTime;
     }
     public String getExpectedDeliveryTime() {
         return expectedDeliveryTime;
     }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
         this.expectedDeliveryDate = expectedDeliveryDate;
     }
     public String getExpectedDeliveryDate() {
         return expectedDeliveryDate;
     }

    public void setExpressPackageInfo(List<ExpressPackageInfo> expressPackageInfo) {
         this.expressPackageInfo = expressPackageInfo;
     }
     public List<ExpressPackageInfo> getExpressPackageInfo() {
         return expressPackageInfo;
     }

}