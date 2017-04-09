package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maryniederschmidt on 3/6/17.
 */
@Controller
public class HelloController{

    // To call this method - localhost:8080/?name=Chris
    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    // To call this method - localhost:8080/hello
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");

        return "Hello " + name;
    }

    // To call this method - localhost:8080/hello/Chris
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

/*    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye";
    }
*/

    // To call this method - localhost:8080/goodbye
    @RequestMapping(value = "goodbye")
    public String goodbye() {

        return "redirect:/";
        // return "redirect:/hello";

    }
}
