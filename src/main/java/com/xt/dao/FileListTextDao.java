package com.xt.dao;

import com.xt.entity.FileListText;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FileListText)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 19:41:33
 */
public interface FileListTextDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FileListText queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FileListText> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fileListText 实例对象
     * @return 对象列表
     */
    List<FileListText> queryAll(FileListText fileListText);

    /**
     * 新增数据
     *
     * @param fileListText 实例对象
     * @return 影响行数
     */
    int insert(FileListText fileListText);

    /**
     * 修改数据
     *
     * @param fileListText 实例对象
     * @return 影响行数
     */
    int update(FileListText fileListText);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}