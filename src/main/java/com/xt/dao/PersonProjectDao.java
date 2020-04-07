package com.xt.dao;

import com.xt.entity.PersonProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PersonProject)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
public interface PersonProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonProject queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonProject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param personProject 实例对象
     * @return 对象列表
     */
    List<PersonProject> queryAll(PersonProject personProject);

    /**
     * 新增数据
     *
     * @param personProject 实例对象
     * @return 影响行数
     */
    int insert(PersonProject personProject);

    /**
     * 修改数据
     *
     * @param personProject 实例对象
     * @return 影响行数
     */
    int update(PersonProject personProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}