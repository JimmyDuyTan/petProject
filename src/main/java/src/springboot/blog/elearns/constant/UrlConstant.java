package src.springboot.blog.elearns.constant;

import org.springframework.web.bind.annotation.RequestMapping;


public class UrlConstant {
    private UrlConstant(){}; //Use it into internal
    //define url login post HTTP
    public static final String USER_LOGIN = "/login";
    //define url logout post HTTP
    public static final String USER_LOGOUT = "/logout";
}
