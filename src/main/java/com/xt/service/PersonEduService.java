package com.xt.service;

import com.xt.entity.PersonEdu;

import java.util.List;

/**
 * (PersonEdu)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 20:26:39
 */
public interface PersonEduService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonEdu queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonEdu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param personEdu 实例对象
     * @return 实例对象
     */
    PersonEdu insert(PersonEdu personEdu);

    /**
     * 修改数据
     *
     * @param personEdu 实例对象
     * @return 实例对象
     */
    PersonEdu update(PersonEdu personEdu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}