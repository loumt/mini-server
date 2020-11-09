package com.mini.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Filename: AppResponseRecord
 * @Description: App端响应详情记录
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 18:15
 */
public class AppResponseRecord  implements Serializable {
    private static final long serialVersionUID = 5930020600699038741L;
    private Long id;

    /**
     * 响应Id
     */
    private Long responseId;

    /**
     * 响应备注
     */
    private String remark;

    /**
     * 响应人Id
     */
    private Long creator;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /**
     * 响应时间
     */
    private Date createDate;

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
     * @return Returns the responseId
     */
    public Long getResponseId() {
        return responseId;
    }

    /**
     * @param responseId The responseId to set.
     */
    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    /**
     * @return Returns the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark The remark to set.
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
}
