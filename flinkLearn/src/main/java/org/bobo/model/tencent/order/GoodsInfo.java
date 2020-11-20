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
public class GoodsInfo {

    @JsonProperty("external_sku_id")
    private String externalSkuId;
    @JsonProperty("sku_name_chinese")
    private String skuNameChinese;
    @JsonProperty("goods_amount")
    private int goodsAmount;
    @JsonProperty("payment_amount")
    private int paymentAmount;
    @JsonProperty("is_gift")
    private int isGift;
    @JsonProperty("external_spu_id")
    private String externalSpuId;
    @JsonProperty("spu_name_chinese")
    private String spuNameChinese;
    @JsonProperty("sale_unit")
    private String saleUnit;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("goods_num")
    private int goodsNum;
    @JsonProperty("goods_weight")
    private int goodsWeight;
    @JsonProperty("store_info")
    private StoreInfo storeInfo;
    @JsonProperty("chan_info")
    private List<ChanInfo> chanInfo;
    @JsonProperty("commission_info")
    private List<CommissionInfo> commissionInfo;
    public void setExternalSkuId(String externalSkuId) {
         this.externalSkuId = externalSkuId;
     }
     public String getExternalSkuId() {
         return externalSkuId;
     }

    public void setSkuNameChinese(String skuNameChinese) {
         this.skuNameChinese = skuNameChinese;
     }
     public String getSkuNameChinese() {
         return skuNameChinese;
     }

    public void setGoodsAmount(int goodsAmount) {
         this.goodsAmount = goodsAmount;
     }
     public int getGoodsAmount() {
         return goodsAmount;
     }

    public void setPaymentAmount(int paymentAmount) {
         this.paymentAmount = paymentAmount;
     }
     public int getPaymentAmount() {
         return paymentAmount;
     }

    public void setIsGift(int isGift) {
         this.isGift = isGift;
     }
     public int getIsGift() {
         return isGift;
     }

    public void setExternalSpuId(String externalSpuId) {
         this.externalSpuId = externalSpuId;
     }
     public String getExternalSpuId() {
         return externalSpuId;
     }

    public void setSpuNameChinese(String spuNameChinese) {
         this.spuNameChinese = spuNameChinese;
     }
     public String getSpuNameChinese() {
         return spuNameChinese;
     }

    public void setSaleUnit(String saleUnit) {
         this.saleUnit = saleUnit;
     }
     public String getSaleUnit() {
         return saleUnit;
     }

    public void setCategoryId(String categoryId) {
         this.categoryId = categoryId;
     }
     public String getCategoryId() {
         return categoryId;
     }

    public void setCategoryName(String categoryName) {
         this.categoryName = categoryName;
     }
     public String getCategoryName() {
         return categoryName;
     }

    public void setGoodsNum(int goodsNum) {
         this.goodsNum = goodsNum;
     }
     public int getGoodsNum() {
         return goodsNum;
     }

    public void setGoodsWeight(int goodsWeight) {
         this.goodsWeight = goodsWeight;
     }
     public int getGoodsWeight() {
         return goodsWeight;
     }

    public void setStoreInfo(StoreInfo storeInfo) {
         this.storeInfo = storeInfo;
     }
     public StoreInfo getStoreInfo() {
         return storeInfo;
     }

    public void setChanInfo(List<ChanInfo> chanInfo) {
         this.chanInfo = chanInfo;
     }
     public List<ChanInfo> getChanInfo() {
         return chanInfo;
     }

    public void setCommissionInfo(List<CommissionInfo> commissionInfo) {
         this.commissionInfo = commissionInfo;
     }
     public List<CommissionInfo> getCommissionInfo() {
         return commissionInfo;
     }

}