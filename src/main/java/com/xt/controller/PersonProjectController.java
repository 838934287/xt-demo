package com.xt.controller;

import com.xt.entity.PersonProject;
import com.xt.service.PersonProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PersonProject)表控制层
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
@RestController
@RequestMapping("personProject")
public class PersonProjectController {
    /**
     * 服务对象
     */
    @Resource
    private PersonProjectService personProjectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PersonProject selectOne(Long id) {
        return this.personProjectService.queryById(id);
    }

}