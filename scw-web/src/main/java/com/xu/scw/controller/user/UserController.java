package com.xu.scw.controller.user;


import com.xu.scw.bean.TPermission;
import com.xu.scw.bean.TUser;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.PermissionServiceImpl;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.xu.scw.pojo.Constants.*;

/**
 * @author xuhongda on 2017/11/3
 * com.xu.scw.controller
 * scw-parent
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private  PermissionServiceImpl permissionService;

    /**
     * 处理登陆前的注册业务
     * @param user
     * @param attributes
     * @return
     */
    @RequestMapping("/Register")
    public String register(TUser user, RedirectAttributes attributes,
                           HttpServletRequest request){
        System.out.println("Register");
        boolean register = userService.register(user);
        if(register){
            //设置addFlashAttribute使重定向仍然可以获得信息
            attributes.addFlashAttribute("msg","你已注册成功可以登陆了");
            //自动登陆
            //return "redirect:/login.html";
            return "forward:/UserLogin";
        }else {
            attributes.addFlashAttribute("msg","账号已被注册，请重新注册");
            return "redirect:/reg.html";
        }

    }

    /**
     * 处理登陆服务
     * @param user
     * @param attributes
     * @param session
     * @return
     */
    @RequestMapping("/UserLogin")
    public String login(TUser user, RedirectAttributes attributes, HttpSession session){
        //每次登陆前把session移除
        session.removeAttribute(USER_NAME);
        long login = userService.login(user);
        if(login==LOGIN_CASE_NOUSER){
            attributes.addFlashAttribute("msg","账号不存在，请注册");
            return "redirect:/reg.html";
        }else if(login==LOGIN_CASE_ERROR){
            attributes.addFlashAttribute("msg","账号或密码错误");
            return "redirect:/login.html";
        }else  {
            //登陆成功
            session.setAttribute(USER_NAME,user);
            return "redirect:/main.html";
        }
    }

    /**
     * 前往后台访问页面并实现侧边导航栏的构建
     * @param session
     * @param attributes
     * @return
     */
    @RequestMapping("/main.html")
    public String main(HttpSession session, RedirectAttributes attributes){
        //每次访问前清空菜单
        session.removeAttribute(ALL_MENUS);
        //防止直接访问
       /* if(session.getAttribute(USER_NAME)==null){
            attributes.addFlashAttribute("msg","你还未登陆，请先登陆");
            return "redirect:/login.html";
        }*/
        if(session.getAttribute(ALL_MENUS)==null){
            TUser tUser = (TUser) session.getAttribute(USER_NAME);
            System.out.println(tUser.getLoginacct());
            System.out.println("ALL_MENUS");
            List<TPermission> allMenus = permissionService.getAllMenus(tUser.getLoginacct());
            //将组装好的页面放在session域中
            session.setAttribute(ALL_MENUS,allMenus);
        }
        return "manager/main";
    }


}
