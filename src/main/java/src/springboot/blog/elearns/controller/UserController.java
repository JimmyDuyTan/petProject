package src.springboot.blog.elearns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.springboot.blog.elearns.constant.UrlConstant;
import src.springboot.blog.elearns.dto.request.UserLoginReq;
import src.springboot.blog.elearns.service.UserService;
import src.springboot.blog.elearns.service.impl.UserServiceImpl;
@RestController("userController")
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(UrlConstant.USER_LOGIN)
    public Object login(@RequestBody UserLoginReq req){
        return userService.login(req);
    }

    @PostMapping(UrlConstant.USER_LOGOUT)
    public Object logout(@RequestBody UserLoginReq req){
        return userService.logout(req);
    }


}
