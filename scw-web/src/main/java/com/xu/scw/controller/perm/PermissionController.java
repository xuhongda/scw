package com.xu.scw.controller.perm;


import com.xu.scw.bean.TPermission;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * 权限分配
 * @authorxuhongda on 2017/11/20
 * com.xu.scw.controller
 * scw-parent
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    PermissionServiceImpl permissionService;

    /**
     * 获取所有Permission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTree")
    public List getTree(){
       return permissionService.getAllPermission();
    }

    @ResponseBody
    @RequestMapping(value = "/allocation")
    public ResultVO<Object> allocation(Integer roleId,String pid){
        boolean b = permissionService.updatePermission(roleId, pid);
        if(b){
            System.out.println(b);
            return ResultVO.success("权限分配完成",null,null );
        }else {
            return ResultVO.error("更新失败",null,null);
        }
    }

    /**
     *获取
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getRoled")
    public ResultVO<List<TPermission>> getRoled(Integer roleId){
        System.out.println("getRoled=======》》》》"+roleId);
        List<TPermission> list = permissionService.selectRoled(roleId);
        System.out.println(list);
        if (list.size()>0){
           return ResultVO.success("获取成功",list,null);
        }else {
           return ResultVO.error("error",null,null);
        }
    }

    /**
     * 清空权限
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deletePermission")
    public ResultVO deletePermission(Integer roleId){
        boolean b = permissionService.deletePermission(roleId);
        if (b){
            return ResultVO.success("清空已权限",null,null);
        }else {
            return ResultVO.error("清空权限失败",null,null);
        }
    }

    /**
     * 更改Permission名
     * @param permission
     * @return
     */
    @ResponseBody
    @RequestMapping(value="reName")
    public ResultVO reName(TPermission permission){
        boolean b = permissionService.updatName(permission);
        if (b){
            return ResultVO.success("更新成功",null,null);
        }else{
            return ResultVO.error("error",null,null);
        }
    }

    @ResponseBody
    @RequestMapping(value="addName")
    public ResultVO addName(TPermission permission){
        boolean b = permissionService.addNewName(permission);
        if (b){
            return ResultVO.success("添加成功",null,null);
        }else{
            return ResultVO.error("error",null,null);
        }
    }
  @ResponseBody
    @RequestMapping(value="deleteName")
    public ResultVO deleteName(TPermission permission){
        boolean b = permissionService.deleteName(permission);

        if (b){
            return ResultVO.success("删除成功",null,null);
        }else{
            return ResultVO.error("error",null,null);
        }
    }

}
