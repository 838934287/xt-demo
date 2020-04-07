package com.xt.dao;

import com.xt.entity.PersonEdu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PersonEdu)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 20:26:39
 */
public interface PersonEduDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonEdu queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonEdu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param personEdu 实例对象
     * @return 对象列表
     */
    List<PersonEdu> queryAll(PersonEdu personEdu);

    /**
     * 新增数据
     *
     * @param personEdu 实例对象
     * @return 影响行数
     */
    int insert(PersonEdu personEdu);

    /**
     * 修改数据
     *
     * @param personEdu 实例对象
     * @return 影响行数
     */
    int update(PersonEdu personEdu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}