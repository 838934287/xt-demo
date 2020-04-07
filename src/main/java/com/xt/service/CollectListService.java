package com.xt.service;

import com.xt.entity.CollectList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * (CollectList)表服务接口
 *
 * @author makejava
 * @since 2020-02-15 17:00:58
 */
public interface CollectListService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CollectList queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CollectList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param collectList 实例对象
     * @return 实例对象
     */
    CollectList insert(CollectList collectList);

    /**
     * 修改数据
     *
     * @param collectList 实例对象
     * @return 实例对象
     */
    CollectList update(CollectList collectList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    /*
    * 查询全部收藏夹
    * */
    List queryAllCollect();



}