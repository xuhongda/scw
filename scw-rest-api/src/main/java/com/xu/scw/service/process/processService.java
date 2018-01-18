package com.xu.scw.service.process;

import com.xu.scw.bean.TTag;
import com.xu.scw.bean.TType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

/**
 * @authorxuhongda on 2017/12/12
 * com.xu.scw.service.process
 * scw-parent
 */
public interface processService  {
    /**
     * 设置发起人id
     * @param id
     * @return
     */
    boolean setProerId(Integer id);

    /**
     * 获取所有分类消息
     * @return
     */
    List<TType> getAllType();
    /**
     * 获取所有标签
     * @return
     */
    List<TTag> getProTag();

    /**
     * 上传文件
     * @param file
     * @return
     */
    List<String> uploadImg(MultipartFile[] file, ServletContext servletContext);
}
