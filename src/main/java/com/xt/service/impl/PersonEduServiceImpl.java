package com.xt.service.impl;

import com.xt.dao.PersonEduDao;
import com.xt.entity.PersonEdu;
import com.xt.service.PersonEduService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonEdu)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 20:26:39
 */
@Service("personEduService")
public class PersonEduServiceImpl implements PersonEduService {
    @Resource
    private PersonEduDao personEduDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PersonEdu queryById(Long id) {
        return this.personEduDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PersonEdu> queryAllByLimit(int offset, int limit) {
        return this.personEduDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param personEdu 实例对象
     * @return 实例对象
     */
    @Override
    public PersonEdu insert(PersonEdu personEdu) {
        this.personEduDao.insert(personEdu);
        return personEdu;
    }

    /**
     * 修改数据
     *
     * @param personEdu 实例对象
     * @return 实例对象
     */
    @Override
    public PersonEdu update(PersonEdu personEdu) {
        this.personEduDao.update(personEdu);
        return this.queryById(personEdu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.personEduDao.deleteById(id) > 0;
    }
}