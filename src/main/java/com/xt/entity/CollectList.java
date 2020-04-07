package com.xt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CollectList)实体类
 *
 * @author makejava
 * @since 2020-02-15 17:00:58
 */
public class CollectList implements Serializable {
    private static final long serialVersionUID = 596342695243243907L;
    
    private Long id;
    
    private Long collectId;
    
    private String collectName;
    
    private Date generateDate;
    
    private String generateUser;
    
    private Date lastUpdateDate;
    
    private String lastUpdateUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

    public String getGenerateUser() {
        return generateUser;
    }

    public void setGenerateUser(String generateUser) {
        this.generateUser = generateUser;
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

}