package com.xt.service.impl;

import com.xt.dao.PersonProjectDao;
import com.xt.entity.PersonProject;
import com.xt.service.PersonProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonProject)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
@Service("personProjectService")
public class PersonProjectServiceImpl implements PersonProjectService {
    @Resource
    private PersonProjectDao personProjectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PersonProject queryById(Long id) {
        return this.personProjectDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PersonProject> queryAllByLimit(int offset, int limit) {
        return this.personProjectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param personProject 实例对象
     * @return 实例对象
     */
    @Override
    public PersonProject insert(PersonProject personProject) {
        this.personProjectDao.insert(personProject);
        return personProject;
    }

    /**
     * 修改数据
     *
     * @param personProject 实例对象
     * @return 实例对象
     */
    @Override
    public PersonProject update(PersonProject personProject) {
        this.personProjectDao.update(personProject);
        return this.queryById(personProject.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.personProjectDao.deleteById(id) > 0;
    }
}