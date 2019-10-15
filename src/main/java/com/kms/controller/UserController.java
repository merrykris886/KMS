package com.kms.controller;

import com.kms.DataObject.UserDO;
import com.kms.controller.ViewObject.UserVO;
import com.kms.error.BussinessException;
import com.kms.error.EmBusinessError;
import com.kms.response.CommonReturnType;
import com.kms.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller("user")
@RequestMapping("/user")
@CrossOrigin //允许跨域请求
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    //用户获取otp短信接口
    @RequestMapping("/getotp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telephone")String telephone){
        //需要按照一定的规则生成OTP验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;//此处随机数取值[10000,109999]
        String otpCode = String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联,使用httpsession的方式绑定手机号与otpCode
        httpServletRequest.getSession().setAttribute(telephone,otpCode);

        //将OTP验证码通过短信发送给用户,省略
        System.out.println("telephone="+ telephone + " & otpCode="+ otpCode);

        return CommonReturnType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") String id) throws BussinessException {

        //调用service服务获取对应id的用户对象并返回给前端
        UserDO userDO = userService.getUserById(id);
        //若获取的用户信息不存在
        if(userDO==null){
            throw new BussinessException(EmBusinessError.USER_NOT_EXIST);
        }
        //将核心领域模型用户对象转化为可供UI使用的viewObject
        UserVO userVO = convertFromUserDO(userDO);
        //返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromUserDO(UserDO userDO){
        if(userDO==null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO,userVO);
        return userVO;
    }





}
