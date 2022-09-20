package org.hthu.test;

import java.io.Serializable;

/**
 * Description:监听隐私号消息实体类
 *
 * @author cheng.bai
 * @version 1.0
 * @since 2021/6/24.
 */
public class CallRecordMessageDto implements Serializable {
    private String bizType;
    /**
     * 绑定ID
     */
    private String bindId;

    /**
     * callId
     */
    private String callId;

    /**
     * 主叫
     */
    private String callerNum;

    /**
     * 被叫
     */
    private String calledNum;

    /**
     * 中间号
     */
    private String middleNum;

    /**
     * phoneA
     */
    private String phoneA;

    /**
     * phoneB
     */
    private String phoneB;

    /**
     * aRelId
     */
    private String aRelId;

    /**
     * bRelId
     */
    private String bRelId;

    private String businessId;

    /**
     * 主叫拨出时间
     */
    private String callOutTime;

    /**
     * 被叫应答时间
     */
    private String callInTime;

    /**
     * 挂断时间
     */
    private String disconnectTime;

    /**
     * 通话时长
     */
    private Integer duration;

    /**
     * 被叫挂断原因
     */
    private String calledRelCause;

    /**
     * 货源Id
     */
    private Long cargoId;

    /**
     * 话单状态 0:正常；1：拒接；2：关机；3：空号；4：停机；5：被叫无应答；6：被叫忙
     */
    private Integer status;

    private Long time;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCallerNum() {
        return callerNum;
    }

    public void setCallerNum(String callerNum) {
        this.callerNum = callerNum;
    }

    public String getCalledNum() {
        return calledNum;
    }

    public void setCalledNum(String calledNum) {
        this.calledNum = calledNum;
    }

    public String getMiddleNum() {
        return middleNum;
    }

    public void setMiddleNum(String middleNum) {
        this.middleNum = middleNum;
    }

    public String getPhoneA() {
        return phoneA;
    }

    public void setPhoneA(String phoneA) {
        this.phoneA = phoneA;
    }

    public String getPhoneB() {
        return phoneB;
    }

    public void setPhoneB(String phoneB) {
        this.phoneB = phoneB;
    }

    public String getaRelId() {
        return aRelId;
    }

    public void setaRelId(String aRelId) {
        this.aRelId = aRelId;
    }

    public String getbRelId() {
        return bRelId;
    }

    public void setbRelId(String bRelId) {
        this.bRelId = bRelId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCallOutTime() {
        return callOutTime;
    }

    public void setCallOutTime(String callOutTime) {
        this.callOutTime = callOutTime;
    }

    public String getCallInTime() {
        return callInTime;
    }

    public void setCallInTime(String callInTime) {
        this.callInTime = callInTime;
    }

    public String getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(String disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCalledRelCause() {
        return calledRelCause;
    }

    public void setCalledRelCause(String calledRelCause) {
        this.calledRelCause = calledRelCause;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CallRecordMessageDto{" +
                "bizType='" + bizType + '\'' +
                ", bindId='" + bindId + '\'' +
                ", callId='" + callId + '\'' +
                ", callerNum='" + callerNum + '\'' +
                ", calledNum='" + calledNum + '\'' +
                ", middleNum='" + middleNum + '\'' +
                ", phoneA='" + phoneA + '\'' +
                ", phoneB='" + phoneB + '\'' +
                ", aRelId='" + aRelId + '\'' +
                ", bRelId='" + bRelId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", callOutTime='" + callOutTime + '\'' +
                ", callInTime='" + callInTime + '\'' +
                ", disconnectTime='" + disconnectTime + '\'' +
                ", duration=" + duration +
                ", calledRelCause='" + calledRelCause + '\'' +
                ", cargoId=" + cargoId +
                ", status=" + status +
                ", time=" + time +
                '}';
    }
}
