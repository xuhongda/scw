package com.xu.scw.api;

import com.xu.scw.bean.TMember;
import com.xu.scw.service.user.RegisterServiceImpl;
import com.xu.scw.vo.MemberVO;
import com.xu.scw.vo.ResultVO;
import com.xu.scw.service.user.LoginServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorxuhongda on 2017/11/29
 * com.xu.scw.api
 * scw-parent
 */
@Controller
@ResponseBody
@Api(value = "用户注册登陆",tags ={"会员登陆注册"},description = "处理会员登陆注册")

public class User {
    @Autowired
    LoginServiceImpl loginService;
    @RequestMapping(value = "/login")
    @ApiOperation(tags = "会员登陆功能",value = "会员登陆",httpMethod = "GET",response = ResultVO.class,notes = "这是会员登陆")
    @ApiParam(required = true,name = "member",value = "会员对象")
    public ResultVO<TMember> login(TMember member){

        TMember member1 = loginService.login(member);
        Map<String,Object> map = new HashMap<>(16);

        if(member1 != null){
            map.put("logacct",member1.getLoginacct());
            map.put("pswd",member1.getUserpswd());
            MemberVO memberVO =new MemberVO();
            BeanUtils.copyProperties(member1,memberVO);
            return ResultVO.success("success",memberVO,map);
        }else {
            return ResultVO.error("error",null,map);
        }
    }
    @Autowired
    RegisterServiceImpl registerService;
    @ResponseBody
    @RequestMapping(value = "/register")
    @ApiOperation(tags = "会员注册功能",httpMethod = "GET",notes="处理用户注册",value = "会员注册")
    public ResultVO<TMember> register(TMember member){
        boolean register = registerService.register(member);
        Map<String,Object> map = new HashMap<>(16);
        if(register){
            TMember member1 = loginService.login(member);
            map.put("logacct",member1.getLoginacct());
            map.put("pswd",member1.getUserpswd());
            MemberVO memberVO =new MemberVO();
            BeanUtils.copyProperties(member1,memberVO);
            return ResultVO.success("success",memberVO,map);
        }else {
            return ResultVO.error("error",null,map);
        }
    }

}
