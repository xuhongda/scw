package com.xu.scw.controller.perm;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.scw.bean.TRole;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.RoleInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/13
 * com.xu.scw.controller
 * scw-parent
 */
@Controller
@RequestMapping(value = "/role")
public class RoleAjaxCrudController {

    @Autowired
    RoleInterfaceImpl roleInterface;

    /**
     * 查找所有
     * @param ps
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/allRoles")
    public PageInfo<TRole> list(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                @RequestParam(value = "ps",defaultValue = "5")Integer ps, HttpSession session,String condition){

        PageHelper.startPage(pn,ps);
        if(condition==null){
            condition="";
        }
        List<TRole> list = roleInterface.seachList(condition);
        PageInfo<TRole> pageInfo = new PageInfo(list,7);
        return pageInfo;
    }

    /**
     * 添加
     * @param tRole
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRoles")
    public ResultVO addRoles(TRole tRole){
        boolean add = roleInterface.add(tRole);
        System.out.println(add);
        if (add){
            return ResultVO.success("success",null,null);
        }else {
            return ResultVO.error("error",null,null);
        }
    }
    @ResponseBody
    @RequestMapping("selectOne")
    public TRole selectOne(Integer roleId){
        return roleInterface.selectOne(roleId);
    }
    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResultVO delete(String ids){
        boolean delete = roleInterface.delete(ids);
        System.out.println(delete);
        if(delete){
            return ResultVO.success("删除成功",null,null);
        }if (ids==null){
            return ResultVO.error("请先选择要删除的角色",null,null);
        }
        else {
            return ResultVO.error("请先尝试清空权限且解除用户已分配的该角色在删除",null,null);
        }
    }

    /**
     *修改
     * @param tRole
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/edit")
    public ResultVO edit(TRole tRole){
        System.out.println("edit");
        boolean edit = roleInterface.edit(tRole);
        System.out.println(edit);
        if (edit){
            System.out.println("edit");
            return ResultVO.success("修改成功",null,null);
        }else {
            return ResultVO.error("修改失败",null,null);
        }
    }
}
