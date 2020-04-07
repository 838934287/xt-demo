package com.xt.dao;

import com.xt.entity.FileList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FileList)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-15 16:55:50
 */
public interface FileListDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FileList queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FileList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询FileList 中最大ID
     * @return 对象列表
     */
    List<FileList> queryMaxFileListId();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param fileList 实例对象
     * @return 对象列表
     */
    List<FileList> queryAll(FileList fileList);

    /**
     * 新增数据
     *
     * @param fileList 实例对象
     * @return 影响行数
     */
    int insert(FileList fileList);

    /**
     * 修改数据
     *
     * @param fileList 实例对象
     * @return 影响行数
     */
    int update(FileList fileList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List queryFileWithCollectName();

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<FileList> queryAllAddCollectByLimit();


}