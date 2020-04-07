package com.xt.service;

import com.xt.entity.PersonProject;

import java.util.List;

/**
 * (PersonProject)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
public interface PersonProjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonProject queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonProject> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param personProject 实例对象
     * @return 实例对象
     */
    PersonProject insert(PersonProject personProject);

    /**
     * 修改数据
     *
     * @param personProject 实例对象
     * @return 实例对象
     */
    PersonProject update(PersonProject personProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}