package com.xt.controller;

import com.xt.entity.PersonEdu;
import com.xt.service.PersonEduService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PersonEdu)表控制层
 *
 * @author makejava
 * @since 2020-03-03 20:26:39
 */
@RestController
@RequestMapping("personEdu")
public class PersonEduController {
    /**
     * 服务对象
     */
    @Resource
    private PersonEduService personEduService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PersonEdu selectOne(Long id) {
        return this.personEduService.queryById(id);
    }

}