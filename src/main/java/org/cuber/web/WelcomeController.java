package org.cuber.web;

import org.cuber.service.MybatisDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by cuber on 2016/1/21.
 */
@Controller
public class WelcomeController {
    @Autowired
    private MybatisDBService service;

    @Value("${application.message:Hello world 2}")
    private String message = "Hello world 3";

    @RequestMapping("/welcome.htm")
    public String welcome(Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/admin.htm")
    public String admin(Map<String, Object> model){
        model.put("time", service.getTime());
        model.put("message", this.message);
        return "welcome";
    }
    @RequestMapping("/login.htm")
    public String login(Map<String, Object> model, HttpServletRequest request){
        model.put("error", false);
        HttpSession session=request.getSession();
        session.setAttribute("login", "123");
        return "login";
    }
    @RequestMapping("/loginfailed.htm")
    public String loginfailed(ModelMap model){
        model.addAttribute("error", true);
        return "login";
    }
}
