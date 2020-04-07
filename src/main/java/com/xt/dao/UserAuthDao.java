package com.xt.dao;

import com.xt.entity.UserAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserAuth)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-28 19:56:30
 */
public interface UserAuthDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAuth queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserAuth> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userAuth 实例对象
     * @return 对象列表
     */
    List<UserAuth> queryAll(UserAuth userAuth);

    /**
     * 新增数据
     *
     * @param userAuth 实例对象
     * @return 影响行数
     */
    int insert(UserAuth userAuth);

    /**
     * 修改数据
     *
     * @param userAuth 实例对象
     * @return 影响行数
     */
    int update(UserAuth userAuth);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<UserAuth> queryByConditon(UserAuth userAuth);

}