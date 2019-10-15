package com.kms;

import com.kms.Dao.UserDOMapper;
import com.kms.DataObject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.kms"})
@RestController
@MapperScan("com.kms.Dao")
public class App 
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home (){
        UserDO userDO =userDOMapper.selectByPrimaryKey("AHDTSM");
        if(userDO == null){
            return "用户不存在！";
        }
        else{
            return userDO.getCustomername();
        }

    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
