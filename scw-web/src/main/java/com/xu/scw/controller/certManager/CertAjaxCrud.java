package com.xu.scw.controller.certManager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.scw.bean.TCert;
import com.xu.scw.bean.TRole;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.service.certManager.certManagerImpl.CertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.scw.controller.certManager
 * scw-parent
 */
@Controller
@RequestMapping(value = "/cert")
public class CertAjaxCrud {
    @Autowired
    CertServiceImpl certService;
    /**
     * 查找所有
     * @param ps
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/allCerts")
    public PageInfo<TRole> list(@RequestParam(value = "pn",defaultValue = "1")Integer ps,
                                @RequestParam(value = "ps",defaultValue = "7")Integer pn, HttpSession session){

        PageHelper.startPage(ps,pn);
        System.out.println(ps);
        List<TCert> list = certService.list();
        PageInfo<TRole> pageInfo = new PageInfo(list,7);
        System.out.println(pageInfo);
        return pageInfo;
    }
    @RequestMapping("test001")
    public String test001(){
        System.out.println("test001");
        return "";
    }
    /**
     * 添加
     * @param tCert
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCerts")
    public ResultVO addRoles(TCert tCert){
        boolean add = certService.add(tCert);
        System.out.println(add);
        if (add){
            return ResultVO.success("success",null,null);
        }else {
            return ResultVO.error("error",null,null);
        }
    }
    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResultVO delete(String ids){
        boolean delete = certService.delete(ids);
        System.out.println(delete);
        if(delete){
            return ResultVO.success("删除成功",null,null);
        }else {
            return ResultVO.error("请先尝试清空权限在删除",null,null);
        }
    }

    @ResponseBody
    @RequestMapping("selectOne")
    public TCert selectOne(Integer certId){
        return certService.selectOne(certId);
    }

    /**
     *修改
     * @param tCert
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/edit")
    public ResultVO edit(TCert tCert){
        System.out.println("edit");
        boolean edit = certService.edit(tCert);
        System.out.println(edit);
        if (edit){
            System.out.println("edit");
            return ResultVO.success("修改成功",null,null);
        }else {
            return ResultVO.error("修改失败",null,null);
        }
    }
}
