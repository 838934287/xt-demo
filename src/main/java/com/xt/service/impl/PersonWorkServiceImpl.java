package com.xt.service.impl;

import com.xt.dao.PersonWorkDao;
import com.xt.entity.PersonWork;
import com.xt.service.PersonWorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonWork)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 20:26:40
 */
@Service("personWorkService")
public class PersonWorkServiceImpl implements PersonWorkService {
    @Resource
    private PersonWorkDao personWorkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PersonWork queryById(Long id) {
        return this.personWorkDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PersonWork> queryAllByLimit(int offset, int limit) {
        return this.personWorkDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param personWork 实例对象
     * @return 实例对象
     */
    @Override
    public PersonWork insert(PersonWork personWork) {
        this.personWorkDao.insert(personWork);
        return personWork;
    }

    /**
     * 修改数据
     *
     * @param personWork 实例对象
     * @return 实例对象
     */
    @Override
    public PersonWork update(PersonWork personWork) {
        this.personWorkDao.update(personWork);
        return this.queryById(personWork.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.personWorkDao.deleteById(id) > 0;
    }
}