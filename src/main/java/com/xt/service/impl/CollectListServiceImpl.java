package com.xt.service.impl;

import com.xt.dao.CollectListDao;
import com.xt.entity.CollectList;
import com.xt.service.CollectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (CollectList)表服务实现类
 *
 * @author makejava
 * @since 2020-02-15 17:00:58
 */
@Service("collectListService")
public class CollectListServiceImpl implements CollectListService {
    @Resource
    private CollectListDao collectListDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CollectList queryById(Long id) {
        return this.collectListDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CollectList> queryAllByLimit(int offset, int limit) {
        return this.collectListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param collectList 实例对象
     * @return 实例对象
     */
    @Override
    public CollectList insert(CollectList collectList) {
        this.collectListDao.insert(collectList);
        return collectList;
    }

    /**
     * 修改数据
     *
     * @param collectList 实例对象
     * @return 实例对象
     */
    @Override
    public CollectList update(CollectList collectList) {
        this.collectListDao.update(collectList);
        return this.queryById(collectList.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.collectListDao.deleteById(id) > 0;
    }


    /**
     * 查询全部收藏夹
     *
     */
    @Override
    public List queryAllCollect(){
        List outList = new ArrayList();
        List<CollectList> list = this.collectListDao.queryAllCollect();
        for(CollectList collectList:list){
            Map outMap = new HashMap();
            outMap.put("id",collectList.getId());
            outMap.put("collectName",collectList.getCollectName());
            outList.add(outMap);
        }

        return outList;
    }


}