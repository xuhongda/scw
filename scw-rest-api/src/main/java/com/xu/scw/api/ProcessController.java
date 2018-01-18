package com.xu.scw.api;

import com.xu.scw.bean.TTag;
import com.xu.scw.bean.TType;
import com.xu.scw.service.process.processServiceImpl;
import com.xu.scw.vo.ApiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @authorxuhongda on 2017/12/12
 * com.xu.scw.api
 * scw-parent
 */
@RestController
@Api(tags = {"项目发起"},description = "项目发起流程")
public class ProcessController implements ServletContextAware{
    private ServletContext servletContext;
    @Autowired
    private processServiceImpl processService;
    @RequestMapping("processerInfo")
    @ApiOperation(value = "项目发起人的id",httpMethod = "GET")
    @ApiParam(name = "项目发起人的id",required = true)
    public ApiVO processerInfo(Integer memID){
        boolean b = processService.setProerId(memID);
        if(b){
            return ApiVO.success("success",null).notes("msg","suc");

        }else {
            return ApiVO.error("error",null);
        }
    }
    @RequestMapping("getType")
    @ApiOperation(value = "获取所有分类消息",httpMethod = "GET")
    @ApiParam(name = "获取所有分类消息",required = true)
    public ApiVO getType(){
        List<TType> allType = processService.getAllType();
        if(allType.size()>0){
            return ApiVO.success("success",allType).notes("msg","suc");
        }else {
            return ApiVO.error("error",null);
        }
    }

    @RequestMapping("getTag")
    @ApiOperation(value = "获取所有标签",httpMethod = "GET")
    @ApiParam(name = "获取所有标签",required = true)
    public ApiVO getTag(){
        List<TTag> proTag = processService.getProTag();
        List<TTag> buildTags = build(proTag);
        if(proTag.size()>0){
            return ApiVO.success("success",buildTags).notes("msg","suc");
        }else {
            return ApiVO.error("error",null);
        }
    }

    /**
     *构建tag父子关系
     * @param list
     * @return
     */
    public List<TTag> build(List<TTag> list){
        //父
        List<TTag> p_tag= new ArrayList<>();
        //子
        List<TTag> tag = new ArrayList<>();
        //遍历所有标签
            for (TTag tTag:list){
                //选出父标签
                if(tTag.getPid()==0){
                    p_tag.add(tTag);
                }else {
                    //选出子标签
                    tag.add(tTag);
                }
            }

            //构建关系
            for(TTag tTag:p_tag){
                Integer id = tTag.getId();
                List<TTag> childs=new ArrayList<>();
                //遍历所有子标签
                for(TTag tTag1:tag){
                    final Integer pid = tTag1.getPid();
                    //如果父标签等于。。。。
                    if (pid.equals(id)){
                        childs.add(tTag1);
                    }
                }
                tTag.setChilds(childs);
            }
            return p_tag;
    }

    @RequestMapping("uploadImg")
    @ApiOperation(value = "上传文件",httpMethod = "POST")
    @ApiParam(name = "上传文件",required = true)
    public ApiVO uploadImg(@RequestParam MultipartFile[] files){
        List<String> list = processService.uploadImg(files, servletContext);
        if(list.size()==files.length){
            System.out.println(list.size());
            return ApiVO.success("success",list).notes("msg","suc");
        } else {
            return ApiVO.error("error",null);
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
            this.servletContext=servletContext;
    }
}
