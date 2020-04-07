package com.xt.dao;

import com.xt.entity.PersonWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PersonWork)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
public interface PersonWorkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonWork queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonWork> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param personWork 实例对象
     * @return 对象列表
     */
    List<PersonWork> queryAll(PersonWork personWork);

    /**
     * 新增数据
     *
     * @param personWork 实例对象
     * @return 影响行数
     */
    int insert(PersonWork personWork);

    /**
     * 修改数据
     *
     * @param personWork 实例对象
     * @return 影响行数
     */
    int update(PersonWork personWork);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}