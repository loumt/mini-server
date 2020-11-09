package com.mini.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mini.base.DeleteFlag;

import java.io.Serializable;
import java.util.Date;

/**
 * @Filename: AppResponseProcess
 * @Description: App端响应流程
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 16:58
 */
public class AppResponseProcess implements Serializable {
    private static final long serialVersionUID = 6644314825114148332L;
    private Long id;
    private String response;
    private Integer maxTryCount;
    private Integer maxTryMinutes;
    private Integer intervalMinutes;
    private Long nextProcessId;
    private DeleteFlag isDelete;
    private Integer processType;
    private Long creator;
    private Long updator;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;


    /**
     * @return Returns the nextProcessId
     */
    public Long getNextProcessId() {
        return nextProcessId;
    }

    /**
     * @param nextProcessId The nextProcessId to set.
     */
    public void setNextProcessId(Long nextProcessId) {
        this.nextProcessId = nextProcessId;
    }

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
     * @return Returns the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response The response to set.
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return Returns the maxTryCount
     */
    public Integer getMaxTryCount() {
        return maxTryCount;
    }

    /**
     * @param maxTryCount The maxTryCount to set.
     */
    public void setMaxTryCount(Integer maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    /**
     * @return Returns the maxTryMinutes
     */
    public Integer getMaxTryMinutes() {
        return maxTryMinutes;
    }

    /**
     * @param maxTryMinutes The maxTryMinutes to set.
     */
    public void setMaxTryMinutes(Integer maxTryMinutes) {
        this.maxTryMinutes = maxTryMinutes;
    }

    /**
     * @return Returns the intervalMinutes
     */
    public Integer getIntervalMinutes() {
        return intervalMinutes;
    }

    /**
     * @param intervalMinutes The intervalMinutes to set.
     */
    public void setIntervalMinutes(Integer intervalMinutes) {
        this.intervalMinutes = intervalMinutes;
    }

    /**
     * @return Returns the creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator The creator to set.
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return Returns the updator
     */
    public Long getUpdator() {
        return updator;
    }

    /**
     * @return Returns the isDelete
     */
    public DeleteFlag getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete The isDelete to set.
     */
    public void setIsDelete(DeleteFlag isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @param updator The updator to set.
     */
    public void setUpdator(Long updator) {
        this.updator = updator;
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
