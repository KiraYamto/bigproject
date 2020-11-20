package org.bobo.model.tencent.event.common;

import com.alibaba.fastjson.JSON;
import org.bobo.model.tencent.TencentData;

import java.io.Serializable;

public class BaseProps implements Serializable {

    //用户预约
    private String phone_number;
    //搜索
    private String keyword;

    //发起咨询
    private String action_type;


    private String page;
    private String page_title;
    private String sr_sdk_version;
    private String time;
    private WxUser wx_user;
    private Chan chan;
    private Component component;


    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getSr_sdk_version() {
        return sr_sdk_version;
    }

    public void setSr_sdk_version(String sr_sdk_version) {
        this.sr_sdk_version = sr_sdk_version;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WxUser getWx_user() {
        return wx_user;
    }

    public void setWx_user(WxUser wx_user) {
        this.wx_user = wx_user;
    }

    public Chan getChan() {
        return chan;
    }

    public void setChan(Chan chan) {
        this.chan = chan;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static void main(String[] args) {
        String text = "{\n" +
                "\t\"type\": \"app_launch\",\n" +
                "\t\"props\": {\n" +
                "\t\t\"page\": \"pages/product?sku_id=AOdjf7u\",\n" +
                "\t\t\"page_title\": \"商品详情、商城首页\",\n" +
                "\t\t\"time\": \"1560409473714\",\n" +
                "\t\t\"wx_user\": {\n" +
                "\t\t\t\"app_id\": \"wx9d4f5f22pa099f82\",\n" +
                "\t\t\t\"open_id\": \"ogN6X0T-ilsH-XmIdzXtuR1f1r3Q\",\n" +
                "\t\t\t\"user_id\": \"548019854034\",\n" +
                "\t\t\t\"union_id\": \"o6_bmlsdaXds8d6_sgVt7hM3OPfL\",\n" +
                "\t\t\t\"local_id\": \"360b8853-64bf-3fba-e9a0-5abb1e4d7721\",\n" +
                "\t\t\t\"tag\": [{\n" +
                "\t\t\t\t\"tag_id\": \"游客\",\n" +
                "\t\t\t\t\"tag_name\": \"游客\"\n" +
                "\t\t\t}]\n" +
                "\t\t},\n" +
                "\t\t\"chan\": {\n" +
                "\t\t\t\"chan_wxapp_scene\": 1037,\n" +
                "\t\t\t\"chan_id\": \"11\",\n" +
                "\t\t\t\"chan_refer_app_id\": \"wx9d6f5f6gea059654\",\n" +
                "\t\t\t\"chan_shop_id\": \"11\",\n" +
                "\t\t\t\"chan_shop_name\": \"11\",\n" +
                "\t\t\t\"chan_custom\": {\n" +
                "\t\t\t\t\"chan_custom_id\": \"mp-article-12375\",\n" +
                "\t\t\t\t\"chan_custom_id_desc\": \"公众号文章(id=12375)\",\n" +
                "\t\t\t\t\"chan_custom_cat_3\": \"mp-article\",\n" +
                "\t\t\t\t\"chan_custom_cat_3_desc\": \"公众号文章\",\n" +
                "\t\t\t\t\"chan_custom_cat_2\": \"media\",\n" +
                "\t\t\t\t\"chan_custom_cat_2_desc\": \"媒体\",\n" +
                "\t\t\t\t\"chan_custom_cat_1\": \"wechat\",\n" +
                "\t\t\t\t\"chan_custom_cat_1_desc\": \"微信\"\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"component\": {\n" +
                "\t\t\t\"component_id\": \"\",\n" +
                "\t\t\t\"component_name\": \"\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        TencentData<BaseProps> test = JSON.parseObject(text,TencentData.class);
        System.out.println(JSON.toJSONString(test));
    }
}
