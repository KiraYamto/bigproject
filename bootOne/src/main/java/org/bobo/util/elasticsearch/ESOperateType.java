package org.bobo.util.elasticsearch;

/**
 * @Author: bobo
 * @Date: 2020/11/27 16:13
 */
public enum ESOperateType {

    CREATE(1,"创建"),
    UPDATE(2,"更新"),
    DELETE(-1,"删除"),
    QUERY(0,"查询")
    ;
    private int code;
    private String desc;

    ESOperateType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
