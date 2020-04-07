package com.xt.service;

import com.xt.entity.FileList;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (FileList)表服务接口
 *
 * @author makejava
 * @since 2020-02-15 16:55:51
 */
public interface FileListService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FileList queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<FileList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param fileList 实例对象
     * @return 实例对象
     */
    FileList insert(FileList fileList);

    /**
     * 修改数据
     *
     * @param fileList 实例对象
     * @return 实例对象
     */
    FileList update(FileList fileList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 输出收藏夹不空的文件List
     * */
    Map queryFileWithCollectName();
    /*
    * 查询全部file  List*/
    Map queryFileList();



    /**
     * 保存上传附件
     * @return
     */

    boolean saveUplaodFile(MultipartFile file) throws IOException;


}