package com.xu.scw.service.process;

import com.xu.scw.bean.TTag;
import com.xu.scw.bean.TType;
import com.xu.scw.dao.TTagMapper;
import com.xu.scw.dao.TTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @authorxuhongda on 2017/12/12
 * com.xu.scw.service.process
 * scw-parent
 */
@Service
public class processServiceImpl implements  processService{

    @Autowired
    private TTypeMapper tTypeMapper;

    @Autowired
    private TTagMapper tTagMapper;
    @Override
    public boolean setProerId(Integer id) {
        return false;
    }

    @Override
    public List<TType> getAllType() {
        List<TType> tTypes = tTypeMapper.selectByExample(null);
        return tTypes;
    }

    @Override
    public List<TTag> getProTag() {
        List<TTag> tTags = tTagMapper.selectByExample(null);
        return tTags;
    }

    @Override
    public List<String> uploadImg(MultipartFile[] files, ServletContext servletContext) {
       if(!(files==null)){
           List<String> list = new ArrayList<>();
           for(MultipartFile file:files){
               String originalFilename = file.getOriginalFilename();
               String replace = UUID.randomUUID().toString().replace("-", "7");
               //设置存放路径
               //获取真实路径，即使这个文件还没有，也能获取到将来的真实路径。磁盘的路径
               String path =servletContext.getRealPath("/imgs/"+replace+originalFilename);
               System.out.println(path);
               list.add(path);
               File file1 = new File(path);
               try {
                   file.transferTo(file1);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
            return list;
       }else {
           return new ArrayList<>();
       }

    }
}
