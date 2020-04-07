package com.xt.controller;

import com.xt.entity.Person;
import com.xt.service.PersonService;
import com.xt.service.UserAuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Person)表控制层
 *
 * @author makejava
 * @since 2020-03-28 10:22:16
 */
@RestController
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;
    @Resource
    private UserAuthService userAuthService;

    /**
     * 通过主键查询单条数据
     *
     * @param username&password
     * @return 单条数据
     */
    @ApiOperation(value = "用户登录",notes = "注意事项....",httpMethod = "POST")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Map login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        Map resultMap = new HashMap();
        String status = "0";
        String message = "登陆成功";


        Person person = new Person();
        person.setName(username);
        person.setPassword(password);
        List<Person> pList = this.personService.queryAllByCondition(person);
        if(pList.size()!=1){
            status = "1";
            message="用户不存在";
            Map map1 = new HashMap();
            map1.put("username",username);
            map1.put("status",status);
            map1.put("message",message);
            Map outMap = new HashMap();
            outMap.put("user",map1);
            resultMap = outMap;
        }else {
            Map map1 = new HashMap();
            Map outMap = new HashMap();
            request.setAttribute("username",username);

            map1.put("username",username);
            map1.put("status",status);
            map1.put("message",message);
            outMap.put("user",map1);
            List list1 = this.personService.getUserRoleAuth(username);
            outMap.put("items",list1 );
            resultMap = outMap;
        };
            return resultMap;

    }

}