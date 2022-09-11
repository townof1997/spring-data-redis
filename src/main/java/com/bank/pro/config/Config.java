package com.bank.pro.config;

import com.bank.pro.tool.Tool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: com.bank.pro.config
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 22 27
 */
@Configuration//起到配置类效果的作用
public class Config {

    @Bean("tool")
    public Tool init() {
        return new Tool();
    }
}
