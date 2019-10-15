package com.kms.service;

import com.kms.DataObject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    //通过用户id获取用户对象的方法

    UserDO getUserById(String id);
    //UserModel getUserById(String id);
}
