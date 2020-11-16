package io.tomo.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/tes3")
    public String test3(int num){
        int i=5/num;
        return "success";
    }
    @RequestMapping("/test2")
    public String test2(){
        String str=null;
        str.toString();
        return "success";
    }
}
