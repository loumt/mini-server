package com.mini.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mini.base.CheckType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Filename: AppResponse
 * @Description: App端响应
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 18:07
 */
public class AppResponse  implements Serializable {
    private static final long serialVersionUID = -179708145008414008L;
    private Long id;
    private Long processId;
    private Long userId;
    private Long deviceSleepId;
    private String abnormalClass;
    private Long nextProcessId;
    private CheckType isOut;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * @return Returns the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the processId
     */
    public Long getProcessId() {
        return processId;
    }

    /**
     * @param processId The processId to set.
     */
    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    /**
     * @return Returns the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId The userId to set.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return Returns the deviceSleepId
     */
    public Long getDeviceSleepId() {
        return deviceSleepId;
    }

    /**
     * @param deviceSleepId The deviceSleepId to set.
     */
    public void setDeviceSleepId(Long deviceSleepId) {
        this.deviceSleepId = deviceSleepId;
    }

    /**
     * @return Returns the abnormalClass
     */
    public String getAbnormalClass() {
        return abnormalClass;
    }

    /**
     * @param abnormalClass The abnormalClass to set.
     */
    public void setAbnormalClass(String abnormalClass) {
        this.abnormalClass = abnormalClass;
    }

    /**
     * @return Returns the isOut
     */
    public CheckType getIsOut() {
        return isOut;
    }

    /**
     * @param isOut The isOut to set.
     */
    public void setIsOut(CheckType isOut) {
        this.isOut = isOut;
    }

    /**
     * @return Returns the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate The createDate to set.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return Returns the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate The updateDate to set.
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
