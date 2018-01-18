package com.xu.scw.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.scw.bean.TRole;
import com.xu.scw.bean.TUser;
import com.xu.scw.bean.TUserRole;
import com.xu.scw.dao.TUserMapper;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/9
 * com.xu.scw.controller
 * scw-parent
 */
@Controller
@RequestMapping("/user")
public class UserCrudController {
    @Autowired
    TUserMapper tUserMapper;
    @Autowired
    UserServiceImpl userService;

    /**
     * 查出所有用户
     * @param model
     * @return
     */

    @RequestMapping("/list.html")
    public String user(Model model,
                       @RequestParam(value = "pn",defaultValue = "1")Integer pageNum,
                       @RequestParam(value = "ps",defaultValue = "8")Integer pageSize,String userName){

        PageHelper.startPage(pageNum,pageSize);
        List<TUser> tUsers = tUserMapper.selectByExample(null);
        PageInfo<TUser> pageInfo = new PageInfo(tUsers,7);

        if(userName != null){
            //userNme去空格
            String trim = userName.trim();
            //查出用户id
           Integer userId= userService.selectIdByname(trim);

           if (userId==0){
               model.addAttribute("msg","用户不存在");
               model.addAttribute("pageInfo",pageInfo);
               return "permission/user/user";
           }
            //查出id是表中的第几条记录
            Integer num= userService.selectNum(userId);

            System.out.println(num);
           //分页
            Integer page=num/pageSize;
            if(page%pageSize !=0){
                page+=1;
            }
            System.out.println("第几页"+page);
            model.addAttribute("searchId",userId);
            model.addAttribute("seachMsg","用户已搜索出😘");
            System.out.println("用户id"+userId);
            PageHelper.startPage(page,pageSize);
            List<TUser> users = tUserMapper.selectByExample(null);
            PageInfo<TUser> pageInfo2 = new PageInfo(users,7);
            model.addAttribute("pageInfo",pageInfo2);
            return "permission/user/user";
        }

        model.addAttribute("pageInfo",pageInfo);
        System.out.println("下一页");
        return "permission/user/user";
    }




    /**
     *添加功能
     * @return
     * 要注意在Controller里不区分后缀
     */
    @RequestMapping(value = "/CRUD",method = RequestMethod.POST)
    public String add(TUser tUser,RedirectAttributes attributes) {
        System.out.println("add");
        boolean b = userService.register(tUser);
        if (b) {
            return "redirect:/user/list.html?pn=" + Integer.MAX_VALUE / 7;
        } else {
            attributes.addFlashAttribute("msg", "用户已注册");
            return "redirect:/reg.html";
        }

    }

    /**
     * 查询出修改对象
     * @param request
     * @param userId
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit.html")
    public String editPage(HttpServletRequest request,@RequestParam(value = "userId")Integer userId,
                           @RequestParam(value = "pn")Integer pn,Model model){
        //可在链接url上用param取出
        //request.setAttribute("pn",pn);
        request.setAttribute("userId",userId);
        TUser tUser = tUserMapper.selectByPrimaryKey(userId);
        model.addAttribute("user",tUser);
        System.out.println(tUser.getUsername());
        return "permission/user/edit";
    }

    /**
     * 修改
     * @param tUser
     * @param request
     * @param pn
     * @param session
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/CRUD",method = RequestMethod.PUT)
    public String update(TUser tUser,HttpServletRequest request,Integer pn,HttpSession session,RedirectAttributes attributes){

        boolean b =userService.update(tUser);
        System.out.println(tUser.getLoginacct());
        if(b){
            return "redirect:/user/list.html?pn="+pn;
        }else {
            request.setAttribute("msg","修改失败，请重试");
            return "permission/user/edit";
        }
    }

    /**
     * 删除
     * @param ids
     * @param attributes
     * @return
     */
    @RequestMapping("delete")
    public String testDel(String ids,RedirectAttributes attributes){
        boolean b=userService.delete(ids);
        if(b){
            return "redirect:/user/list.html";
        }else{
            attributes.addFlashAttribute("msg","删除失败，请重试");
            return "redirect:/user/list.html";
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryAllRole")
    public ResultVO<List<TRole>> queryRole(Integer userId){
        List<TRole> tRoles = userService.queryRole(userId);
        return ResultVO.success("success",tRoles,null);
    }

    /**
     *
     *查出用户角色
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/allocateRole")
    public String allocateRole(@RequestParam(value = "userId") Integer userId,ModelMap model){
        List<TRole> tRoles  = userService.queryRoled(userId);
        List<TRole> allRoles = userService.queryAllRoled(userId);
        System.out.println(tRoles.size()+"数量");
        model.addAttribute("userId",userId);
        model.addAttribute("tRoles",tRoles);
        model.addAttribute("allRoles",allRoles);
        for(TRole tRole:tRoles){
            System.out.println(tRole.getName());
        }
        return "permission/user/assignRole";
    }

    @ResponseBody
    @RequestMapping("/addRole")
    public ResultVO add(Integer userid,String roleid){
       // System.out.println("😘"+tUserRole.getUserid());
        System.out.println(roleid+"pppppppppppppp");
        boolean b = userService.insertTroleUser(userid,roleid);
        if(b){
            ModelMap modelMap = new ModelMap();
            allocateRole(userid,modelMap);
            return ResultVO.success("success",null,null);
        }else {
          return   ResultVO.success("error",null,null);
        }

    }

    @ResponseBody
    @RequestMapping("/dec")
    public ResultVO dec(TUserRole tUserRole){
        System.out.println("😘"+tUserRole.getUserid());
        boolean b = userService.deleteRole(tUserRole);
        if(b){
            ModelMap modelMap = new ModelMap();
            allocateRole(tUserRole.getUserid(),modelMap);
            return ResultVO.success("success",null,null);
        }else {
            return   ResultVO.success("error",null,null);
        }
    }
}
