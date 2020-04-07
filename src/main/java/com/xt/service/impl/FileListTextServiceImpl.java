package com.xt.service.impl;

import com.xt.dao.FileListTextDao;
import com.xt.entity.FileListText;
import com.xt.service.FileListTextService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FileListText)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 19:41:34
 */
@Service("fileListTextService")
public class FileListTextServiceImpl implements FileListTextService {
    @Resource
    private FileListTextDao fileListTextDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public FileListText queryById(Integer id) {
        return this.fileListTextDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<FileListText> queryAllByLimit(int offset, int limit) {
        return this.fileListTextDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param fileListText 实例对象
     * @return 实例对象
     */
    @Override
    public FileListText insert(FileListText fileListText) {
        this.fileListTextDao.insert(fileListText);
        return fileListText;
    }

    /**
     * 修改数据
     *
     * @param fileListText 实例对象
     * @return 实例对象
     */
    @Override
    public FileListText update(FileListText fileListText) {
        this.fileListTextDao.update(fileListText);
        return this.queryById(fileListText.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.fileListTextDao.deleteById(id) > 0;
    }
}