package org.bobo.mybatis.entity;

public class NsNstTemplateDto {

    private long nstId;
    private String nstName;
    private String nstCode;
    private String nstType;
    private int status;
    private long fileId;
    private String creator;
    private String description;
    private String createTime;
    private String subscribeFlag;
    private long vendorId;
    private long versionId;

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

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSubscribeFlag() {
        return subscribeFlag;
    }

    public void setSubscribeFlag(String subscribeFlag) {
        this.subscribeFlag = subscribeFlag;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
}
