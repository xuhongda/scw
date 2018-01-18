package com.xu.scw.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.scw.pojo.ResultVO;
import com.xu.scw.vo.ApiVO;
import com.xu.scw.vo.ProcessDefinitionEntityVO;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authorxuhongda on 2017/12/15
 * com.xu.scw.api
 * scw-parent
 */
@Controller
@RequestMapping("process")
public class ProcessDeploy {
    private static final Logger logger = LogManager.getLogger(ProcessDeploy.class);
    @Autowired
    private  RepositoryService repositoryService;

    @Autowired
    private  RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    /**
     * 部署流程
     * @param file
     * @param name
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/deploy")
    public ResultVO deploy(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,String name){
        logger.info("===========>>>>"+name);
        Deployment deploy = null;
        String originalFilename = file.getOriginalFilename();
        String headername = request.getHeader("name");
        logger.info("============>>>>>>>>>"+headername);
        if (originalFilename.endsWith(".bpmn")){
            //为了安全性请求头和携带的name 保持一致
            if(headername.equals(name)){
                try {
                    deploy = repositoryService.createDeployment()
                            .addInputStream(file.getOriginalFilename(), file.getInputStream())
                            .name(name)
                            .deploy();
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultVO.error("部署失败", Arrays.asList(deploy), null);
                }
                return ResultVO.success("部署成功", Arrays.asList(deploy), null);
            }else {
                return ResultVO.error("部署失败", Arrays.asList(deploy), null);
            }
        }else {
            System.out.println(originalFilename.endsWith(".bpmn"));
            return ResultVO.error("文件格式不对",null,null);
        }
    }

    @ResponseBody
    @RequestMapping("/list")
    public ApiVO list(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                      @RequestParam(value = "ps",defaultValue = "5") Integer ps){
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //查出流程总数
        long count = processDefinitionQuery.count();
        //利用PageInfo计算
        Page<Object> page = PageHelper.startPage(pn, ps);
        page.setTotal(count);
        PageInfo pageInfo = new PageInfo(page,7);

        processDefinitionQuery.listPage(page.getStartRow(),ps);
        List<ProcessDefinition> list = processDefinitionQuery.list();
        logger.info("list============>>>>"+list);
        List<ProcessDefinitionEntityVO> processDefinitionEntityVOS = new ArrayList<>();
        List<String> ruNames = new ArrayList<>();
        for(ProcessDefinition processDefinition :list){
            //添加任务名称

            String ruName= null;
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }


            ProcessDefinitionEntityVO processDefinitionEntityVO = new ProcessDefinitionEntityVO();
            BeanUtils.copyProperties(processDefinition,processDefinitionEntityVO);
            processDefinitionEntityVOS.add(processDefinitionEntityVO);
        }
        return ApiVO.success("",processDefinitionEntityVOS).notes("info",pageInfo).notes("msg","获取成功").notes("ruNames",ruNames);
    }


    /**
     * 获取图片
     * @param id
     * @param response
     */
    @GetMapping("/img")
    public void img(@RequestParam(value = "id") String id, HttpServletResponse response){
        InputStream processDiagram = repositoryService.getProcessDiagram(id);
        if(!(processDiagram==null)){
            try {
                //用conmons的io utils
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(processDiagram,outputStream);
                IOUtils.closeQuietly(processDiagram);
                IOUtils.closeQuietly(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }

    }
}
