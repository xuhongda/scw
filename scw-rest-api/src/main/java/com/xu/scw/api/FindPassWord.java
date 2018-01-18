package com.xu.scw.api;

import com.xu.scw.bean.TMember;
import com.xu.scw.vo.ResultVO;
import com.xu.scw.service.pswd.ResetPswdImpl;
import com.xu.scw.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @authorxuhongda on 2017/12/10
 * com.xu.scw.api
 * scw-parent
 */
@Controller
@RequestMapping("/password")
public class FindPassWord implements ServletContextAware {
    private ServletContext servletContext;
    @Autowired
    ResetPswdImpl resetPswd;
    @ResponseBody
    @RequestMapping("findPswd")
    public ResultVO findPswd(String email){
        Map map = new HashMap(16);
        map.put("user","xu@xuhongda.com");
        map.put("pswd","123456");
        String sub ="找回密码";
        //根据邮箱查用户
        TMember member = resetPswd.find(email);
        UUID uuid = UUID.randomUUID();
        String substring = uuid.toString();
        if(!(member==null)){
            Integer id = member.getId();
            //保存用户
            //用token 标识用户
            servletContext.setAttribute(substring,id);
        }
        String msg="<a href=\"http://localhost:8080/scw/front/resetPawd.html?token="+substring+"\">" +
                "点击链接更改密码" +
                "</a>";
        try {
            EmailUtil.sendEmail(email,map,sub,msg,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVO.success("邮件已发送，请及时查收",null,null);
    }

    /**
     * 重置密码
     * @param token
     * @return
     */
    private String tar="";
    @ResponseBody
    @RequestMapping("/resetPswd")
    public ResultVO resetPswd(String token,String pswd){
        Object attribute = servletContext.getAttribute(token);
        if(attribute != null){
            tar=token;
            System.out.println(tar);
        }
        if(attribute != null){
            servletContext.removeAttribute(token);
        }


        if(attribute==null){
            return ResultVO.error("密码已修改，不需要重新提交",null,null);
        }
        Integer userId = (Integer) attribute;
        boolean b= resetPswd.resetPaswd(userId,pswd);
       if (b){
           System.out.println("suc==========");
            return ResultVO.success("密码修改成功",null,null);
       }else {
           return ResultVO.error("网络太慢了，请重试",null,null);
       }
    }
    @Override
    public void setServletContext(ServletContext servletContext) {

            this.servletContext=servletContext;
    }
}
