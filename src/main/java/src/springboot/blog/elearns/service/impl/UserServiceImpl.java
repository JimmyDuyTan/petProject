package src.springboot.blog.elearns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.springboot.blog.elearns.dto.request.UserLoginReq;
import src.springboot.blog.elearns.service.UserService;
import src.springboot.blog.elearns.service.validator.UserValidator;

@Service
public class UserServiceImpl implements UserService {
    private UserValidator userValidator;

    @Override
    public Object login(UserLoginReq req){
        String error = userValidator.validatorLogin(req);
        if(error != null){
            return error;
        }

        return req;
    }

    @Override
    public Object logout(UserLoginReq req){

        return req;
    }
}
