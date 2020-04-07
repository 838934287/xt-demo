package com.xt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (PersonEdu)实体类
 *
 * @author makejava
 * @since 2020-03-03 20:26:39
 */
public class PersonEdu implements Serializable {
    private static final long serialVersionUID = -87177699477169876L;
    
    private Long id;
    
    private Long personId;
    
    private String eduStartDate;
    
    private String eduEndDate;
    
    private String two;
    
    private String nine;
    
    private String schoolName;
    
    private String major;
    
    private String degree;
    
    private String tongZhao;
    
    private String majorDesc;
    
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

    public String getEduStartDate() {
        return eduStartDate;
    }

    public void setEduStartDate(String eduStartDate) {
        this.eduStartDate = eduStartDate;
    }

    public String getEduEndDate() {
        return eduEndDate;
    }

    public void setEduEndDate(String eduEndDate) {
        this.eduEndDate = eduEndDate;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTongZhao() {
        return tongZhao;
    }

    public void setTongZhao(String tongZhao) {
        this.tongZhao = tongZhao;
    }

    public String getMajorDesc() {
        return majorDesc;
    }

    public void setMajorDesc(String majorDesc) {
        this.majorDesc = majorDesc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}