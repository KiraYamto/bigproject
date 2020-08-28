package org.bobo.mybatis.query;

import java.io.Serializable;

public class NsNstTemplateQuery implements Serializable {
    private long nstId;
    private String nstName;
    private String nstCode;
    private String nstType;
    private int status;
    private String version;
    private String tag;

    public NsNstTemplateQuery() {
    }

    public NsNstTemplateQuery(long nstId, String nstName, String nstCode, String nstType, int status, String version, String tag) {
        this.nstId = nstId;
        this.nstName = nstName;
        this.nstCode = nstCode;
        this.nstType = nstType;
        this.status = status;
        this.version = version;
        this.tag = tag;
    }

    public NsNstTemplateQuery(String nstCode,String nstName) {
        this.nstName = nstName;
        this.nstCode = nstCode;
    }

    public long getNstId() {
        return nstId;
    }

    public void setNstId(long nstId) {
        this.nstId = nstId;
    }

    public String getNstName() {
        return nstName;
    }

    public void setNstName(String nstName) {
        this.nstName = nstName;
    }

    public String getNstCode() {
        return nstCode;
    }

    public void setNstCode(String nstCode) {
        this.nstCode = nstCode;
    }

    public String getNstType() {
        return nstType;
    }

    public void setNstType(String nstType) {
        this.nstType = nstType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
