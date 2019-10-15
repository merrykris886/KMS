package com.kms.service.Impl;

import com.kms.Dao.UserDOMapper;
import com.kms.DataObject.UserDO;
import com.kms.service.UserService;
import com.kms.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getUserById(String id){
        //调用UserDOMapper获取到对应的用户DataObject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return userDO;
    }
    /*private UserModel convertFromDataObject(UserDO userDO,UserPasswordDO userPasswordDO){
        if(userDO==null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        if(userPasswordDO!=null){
            userModel.setPassword(userPasswordDO.getPassword());
        }

        return userModel;
    }*/
}
