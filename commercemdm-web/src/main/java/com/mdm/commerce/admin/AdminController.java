package com.mdm.commerce.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by raghavan on 11/21/17.
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {


    @RequestMapping("/index")
    public String index(){
        System.out.println("Inside index() of AdminController!!!!");
        return "index";
    }
}
