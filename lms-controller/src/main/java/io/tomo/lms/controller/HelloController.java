package io.tomo.lms.controller;
import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UserNotFoundException;
import io.tomo.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: @RestController 当前类的所有方法返回值都直接响应给浏览器.
 */
@Controller
//@RestController //等同于@Controller+@ResponseBody
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody      //响应给浏览器
    public String hello(){
        return "Hello World";
    }


    @RequestMapping("/getMap")
    @ResponseBody      //响应给浏览器
    public Map<String,Object> getMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("msg","success");
        map.put("data","hello world");
        return map;
    }

    @RequestMapping("/test1")
    public String test1(Model model) {

        model.addAttribute("role","admin");
        System.out.println(userService.findAll());
        model.addAttribute("user", userService.findAll());
        try {
            model.addAttribute("user_1",userService.findById("001"));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "success";
    }
    @RequestMapping("/modify")
    @ResponseBody
    public String modify(@ModelAttribute("user_1") User user){
        System.out.println(user);
        return "修改成功";
    }
    @RequestMapping("/findUser")
    @ResponseBody
    public User findUser(String id){
        try {
            return userService.findById(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
