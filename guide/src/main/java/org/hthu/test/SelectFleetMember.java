package org.hthu.test;

import java.io.Serializable;

/**
 * @author haitao.hu2
 * @version 0.0.1
 * @date 2023/3/2
 */
public class SelectFleetMember  {

    private static final long serialVersionUID = -6890234115623104280L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 置灰展示；true：置灰；false/null 不置灰
     */
    private Boolean grayShowFlag;

    /**
     * 成员过滤标识
     */
    private Integer filterType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Boolean getGrayShowFlag() {
        return grayShowFlag;
    }

    public void setGrayShowFlag(Boolean grayShowFlag) {
        this.grayShowFlag = grayShowFlag;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    @Override
    public String toString() {
        return "SelectFleetMember{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", grayShowFlag=" + grayShowFlag +
                ", filterType=" + filterType +
                '}';
    }
}
