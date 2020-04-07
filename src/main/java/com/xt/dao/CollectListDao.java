package com.xt.dao;

import com.xt.entity.CollectList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CollectList)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-15 17:00:58
 */

public interface CollectListDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CollectList queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CollectList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param collectList 实例对象
     * @return 对象列表
     */
    List<CollectList> queryAll(CollectList collectList);

    /**
     * 新增数据
     *
     * @param collectList 实例对象
     * @return 影响行数
     */
    int insert(CollectList collectList);

    /**
     * 修改数据
     *
     * @param collectList 实例对象
     * @return 影响行数
     */
    int update(CollectList collectList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    List<CollectList> queryAllCollect();

}