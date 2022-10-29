package org.hthu.test;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2022/10/17
 */
public class CallRecordDto {

    /**
     * 货主id
     */
    private Long toUid;

    /**
     * 司机id
     */
    private Long fromUid;

    /**
     * 货源id
     */
    private Long cargoId;

    /**
     * 最新通话时间，排序取最新
     */
    private Long lastMessageTime;

    /**
     * 通话时长
     */
    private Long callDuration;

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Long getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(Long lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

    public Long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Long callDuration) {
        this.callDuration = callDuration;
    }

    @Override
    public String toString() {
        return "CallRecordDto{" +
                "toUid=" + toUid +
                ", fromUid=" + fromUid +
                ", cargoId=" + cargoId +
                ", lastMessageTime=" + lastMessageTime +
                ", callDuration=" + callDuration +
                '}';
    }
}
