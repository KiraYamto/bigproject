package org.bobo.model.es;

import java.util.Date;

/**
 * @Author: bobo
 * @Date: 2020/11/27 14:35
 */
public class AlarmInfoDoc extends EsBaseDoc {

    private String id;

    private String dbId;

    private String orgAlarmTitle;

    private String orgAlarmStatus;

    private String orgAlarmType;

    private String orgSeverity;

    private Date orgEventTime;

    private Date orgClearTime;

    private String orgAlarmId;

    private String orgSpecificProblemId;

    private String orgSpecificProblem;

    private String orgNeUid;

    private String orgNeName;

    private String orgNeType;

    private String orgObjectUid;

    private String orgObjectName;

    private String orgObjectType;

    private String orgObjectTypeName;

    private String orgLocationInfo;

    private String orgAdditionalInfo;

    private String orgNetworkSliceId;

    private String phdAlarmSignal;

    private String phdFp;

    private String phdCFp;

    private Date phdDiscoveryTime;

    private String phdVendorId;

    private String phdGid;

    private String resCityId;

    private String resSiteId;

    private String resRoomId;

    private String stdSpecialtyType;

    private String stdVendorVersion;

    private String stdInmsSeverity;

    private String stdInmsAlarmId;

    private String stdAlarmExplain;

    private String stdAlarmRepairAdvice;

    private String stdAlarmType;

    private String stdAlarmLogicType;

    private String stdAlarmLogicSubType;

    private String stdEffectNe;

    private String stdEffectService;

    private String stdAlarmName;

    private String stdSendItFlag;

    private String stdFlag;

    private String projNum;

    private String projName;

    private String prsAckFlag;

    private String prsForwardFlag;

    private String prsTtId;

    private String prsTtFlag;

    private String prsNoticeFlag;

    private String prsPreprocessFlag;

    private String prsAlarmStatus;

    private String prsRelatedRuleType;

    private String prsRelatedRuleId;

    private String prsRelatedRuleName;

    private Date prsRelatedDate;

    private String prsPAlarmSignal;

    private String prsCompressionKey;

    private String prsCompressionAlarmNum;

    private String prsRemarkFlag;

    private Date prsLoadDbTime;

    //转义属性
    private String phdVendorIdName;

    private String stdSpecialtyTypeName;

    private String stdFlagName;

    private String orgAlarmTypeName;

    private String prsTtFlagName;

    private String prsForwardFlagName;

    private String prsAckFlagName;

    private String stdSendItFlagName;

    private String orgAlarmStatusName;

    private String alarmResourceStatusName;

    private String preprocessMannerName;

    private String ticketConfirmMannerName;

    private String resCityIdName;

    private String stdInmsSeverityName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getOrgAlarmTitle() {
        return orgAlarmTitle;
    }

    public void setOrgAlarmTitle(String orgAlarmTitle) {
        this.orgAlarmTitle = orgAlarmTitle;
    }

    public String getOrgAlarmStatus() {
        return orgAlarmStatus;
    }

    public void setOrgAlarmStatus(String orgAlarmStatus) {
        this.orgAlarmStatus = orgAlarmStatus;
    }

    public String getOrgAlarmType() {
        return orgAlarmType;
    }

    public void setOrgAlarmType(String orgAlarmType) {
        this.orgAlarmType = orgAlarmType;
    }

    public String getOrgSeverity() {
        return orgSeverity;
    }

    public void setOrgSeverity(String orgSeverity) {
        this.orgSeverity = orgSeverity;
    }

    public Date getOrgEventTime() {
        return orgEventTime;
    }

    public void setOrgEventTime(Date orgEventTime) {
        this.orgEventTime = orgEventTime;
    }

    public Date getOrgClearTime() {
        return orgClearTime;
    }

    public void setOrgClearTime(Date orgClearTime) {
        this.orgClearTime = orgClearTime;
    }

    public String getOrgAlarmId() {
        return orgAlarmId;
    }

    public void setOrgAlarmId(String orgAlarmId) {
        this.orgAlarmId = orgAlarmId;
    }

    public String getOrgSpecificProblemId() {
        return orgSpecificProblemId;
    }

    public void setOrgSpecificProblemId(String orgSpecificProblemId) {
        this.orgSpecificProblemId = orgSpecificProblemId;
    }

    public String getOrgSpecificProblem() {
        return orgSpecificProblem;
    }

    public void setOrgSpecificProblem(String orgSpecificProblem) {
        this.orgSpecificProblem = orgSpecificProblem;
    }

    public String getOrgNeUid() {
        return orgNeUid;
    }

    public void setOrgNeUid(String orgNeUid) {
        this.orgNeUid = orgNeUid;
    }

    public String getOrgNeName() {
        return orgNeName;
    }

    public void setOrgNeName(String orgNeName) {
        this.orgNeName = orgNeName;
    }

    public String getOrgNeType() {
        return orgNeType;
    }

    public void setOrgNeType(String orgNeType) {
        this.orgNeType = orgNeType;
    }

    public String getOrgObjectUid() {
        return orgObjectUid;
    }

    public void setOrgObjectUid(String orgObjectUid) {
        this.orgObjectUid = orgObjectUid;
    }

    public String getOrgObjectName() {
        return orgObjectName;
    }

    public void setOrgObjectName(String orgObjectName) {
        this.orgObjectName = orgObjectName;
    }

    public String getOrgObjectType() {
        return orgObjectType;
    }

    public void setOrgObjectType(String orgObjectType) {
        this.orgObjectType = orgObjectType;
    }

    public String getOrgObjectTypeName() {
        return orgObjectTypeName;
    }

    public void setOrgObjectTypeName(String orgObjectTypeName) {
        this.orgObjectTypeName = orgObjectTypeName;
    }

    public String getOrgLocationInfo() {
        return orgLocationInfo;
    }

    public void setOrgLocationInfo(String orgLocationInfo) {
        this.orgLocationInfo = orgLocationInfo;
    }

    public String getOrgAdditionalInfo() {
        return orgAdditionalInfo;
    }

    public void setOrgAdditionalInfo(String orgAdditionalInfo) {
        this.orgAdditionalInfo = orgAdditionalInfo;
    }

    public String getOrgNetworkSliceId() {
        return orgNetworkSliceId;
    }

    public void setOrgNetworkSliceId(String orgNetworkSliceId) {
        this.orgNetworkSliceId = orgNetworkSliceId;
    }

    public String getPhdAlarmSignal() {
        return phdAlarmSignal;
    }

    public void setPhdAlarmSignal(String phdAlarmSignal) {
        this.phdAlarmSignal = phdAlarmSignal;
    }

    public String getPhdFp() {
        return phdFp;
    }

    public void setPhdFp(String phdFp) {
        this.phdFp = phdFp;
    }

    public String getPhdCFp() {
        return phdCFp;
    }

    public void setPhdCFp(String phdCFp) {
        this.phdCFp = phdCFp;
    }

    public Date getPhdDiscoveryTime() {
        return phdDiscoveryTime;
    }

    public void setPhdDiscoveryTime(Date phdDiscoveryTime) {
        this.phdDiscoveryTime = phdDiscoveryTime;
    }

    public String getPhdVendorId() {
        return phdVendorId;
    }

    public void setPhdVendorId(String phdVendorId) {
        this.phdVendorId = phdVendorId;
    }

    public String getPhdGid() {
        return phdGid;
    }

    public void setPhdGid(String phdGid) {
        this.phdGid = phdGid;
    }

    public String getResCityId() {
        return resCityId;
    }

    public void setResCityId(String resCityId) {
        this.resCityId = resCityId;
    }

    public String getResSiteId() {
        return resSiteId;
    }

    public void setResSiteId(String resSiteId) {
        this.resSiteId = resSiteId;
    }

    public String getResRoomId() {
        return resRoomId;
    }

    public void setResRoomId(String resRoomId) {
        this.resRoomId = resRoomId;
    }

    public String getStdSpecialtyType() {
        return stdSpecialtyType;
    }

    public void setStdSpecialtyType(String stdSpecialtyType) {
        this.stdSpecialtyType = stdSpecialtyType;
    }

    public String getStdVendorVersion() {
        return stdVendorVersion;
    }

    public void setStdVendorVersion(String stdVendorVersion) {
        this.stdVendorVersion = stdVendorVersion;
    }

    public String getStdInmsSeverity() {
        return stdInmsSeverity;
    }

    public void setStdInmsSeverity(String stdInmsSeverity) {
        this.stdInmsSeverity = stdInmsSeverity;
    }

    public String getStdInmsAlarmId() {
        return stdInmsAlarmId;
    }

    public void setStdInmsAlarmId(String stdInmsAlarmId) {
        this.stdInmsAlarmId = stdInmsAlarmId;
    }

    public String getStdAlarmExplain() {
        return stdAlarmExplain;
    }

    public void setStdAlarmExplain(String stdAlarmExplain) {
        this.stdAlarmExplain = stdAlarmExplain;
    }

    public String getStdAlarmRepairAdvice() {
        return stdAlarmRepairAdvice;
    }

    public void setStdAlarmRepairAdvice(String stdAlarmRepairAdvice) {
        this.stdAlarmRepairAdvice = stdAlarmRepairAdvice;
    }

    public String getStdAlarmType() {
        return stdAlarmType;
    }

    public void setStdAlarmType(String stdAlarmType) {
        this.stdAlarmType = stdAlarmType;
    }

    public String getStdAlarmLogicType() {
        return stdAlarmLogicType;
    }

    public void setStdAlarmLogicType(String stdAlarmLogicType) {
        this.stdAlarmLogicType = stdAlarmLogicType;
    }

    public String getStdAlarmLogicSubType() {
        return stdAlarmLogicSubType;
    }

    public void setStdAlarmLogicSubType(String stdAlarmLogicSubType) {
        this.stdAlarmLogicSubType = stdAlarmLogicSubType;
    }

    public String getStdEffectNe() {
        return stdEffectNe;
    }

    public void setStdEffectNe(String stdEffectNe) {
        this.stdEffectNe = stdEffectNe;
    }

    public String getStdEffectService() {
        return stdEffectService;
    }

    public void setStdEffectService(String stdEffectService) {
        this.stdEffectService = stdEffectService;
    }

    public String getStdAlarmName() {
        return stdAlarmName;
    }

    public void setStdAlarmName(String stdAlarmName) {
        this.stdAlarmName = stdAlarmName;
    }

    public String getStdSendItFlag() {
        return stdSendItFlag;
    }

    public void setStdSendItFlag(String stdSendItFlag) {
        this.stdSendItFlag = stdSendItFlag;
    }

    public String getStdFlag() {
        return stdFlag;
    }

    public void setStdFlag(String stdFlag) {
        this.stdFlag = stdFlag;
    }

    public String getProjNum() {
        return projNum;
    }

    public void setProjNum(String projNum) {
        this.projNum = projNum;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getPrsAckFlag() {
        return prsAckFlag;
    }

    public void setPrsAckFlag(String prsAckFlag) {
        this.prsAckFlag = prsAckFlag;
    }

    public String getPrsForwardFlag() {
        return prsForwardFlag;
    }

    public void setPrsForwardFlag(String prsForwardFlag) {
        this.prsForwardFlag = prsForwardFlag;
    }

    public String getPrsTtId() {
        return prsTtId;
    }

    public void setPrsTtId(String prsTtId) {
        this.prsTtId = prsTtId;
    }

    public String getPrsTtFlag() {
        return prsTtFlag;
    }

    public void setPrsTtFlag(String prsTtFlag) {
        this.prsTtFlag = prsTtFlag;
    }

    public String getPrsNoticeFlag() {
        return prsNoticeFlag;
    }

    public void setPrsNoticeFlag(String prsNoticeFlag) {
        this.prsNoticeFlag = prsNoticeFlag;
    }

    public String getPrsPreprocessFlag() {
        return prsPreprocessFlag;
    }

    public void setPrsPreprocessFlag(String prsPreprocessFlag) {
        this.prsPreprocessFlag = prsPreprocessFlag;
    }

    public String getPrsAlarmStatus() {
        return prsAlarmStatus;
    }

    public void setPrsAlarmStatus(String prsAlarmStatus) {
        this.prsAlarmStatus = prsAlarmStatus;
    }

    public String getPrsRelatedRuleType() {
        return prsRelatedRuleType;
    }

    public void setPrsRelatedRuleType(String prsRelatedRuleType) {
        this.prsRelatedRuleType = prsRelatedRuleType;
    }

    public String getPrsRelatedRuleId() {
        return prsRelatedRuleId;
    }

    public void setPrsRelatedRuleId(String prsRelatedRuleId) {
        this.prsRelatedRuleId = prsRelatedRuleId;
    }

    public String getPrsRelatedRuleName() {
        return prsRelatedRuleName;
    }

    public void setPrsRelatedRuleName(String prsRelatedRuleName) {
        this.prsRelatedRuleName = prsRelatedRuleName;
    }

    public Date getPrsRelatedDate() {
        return prsRelatedDate;
    }

    public void setPrsRelatedDate(Date prsRelatedDate) {
        this.prsRelatedDate = prsRelatedDate;
    }

    public String getPrsPAlarmSignal() {
        return prsPAlarmSignal;
    }

    public void setPrsPAlarmSignal(String prsPAlarmSignal) {
        this.prsPAlarmSignal = prsPAlarmSignal;
    }

    public String getPrsCompressionKey() {
        return prsCompressionKey;
    }

    public void setPrsCompressionKey(String prsCompressionKey) {
        this.prsCompressionKey = prsCompressionKey;
    }

    public String getPrsCompressionAlarmNum() {
        return prsCompressionAlarmNum;
    }

    public void setPrsCompressionAlarmNum(String prsCompressionAlarmNum) {
        this.prsCompressionAlarmNum = prsCompressionAlarmNum;
    }

    public String getPrsRemarkFlag() {
        return prsRemarkFlag;
    }

    public void setPrsRemarkFlag(String prsRemarkFlag) {
        this.prsRemarkFlag = prsRemarkFlag;
    }

    public Date getPrsLoadDbTime() {
        return prsLoadDbTime;
    }

    public void setPrsLoadDbTime(Date prsLoadDbTime) {
        this.prsLoadDbTime = prsLoadDbTime;
    }

    public String getPhdVendorIdName() {
        return phdVendorIdName;
    }

    public void setPhdVendorIdName(String phdVendorIdName) {
        this.phdVendorIdName = phdVendorIdName;
    }

    public String getStdSpecialtyTypeName() {
        return stdSpecialtyTypeName;
    }

    public void setStdSpecialtyTypeName(String stdSpecialtyTypeName) {
        this.stdSpecialtyTypeName = stdSpecialtyTypeName;
    }

    public String getStdFlagName() {
        return stdFlagName;
    }

    public void setStdFlagName(String stdFlagName) {
        this.stdFlagName = stdFlagName;
    }

    public String getOrgAlarmTypeName() {
        return orgAlarmTypeName;
    }

    public void setOrgAlarmTypeName(String orgAlarmTypeName) {
        this.orgAlarmTypeName = orgAlarmTypeName;
    }

    public String getPrsTtFlagName() {
        return prsTtFlagName;
    }

    public void setPrsTtFlagName(String prsTtFlagName) {
        this.prsTtFlagName = prsTtFlagName;
    }

    public String getPrsForwardFlagName() {
        return prsForwardFlagName;
    }

    public void setPrsForwardFlagName(String prsForwardFlagName) {
        this.prsForwardFlagName = prsForwardFlagName;
    }

    public String getPrsAckFlagName() {
        return prsAckFlagName;
    }

    public void setPrsAckFlagName(String prsAckFlagName) {
        this.prsAckFlagName = prsAckFlagName;
    }

    public String getStdSendItFlagName() {
        return stdSendItFlagName;
    }

    public void setStdSendItFlagName(String stdSendItFlagName) {
        this.stdSendItFlagName = stdSendItFlagName;
    }

    public String getOrgAlarmStatusName() {
        return orgAlarmStatusName;
    }

    public void setOrgAlarmStatusName(String orgAlarmStatusName) {
        this.orgAlarmStatusName = orgAlarmStatusName;
    }

    public String getAlarmResourceStatusName() {
        return alarmResourceStatusName;
    }

    public void setAlarmResourceStatusName(String alarmResourceStatusName) {
        this.alarmResourceStatusName = alarmResourceStatusName;
    }

    public String getPreprocessMannerName() {
        return preprocessMannerName;
    }

    public void setPreprocessMannerName(String preprocessMannerName) {
        this.preprocessMannerName = preprocessMannerName;
    }

    public String getTicketConfirmMannerName() {
        return ticketConfirmMannerName;
    }

    public void setTicketConfirmMannerName(String ticketConfirmMannerName) {
        this.ticketConfirmMannerName = ticketConfirmMannerName;
    }

    public String getResCityIdName() {
        return resCityIdName;
    }

    public void setResCityIdName(String resCityIdName) {
        this.resCityIdName = resCityIdName;
    }

    public String getStdInmsSeverityName() {
        return stdInmsSeverityName;
    }

    public void setStdInmsSeverityName(String stdInmsSeverityName) {
        this.stdInmsSeverityName = stdInmsSeverityName;
    }
}
