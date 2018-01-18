package com.xu.scw.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @authorxuhongda on 2017/12/8
 * com.xu.scw.controller.test
 * scw-parent
 */
@Controller
@RequestMapping("test")
public class LogTest {
    @RequestMapping("/log")
    public String log(){
        Logger logger =  Logger.getLogger(String.valueOf(LogTest.class));
        logger.info("kkkkkkkkkkkkkkkkkkkkkkk");
        return "";
    }
}
