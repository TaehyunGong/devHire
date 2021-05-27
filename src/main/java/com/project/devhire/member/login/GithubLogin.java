package com.project.devhire.member.login;

import com.project.devhire.common.HttpConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GithubLogin {

    private final String CLIENT_ID = "";
    private final String CLIENT_SECRET = "";

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "member/login/loginPage";
    }

    @RequestMapping(value = "/githubLogin", method = RequestMethod.GET)
    public @ResponseBody String githubLogin(@RequestParam(value = "code", defaultValue = "false") String code) throws IOException {

        Map<String, String> param = new HashMap<String, String>();
        param.put("client_id", CLIENT_ID);
        param.put("client_secret", CLIENT_SECRET);
        param.put("code", code);

        HttpConnection httpConnection = new HttpConnection();
        final StringBuffer result = httpConnection.HttpPostConnection("https://github.com/login/oauth/access_token", param);

        return result.toString();
    }

}
