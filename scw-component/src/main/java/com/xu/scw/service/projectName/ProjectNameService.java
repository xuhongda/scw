package com.xu.scw.service.projectName;

import com.xu.scw.bean.project.ScwName;

import java.util.List;

/**
 * @authorxuhongda on 2017/12/9
 * com.xu.scw.service.projectName
 * scw-parent
 */
public interface ProjectNameService {

    List<ScwName> allProjectName();

    ScwName oneProjectName(String name);

    int deleteProjectName(String name);

    int addProjectName(ScwName scwName);
}
