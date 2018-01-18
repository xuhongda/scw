package com.xu.scw.controller.test;

import com.xu.scw.bean.TUser;
import com.xu.scw.pojo.Constants;
import com.xu.scw.pojo.ResultVO;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @authorxuhongda on 2017/12/16
 * com.xu.scw.controller.test
 * scw-parent
 */
@Controller

public class Upload {

    /**
     * 部署流程
     * @param file
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/deploy")
    public ResultVO deploy(@RequestParam(value = "file")MultipartFile file, HttpSession session){
        System.out.println(file==null);
        Deployment deploy = null;

        return ResultVO.success("部署成功", Arrays.asList(deploy), null);

    }
}
