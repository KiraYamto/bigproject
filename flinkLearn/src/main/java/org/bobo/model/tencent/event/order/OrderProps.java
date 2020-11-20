package org.bobo.model.tencent.event.order;

import com.alibaba.fastjson.JSON;
import org.bobo.model.tencent.TencentData;
import org.bobo.model.tencent.event.common.Chan;
import org.bobo.model.tencent.event.common.Component;
import org.bobo.model.tencent.event.common.WxUser;

import java.io.Serializable;
import java.util.List;

public class OrderProps implements Serializable {
    private String page;
    private String page_title;
    private String sr_sdk_version;
    private String time;
    private WxUser wx_user;
    private Chan chan;
    private Component component;

    private Order order;
    private List<SubOrder> sub_orders;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<SubOrder> getSub_orders() {
        return sub_orders;
    }

    public void setSub_orders(List<SubOrder> sub_orders) {
        this.sub_orders = sub_orders;
    }

    public static void main(String[] args) {
        String text = "{\n" +
                "    \"type\": \"custom_order\",\n" +
                "    \"props\": {\n" +
                "        \"order\": {\n" +
                "            \"order_id\": \"xxxx\",\n" +
                "            \"order_time\": \"1560409473714\",\n" +
                "            \"cancel_pay_time\": \"1560409473714\",\n" +
                "            \"order_status\": \"cancel_pay\"\n" +
                "        },\n" +
                "        \"sub_orders\": [\n" +
                "            {\n" +
                "                \"sub_order_id\": \"xxxxx\",\n" +
                "                \"order_amt\": 30.3,\n" +
                "                \"pay_amt\": 30.3\n" +
                "            }\n" +
                "        ],\n" +
                "        \"page\": \"pages/product?sku_id=AOdjf7u\",\n" +
                "        \"page_title\": \"商品详情、商城首页\",\n" +
                "        \"time\": \"1560409473714\",\n" +
                "        \"wx_user\": {\n" +
                "            \"app_id\": \"wx9d4f5f22pa099f82\",\n" +
                "            \"open_id\": \"ogN6X0T-ilsH-XmIdzXtuR1f1r3Q\",\n" +
                "            \"user_id\": \"548019854034\",\n" +
                "            \"union_id\": \"o6_bmlsdaXds8d6_sgVt7hM3OPfL\",\n" +
                "            \"local_id\": \"360b8853-64bf-3fba-e9a0-5abb1e4d7721\",\n" +
                "            \"tag\": [\n" +
                "                {\n" +
                "                    \"tag_id\": \"游客\",\n" +
                "                    \"tag_name\": \"游客\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"chan\": {\n" +
                "            \"chan_wxapp_scene\": 1037,\n" +
                "            \"chan_id\": \"11\",\n" +
                "            \"chan_refer_app_id\": \"wx9d6f5f6gea059654\",\n" +
                "            \"chan_shop_id\": \"11\",\n" +
                "            \"chan_shop_name\": \"11\",\n" +
                "            \"chan_custom\": {\n" +
                "                \"chan_custom_id\": \"mp-article-12375\",\n" +
                "                \"chan_custom_id_desc\": \"公众号文章(id=12375)\",\n" +
                "                \"chan_custom_cat_3\": \"mp-article\",\n" +
                "                \"chan_custom_cat_3_desc\": \"公众号文章\",\n" +
                "                \"chan_custom_cat_2\": \"media\",\n" +
                "                \"chan_custom_cat_2_desc\": \"媒体\",\n" +
                "                \"chan_custom_cat_1\": \"wechat\",\n" +
                "                \"chan_custom_cat_1_desc\": \"微信\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"component\": {\n" +
                "            \"component_id\": \"\",\n" +
                "            \"component_name\": \"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        TencentData<OrderProps> order = JSON.parseObject(text,TencentData.class);

        System.out.println(JSON.toJSONString(order));
    }
}
