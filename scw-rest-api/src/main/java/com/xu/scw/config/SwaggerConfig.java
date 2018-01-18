package com.xu.scw.config;

import com.fasterxml.classmate.TypeResolver;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static springfox.documentation.schema.AlternateTypeRules.*;

/**
 * @authorxuhongda on 2017/12/12
 * com.xu.scw.config
 * scw-parent
 */

@EnableSwagger2
public class SwaggerConfig {
    //返回Swagger的文档对象
    @Bean
    public Docket docket(){

        //ApiInfoBuilder；一般的大对象；我们都应该来写一个构建器（建造者模式）
        //new ApiInfoBuilder().xx.xxx.xxx.build()
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("xxxxxxxxx")
                        .license("Google fb")
                        .licenseUrl("http://www.baidu.com")
                        .contact(new Contact("xuhongda", "http://www.baidu.com", "leifengyang@atguigu.com"))
                        .title("scw-api文档")
                        .version("1.0.0.beta").build());
        return docket;
    }
}
