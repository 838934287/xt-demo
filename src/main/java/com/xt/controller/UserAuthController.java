package com.xt.controller;

import com.xt.entity.UserAuth;
import com.xt.service.UserAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserAuth)表控制层
 *
 * @author makejava
 * @since 2020-03-28 19:56:30
 */
@RestController
@RequestMapping("userAuth")
public class UserAuthController {
    /**
     * 服务对象
     */
    @Resource
    private UserAuthService userAuthService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserAuth selectOne(Integer id) {
        return this.userAuthService.queryById(id);
    }

}