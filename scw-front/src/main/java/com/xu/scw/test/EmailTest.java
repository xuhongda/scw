package com.xu.scw.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @authorxuhongda on 2017/12/2
 * com.xu.scw.test
 * scw-parent
 */


public class EmailTest {

    @Test
    public void test001(){
        SimpleEmail email = new SimpleEmail();
        email.setAuthentication("13177802629@163.com","w11213412");

        //使用Date
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + sdf.format(d));


        try {
            email.setHostName("smtp.163.com");
            email.setFrom("13177802629@163.com");
            email.setSubject("测试");
            email.setMsg("hello");
            email.addTo("xuhongda7@outlook.com");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

        System.out.println("over");

    }
    @Test
    public void test() throws Exception{
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("localhost");
        sender.setUsername("xu@xuhongda.com");
        sender.setPassword("123456");
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true, "GBK");

        helper.setTo("xxxx@xuhongda.com");
        helper.setText("<a href=\"http://www.baidu.com\">dw</a>",true);
        FileSystemResource res = new FileSystemResource(new File("E:\\code\\scwcode\\scw-front\\src\\main\\webapp\\static\\img\\u=2945488730,827140352&fm=27&gp=0.jpg"));
        helper.addInline("密码找回", res);
        sender.send(message);
    }
}
