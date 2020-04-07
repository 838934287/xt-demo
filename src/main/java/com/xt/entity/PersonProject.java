package com.xt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (PersonProject)实体类
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
public class PersonProject implements Serializable {
    private static final long serialVersionUID = 893787746850151484L;
    
    private Long id;
    
    private Long personId;
    
    private String projectDesc;
    
    private Date createDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}