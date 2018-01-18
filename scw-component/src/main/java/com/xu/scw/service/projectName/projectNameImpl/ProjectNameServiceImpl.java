package com.xu.scw.service.projectName.projectNameImpl;

import com.xu.scw.bean.project.ScwName;
import com.xu.scw.bean.project.ScwNameExample;
import com.xu.scw.dao.project.ScwNameMapper;
import com.xu.scw.service.projectName.ProjectNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authorxuhongda on 2017/12/9
 * com.xu.scw.service.projectName.projectNameImpl
 * scw-parent
 */
@Service
public class ProjectNameServiceImpl implements ProjectNameService{
    @Autowired
    private ScwNameMapper scwNameMapper;
    @Override
    public List<ScwName> allProjectName() {
        List<ScwName> scwNames = scwNameMapper.selectByExample(null);
        return scwNames;
    }

    @Override
    public ScwName oneProjectName(String name) {
        ScwNameExample scwNameExample = new ScwNameExample();
        ScwNameExample.Criteria criteria = scwNameExample.createCriteria();
        criteria.andProjectNameEqualTo(name);
        List<ScwName> scwNames = scwNameMapper.selectByExample(scwNameExample);
        if (scwNames.size()>1){
            return null;
        }
        return scwNames.get(0);
    }

    @Override
    public int deleteProjectName(String name) {
        ScwNameExample scwNameExample = new ScwNameExample();
        ScwNameExample.Criteria criteria = scwNameExample.createCriteria();
        criteria.andProjectNameEqualTo(name);
        int i = scwNameMapper.deleteByExample(scwNameExample);
        return i;
    }

    @Override
    public int addProjectName(ScwName scwName) {

        int insert = scwNameMapper.insertSelective(scwName);
        return insert;
    }
}
