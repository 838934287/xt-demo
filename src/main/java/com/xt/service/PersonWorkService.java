package com.xt.service;

import com.xt.entity.PersonWork;

import java.util.List;

/**
 * (PersonWork)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
public interface PersonWorkService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonWork queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonWork> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param personWork 实例对象
     * @return 实例对象
     */
    PersonWork insert(PersonWork personWork);

    /**
     * 修改数据
     *
     * @param personWork 实例对象
     * @return 实例对象
     */
    PersonWork update(PersonWork personWork);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}