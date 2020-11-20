package org.bobo.constant;

public enum EventType {


    /*浏览行为	app_launch	小程序启动	预置
    浏览行为	app_show	小程序显示	预置
    浏览行为	exit_wxapp	小程序隐藏	预置
    浏览行为	browse_wxapp_page	页面浏览	可代理
    浏览行为	leave_wxapp_page	页面离开	可代理
    浏览行为	page_share_app_message	页面分享	可代理
    浏览行为	page_pull_down_refresh	页面下拉刷新	可代理
    浏览行为	page_reach_bottom	页面上拉触底	可代理
    搜索行为	search	搜索
    商品行为	expose_sku_component	商品卡曝光
    商品行为	trigger_sku_component	商品卡触发
    商品行为	browse_sku_page	商品页浏览
    商品行为	add_to_cart	商品加购
    下单行为	custom_order	订单状态变更
    订单接口	/data-api/v1/order/add_order	添加/更新主订单*/

    APP_LAUNCH("app_launch","程序启动"),
    APP_SHOW("app_show","程序启动"),
    EXIT_WXAPP("exit_wxapp","程序启动"),
    BROWSE_WXAPP_PAGE("browse_wxapp_page","页面分享"),
    PAGE_SHARE_APP_MESSAGE("page_share_app_message","页面下拉刷新"),
    PAGE_PULL_DOWN_REFRESH("page_pull_down_refresh","页面上拉触底"),
    PAGE_REACH_BOTTOM("page_reach_bottom","页面上拉触底"),
    SEARCH("search","搜索"),
    EXPOSE_SKU_COMPONENT("expose_sku_component","商品卡曝光"),
    TRIGGER_SKU_COMPONENT("trigger_sku_component","商品卡触发"),
    BROWSE_SKU_PAGE("browse_sku_page","商品页浏览"),
    ADD_TO_CART("add_to_cart","商品加购"),
    CUSTOM_ORDER("custom_order","订单状态变更"),
    ADD_ORDER("add_order","添加/更新主订单")
    ;
    private String type;
    private String name;

    EventType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
