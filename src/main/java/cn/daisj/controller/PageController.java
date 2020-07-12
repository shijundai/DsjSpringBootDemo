package cn.daisj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @RequestMapping("/testPage")
    public String testPage(HttpServletRequest request, HttpSession session, ModelMap map) {
        request.setAttribute("reqAttr","Reqeust Attribetu");
        session.setAttribute("sessionAttr", "Session Attribute");
        map.put("modeMapKey1","Mode Map Value1");
        map.put("modeMapInt",1);
        System.out.println("testPage.....  ");

        Map<String,Object> obj = new HashMap<>();
        obj.put("name","Dsj");
        obj.put("age",30);
        obj.put("sex","man");
        map.put("obj",obj);
        return "test";
    }

    @RequestMapping("/resolver")
    public String dsj(HttpServletRequest request, HttpSession session, ModelMap map) {

        return "testResolver";
    }

}
