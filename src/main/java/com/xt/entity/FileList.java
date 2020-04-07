package com.xt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * (FileList)实体类
 *
 * @author makejava
 * @since 2020-02-15 16:55:47
 */
@ApiModel(value = "just have a try")
public class FileList implements Serializable {
    private static final long serialVersionUID = -43699360322480459L;
    @ApiModelProperty(value = "主键ID...")
    private Long id;
    
    private Long fileId;
    
    private String fileName;
    
    private Long collectId;
    
    private Date uploadDate;
    
    private Date lastUpdateDate;
    
    private String lastUpdateUser;
    
    private String uplaodUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public String getUplaodUser() {
        return uplaodUser;
    }

    public void setUplaodUser(String uplaodUser) {
        this.uplaodUser = uplaodUser;
    }

}