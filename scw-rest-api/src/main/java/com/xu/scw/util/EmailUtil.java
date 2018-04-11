package com.xu.scw.util;

import java.io.File;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.internet.MimeMessage;

/**
 * @authorxuhongda on 2017/12/11
 * com.xu.scw.util
 * scw-parent
 */
public class EmailUtil {
    /**
     * 发送邮件
     * @param to
     * @param from
     * @param msg
     */
    public static void  sendEmail(String to, Map<String,String> from,String sub,String msg,String host) throws Exception{
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        if(host==null){
            host="localhost";
        }
        //服务主机
        sender.setHost(host);
        //系统用户名
        String user = from.get("user");
        sender.setUsername(user);
        //密码
        String pswd = from.get("pswd");
        sender.setPassword(pswd);

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true, "GBK");
        //发送地址
        helper.setTo(to);
        //发送消息
        helper.setSubject(sub);
        //加true发html格式邮件
        helper.setText(msg,true);
        //图片附件
        FileSystemResource res = new FileSystemResource(new File("E:\\code\\scwcode\\scw-front\\src\\main\\webapp\\static\\img\\u=2945488730,827140352&fm=27&gp=0.jpg"));
        helper.addInline("密码找回", res);
        sender.send(message);
    }
}
