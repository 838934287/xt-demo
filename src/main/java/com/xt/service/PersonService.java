package com.xt.service;

import com.xt.entity.Person;

import java.util.List;

/**
 * (Person)表服务接口
 *
 * @author makejava
 * @since 2020-03-28 10:22:16
 */
public interface PersonService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Person queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Person> queryAllByLimit(int offset, int limit);

    /**
     * 根据条件查询
     * @param person
     * @return
     */

    List<Person> queryAllByCondition(Person person);

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person insert(Person person);

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person update(Person person);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 获取用户访问页面权限
     * @param username
     * @return
     */
    List getUserRoleAuth(String username);

}