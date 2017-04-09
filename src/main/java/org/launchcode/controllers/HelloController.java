package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maryniederschmidt on 3/6/17.
 */
@Controller
public class HelloController{

    @RequestMapping(value="")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye";
    }

}
