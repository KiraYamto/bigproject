package org.bobo.model.tencent.event.page;

import com.alibaba.fastjson.JSON;
import org.bobo.model.tencent.TencentData;
import org.bobo.model.tencent.event.common.Chan;
import org.bobo.model.tencent.event.common.Component;
import org.bobo.model.tencent.event.common.WxUser;
import org.bobo.util.FileUtil;

import java.io.Serializable;

public class PageProps implements Serializable {
    //页面浏览
    private String refer_page;
    private Boolean is_newly_open;
    //页面离开
    private Integer stay_time;
    //页面分享
    private String from_type;
    private String share_title;
    private String share_path;
    private String share_image_url;
    private String share_to;//发送目标，friends：好友；timeline：朋友圈

    //页面元素事件
    private String type;
    private String element_id;
    private String index;
    private String name;


    private String page;
    private String page_title;
    private String sr_sdk_version;
    private String time;
    private WxUser wx_user;
    private Chan chan;
    private Component component;


    public Boolean getIs_newly_open() {
        return is_newly_open;
    }

    public void setIs_newly_open(Boolean is_newly_open) {
        this.is_newly_open = is_newly_open;
    }

    public Integer getStay_time() {
        return stay_time;
    }

    public void setStay_time(Integer stay_time) {
        this.stay_time = stay_time;
    }

    public String getRefer_page() {
        return refer_page;
    }

    public void setRefer_page(String refer_page) {
        this.refer_page = refer_page;
    }

    public boolean isIs_newly_open() {
        return is_newly_open;
    }

    public void setIs_newly_open(boolean is_newly_open) {
        this.is_newly_open = is_newly_open;
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

    public static void main(String[] args) {
        String text1 = FileUtil.readTxtFile("D:\\IDEAWorkSpace\\NG5\\fuck\\flinkLearn\\src\\main\\java\\org\\bobo\\model\\tencent\\event\\page\\1.txt");
        String text2 = FileUtil.readTxtFile("D:\\IDEAWorkSpace\\NG5\\fuck\\flinkLearn\\src\\main\\java\\org\\bobo\\model\\tencent\\event\\page\\2.txt");
        String text3 = FileUtil.readTxtFile("D:\\IDEAWorkSpace\\NG5\\fuck\\flinkLearn\\src\\main\\java\\org\\bobo\\model\\tencent\\event\\page\\3.txt");
        String text4 = FileUtil.readTxtFile("D:\\IDEAWorkSpace\\NG5\\fuck\\flinkLearn\\src\\main\\java\\org\\bobo\\model\\tencent\\event\\page\\4.txt");

        TencentData<PageProps> page1 = JSON.parseObject(text1,TencentData.class);
        TencentData<PageProps> page2 = JSON.parseObject(text2,TencentData.class);
        TencentData<PageProps> page3 = JSON.parseObject(text3,TencentData.class);
        TencentData<PageProps> page4 = JSON.parseObject(text4,TencentData.class);

        System.out.println(JSON.toJSONString(page1));
        System.out.println(JSON.toJSONString(page2));
        System.out.println(JSON.toJSONString(page3));
        System.out.println(JSON.toJSONString(page4));


    }
}
