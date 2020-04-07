package com.xt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (FileListText)实体类
 *
 * @author makejava
 * @since 2020-03-03 19:41:30
 */
public class FileListText implements Serializable {
    private static final long serialVersionUID = 687808449670096297L;
    
    private Integer id;
    
    private Integer fileListId;
    
    private String text;
    
    private Date createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileListId() {
        return fileListId;
    }

    public void setFileListId(Integer fileListId) {
        this.fileListId = fileListId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}