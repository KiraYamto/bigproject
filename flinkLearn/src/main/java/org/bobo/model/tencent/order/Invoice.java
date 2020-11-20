package org.bobo.model.tencent.order;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2020-11-05 10:13:17
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Invoice {

    @JsonProperty("if_need_invoice")
    private boolean ifNeedInvoice;
    @JsonProperty("invoice_type")
    private String invoiceType;
    @JsonProperty("invoice_title")
    private String invoiceTitle;
    @JsonProperty("invoice_content")
    private String invoiceContent;
    @JsonProperty("invoice_addition_info")
    private String invoiceAdditionInfo;
    @JsonProperty("invoice_company")
    private String invoiceCompany;
    @JsonProperty("invoice_taxpayer")
    private String invoiceTaxpayer;
    @JsonProperty("registry_address")
    private String registryAddress;
    @JsonProperty("registry_phone")
    private String registryPhone;
    @JsonProperty("registry_bank_name")
    private String registryBankName;
    @JsonProperty("registry_bank_account")
    private String registryBankAccount;
    @JsonProperty("invoice_delivery_address")
    private String invoiceDeliveryAddress;
    @JsonProperty("invoice_delivery_name")
    private String invoiceDeliveryName;
    @JsonProperty("invoice_delivery_phone")
    private String invoiceDeliveryPhone;
    @JsonProperty("invoice_num")
    private String invoiceNum;
    public void setIfNeedInvoice(boolean ifNeedInvoice) {
         this.ifNeedInvoice = ifNeedInvoice;
     }
     public boolean getIfNeedInvoice() {
         return ifNeedInvoice;
     }

    public void setInvoiceType(String invoiceType) {
         this.invoiceType = invoiceType;
     }
     public String getInvoiceType() {
         return invoiceType;
     }

    public void setInvoiceTitle(String invoiceTitle) {
         this.invoiceTitle = invoiceTitle;
     }
     public String getInvoiceTitle() {
         return invoiceTitle;
     }

    public void setInvoiceContent(String invoiceContent) {
         this.invoiceContent = invoiceContent;
     }
     public String getInvoiceContent() {
         return invoiceContent;
     }

    public void setInvoiceAdditionInfo(String invoiceAdditionInfo) {
         this.invoiceAdditionInfo = invoiceAdditionInfo;
     }
     public String getInvoiceAdditionInfo() {
         return invoiceAdditionInfo;
     }

    public void setInvoiceCompany(String invoiceCompany) {
         this.invoiceCompany = invoiceCompany;
     }
     public String getInvoiceCompany() {
         return invoiceCompany;
     }

    public void setInvoiceTaxpayer(String invoiceTaxpayer) {
         this.invoiceTaxpayer = invoiceTaxpayer;
     }
     public String getInvoiceTaxpayer() {
         return invoiceTaxpayer;
     }

    public void setRegistryAddress(String registryAddress) {
         this.registryAddress = registryAddress;
     }
     public String getRegistryAddress() {
         return registryAddress;
     }

    public void setRegistryPhone(String registryPhone) {
         this.registryPhone = registryPhone;
     }
     public String getRegistryPhone() {
         return registryPhone;
     }

    public void setRegistryBankName(String registryBankName) {
         this.registryBankName = registryBankName;
     }
     public String getRegistryBankName() {
         return registryBankName;
     }

    public void setRegistryBankAccount(String registryBankAccount) {
         this.registryBankAccount = registryBankAccount;
     }
     public String getRegistryBankAccount() {
         return registryBankAccount;
     }

    public void setInvoiceDeliveryAddress(String invoiceDeliveryAddress) {
         this.invoiceDeliveryAddress = invoiceDeliveryAddress;
     }
     public String getInvoiceDeliveryAddress() {
         return invoiceDeliveryAddress;
     }

    public void setInvoiceDeliveryName(String invoiceDeliveryName) {
         this.invoiceDeliveryName = invoiceDeliveryName;
     }
     public String getInvoiceDeliveryName() {
         return invoiceDeliveryName;
     }

    public void setInvoiceDeliveryPhone(String invoiceDeliveryPhone) {
         this.invoiceDeliveryPhone = invoiceDeliveryPhone;
     }
     public String getInvoiceDeliveryPhone() {
         return invoiceDeliveryPhone;
     }

    public void setInvoiceNum(String invoiceNum) {
         this.invoiceNum = invoiceNum;
     }
     public String getInvoiceNum() {
         return invoiceNum;
     }

}