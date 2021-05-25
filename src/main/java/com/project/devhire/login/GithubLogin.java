package com.project.devhire.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GithubLogin {

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "loginPage";
    }

}
