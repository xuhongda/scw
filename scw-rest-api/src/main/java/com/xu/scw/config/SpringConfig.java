package com.xu.scw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 使用配置代替spring mvc xml
 * @authorxuhongda on 2017/12/14
 * com.xu.scw.config
 * scw-parent
 */
@Configuration
@EnableWebMvc
public class SpringConfig {

   /* public @Bean SwaggerConfig orderService() {
        return new SwaggerConfig();

    }*/

    @Bean
    public SwaggerConfig swaggerConfig(){
        return new SwaggerConfig();
    }


}
