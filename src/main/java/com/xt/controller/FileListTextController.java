package com.xt.controller;

import com.xt.entity.FileListText;
import com.xt.service.FileListTextService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (FileListText)表控制层
 *
 * @author makejava
 * @since 2020-03-03 19:41:35
 */
@RestController
@RequestMapping("fileListText")
public class FileListTextController {
    /**
     * 服务对象
     */
    @Resource
    private FileListTextService fileListTextService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public FileListText selectOne(Integer id) {
        return this.fileListTextService.queryById(id);
    }

}