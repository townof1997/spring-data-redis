package com.bank.pro.aa;

import com.bank.pro.config.Config;
import com.bank.pro.tool.Tool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program:
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 22 29
 */
public class TestClass {
    public static void main(String[] args) {
        /**
        * 这里的Config相当于xml配置文件，Tool相当于注册在Config里面的bean类,命名为tool,
        * */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Tool tool = (Tool) applicationContext.getBean("tool");
        tool.print();
    }
}
