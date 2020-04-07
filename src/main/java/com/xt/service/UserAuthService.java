package com.xt.service;

import com.xt.entity.UserAuth;

import java.util.List;

/**
 * (UserAuth)表服务接口
 *
 * @author makejava
 * @since 2020-03-28 19:56:30
 */
public interface UserAuthService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAuth queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserAuth> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userAuth 实例对象
     * @return 实例对象
     */
    UserAuth insert(UserAuth userAuth);

    /**
     * 修改数据
     *
     * @param userAuth 实例对象
     * @return 实例对象
     */
    UserAuth update(UserAuth userAuth);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据条件查询
     * @param userAuth
     * @return
     */
    List<UserAuth> queryByConditon(UserAuth userAuth);


}