package src.springboot.blog.elearns.service;

import src.springboot.blog.elearns.dto.request.UserLoginReq;

public interface UserService {
    Object login(UserLoginReq req);
    Object logout(UserLoginReq req);
}
