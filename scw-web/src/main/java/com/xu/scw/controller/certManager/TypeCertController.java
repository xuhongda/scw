package com.xu.scw.controller.certManager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.scw.bean.TAccountTypeCert;
import com.xu.scw.bean.TCert;
import com.xu.scw.pojo.CertTypeEnmu;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.service.certManager.certManagerImpl.CertServiceImpl;
import com.xu.scw.service.certManager.certManagerImpl.TAccountCertserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.scw.controller.certManager
 * scw-parent
 */
@Controller
@RequestMapping(value = "/typeCert")
public class TypeCertController {
    @Autowired
    CertServiceImpl certService;
    @Autowired
    TAccountCertserviceImpl tAccountCertservice;

    @RequestMapping(value = "/getType")
    public String getType(Model model){
        //静态方法获取Enumu的对象
        CertTypeEnmu[] values = CertTypeEnmu.values();
        System.out.println("getType");
        model.addAttribute("acctTypeEnmu",values);
        //query
        List<TCert> list = certService.list();
        model.addAttribute("certList",list);
        return "certManager/type";
    }

    @ResponseBody
    @RequestMapping(value = "/allocateCert")
    public ResultVO allocateCert(@RequestParam(value = "subId") String ids){
        System.out.println("str===>>"+ids);
        ObjectMapper objectMapper = new ObjectMapper();
        List<TAccountTypeCert> list=new ArrayList<>();

        try {
            list = objectMapper.readValue(ids, new TypeReference<List<TAccountTypeCert>>() {});
            System.out.println(list);
            System.out.println("list size===》》》》"+list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean b = tAccountCertservice.allocateCert(list);
        if (b){
            return ResultVO.success("分配成功",null,null);
        }else {
            return ResultVO.error("分配失败",null,null);
        }
    }

    @ResponseBody
    @RequestMapping("getCert")
    public ResultVO<TAccountTypeCert> getCert(){
        List<TAccountTypeCert> accCert = tAccountCertservice.getAccCert();
        return ResultVO.success("success",accCert,null);
    }

}
