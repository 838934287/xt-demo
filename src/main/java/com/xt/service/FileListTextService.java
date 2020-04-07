package com.xt.service;

import com.xt.entity.FileListText;

import java.util.List;

/**
 * (FileListText)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 19:41:34
 */
public interface FileListTextService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FileListText queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FileListText> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param fileListText 实例对象
     * @return 实例对象
     */
    FileListText insert(FileListText fileListText);

    /**
     * 修改数据
     *
     * @param fileListText 实例对象
     * @return 实例对象
     */
    FileListText update(FileListText fileListText);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}