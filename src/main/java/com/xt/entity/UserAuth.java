package com.xt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (UserAuth)实体类
 *
 * @author makejava
 * @since 2020-03-28 19:56:30
 */
public class UserAuth implements Serializable {
    private static final long serialVersionUID = 797147857382061348L;
    
    private Integer id;
    
    private Integer pid;
    
    private String level;
    
    private String icon;
    
    private String index;
    
    private String title;
    
    private String hasChild;
    
    private String role;
    
    private String status;




    private List<UserAuth> subs = new ArrayList<UserAuth>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserAuth> getSubs() {
        return subs;
    }

    public void setSubs(List<UserAuth> subs) {
        this.subs = subs;
    }

}