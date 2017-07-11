package com.kaishengit;

import com.kaishengit.service.Application;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gedmk on 2017/7/10.
 */
public class Test {
    public static void main(String[] args) {
       //加载配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Application application = (Application) applicationContext.getBean("application");
        application.save();
    }
}
