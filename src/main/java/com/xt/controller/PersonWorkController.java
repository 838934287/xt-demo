package com.xt.controller;

import com.xt.entity.PersonWork;
import com.xt.service.PersonWorkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (PersonWork)表控制层
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
@RestController
@RequestMapping("personWork")
public class PersonWorkController {
    /**
     * 服务对象
     */
    @Resource
    private PersonWorkService personWorkService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PersonWork selectOne(Long id) {
        return this.personWorkService.queryById(id);
    }

}