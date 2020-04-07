package com.xt.service.impl;

import com.xt.dao.PersonDao;
import com.xt.dao.UserAuthDao;
import com.xt.entity.Person;
import com.xt.entity.UserAuth;
import com.xt.service.PersonService;
import com.xt.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Person)表服务实现类
 *
 * @author makejava
 * @since 2020-03-28 10:22:16
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;
    @Resource
    private UserAuthDao userAuthDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Person queryById(Long id) {
        return this.personDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Person> queryAllByLimit(int offset, int limit) {
        return this.personDao.queryAllByLimit(offset, limit);
    }

    /**
     * 根据条件查询
     * @param person
     * @return
     */

    @Override
    public List<Person> queryAllByCondition(Person person){
        return this.personDao.queryAll(person);
    }

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person insert(Person person) {
        this.personDao.insert(person);
        return person;
    }

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    @Override
    public Person update(Person person) {
        this.personDao.update(person);
        return this.queryById(person.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.personDao.deleteById(id) > 0;
    }

    @Override
    public List getUserRoleAuth(String username){
        List resultList = new ArrayList() ;
        Person p = new Person();
        p.setName(username);
        List list = this.personDao.queryAll(p);
        Person person = (Person) list.get(0);
        String role = person.getRole().toString();
        UserAuth u = new UserAuth();
        u.setRole(role);
        u.setStatus("0");
        List<UserAuth> uList = this.userAuthDao.queryByConditon(u);
        List<UserAuth> outList = new ArrayList<>();
        List<Map> outList1 = new ArrayList<>();
        //获取第一节点
        for(UserAuth ua1:uList){
            if(null==ua1.getPid()){
                outList.add(ua1);
            }
        }
//        获取递归子节点
        for(UserAuth parent:outList){
            parent = recursiveTree(parent,uList);
            Map outMap = deleteSubs(parent);
            outList1.add(outMap);
        }

        return outList1;
    }



    public static UserAuth recursiveTree(UserAuth parent, List<UserAuth> list) {
        for (UserAuth ua : list) {
            if(parent.getId() == ua.getPid()) {
                ua = recursiveTree(ua, list);
                parent.getSubs().add(ua);
            }
        }


        return parent;
    }
    public static Map deleteSubs(UserAuth parent){
//        Map map=new HashMap(BeanMap.create(parent));
        Map<String,Object> map = new HashMap<String,Object>();
        map= BeanUtils.beanToMap(parent);

        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if (entry.getKey().toUpperCase().equals("SUBS")) {
//                System.out.println("KEY:--    " + entry.getKey());
                List list = (List) map.get(entry.getKey());
                if (list.size() == 0) {
                    it.remove();//使用迭代器的remove()方法删除元素
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        UserAuth ua = (UserAuth) list.get(i);
                        ((List) map.get(entry.getKey())).remove(i);
                        ((List) map.get(entry.getKey())).add(0,deleteSubs(ua));
                    }
                }
            }

        }

        return map;
    }


}