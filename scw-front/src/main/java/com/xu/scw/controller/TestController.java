package com.xu.scw.controller;

import com.xu.scw.bean.TUser;
import com.xu.scw.pojo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

/**
 * @authorxuhongda on 2017/11/30
 * com.xu.scw.controller
 * scw-parent
 */

@Controller

public class TestController {
    /**
     * 文件上传
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String pathName ="e:/testImg";
                        File file1 = new File(pathName);
                        boolean mkdir = file1.mkdir();
                        if (mkdir){
                            String path = "E:/testImg/"+fileName;
                            File localFile = new File(path);
                            file.transferTo(localFile);
                        }

                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        return "forward:/pages/success.jsp";
    }
    @ResponseBody
    @RequestMapping("/rest")
    public ResultVO<TUser> rest(@PathVariable String a,@PathVariable String b){
        System.out.println(a);
        TUser tUser = new TUser();
        tUser.setUsername(a);
        tUser.setUserpswd(b);
        return ResultVO.success("success",tUser,null);
    }

    @ResponseBody
    @RequestMapping("/upload2")
    public ResultVO<TUser> rest(@RequestParam(value = "file") MultipartFile file){
        System.out.println(file);
        return ResultVO.success("success",null,null);
    }
}
