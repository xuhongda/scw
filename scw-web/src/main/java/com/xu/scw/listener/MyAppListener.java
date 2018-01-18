package com.xu.scw.listener;

import com.xu.scw.bean.project.ScwName;
import com.xu.scw.service.projectName.projectNameImpl.ProjectNameServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * 监听器，项目启动获取项目名
 * @author xuhongda on 2017/10/24
 * com.xu.scw.listener
 * scw-parent
 */

public class MyAppListener implements ServletContextListener {

    /*
    在listenner 不能直接引入
    @Autowired
    private ProjectNameServiceImpl projectNameService;*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("scw-web-success-star");
        /*ServletContext servletContext = sce.getServletContext();
        String contextPath = servletContext.getContextPath();*/

        //使用spring的org.springframework.web.context.support;

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        ServletContext servletContext = webApplicationContext.getServletContext();
        String contextPath = servletContext.getContextPath();
        //
        ProjectNameServiceImpl projectNameService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(ProjectNameServiceImpl.class);
        ScwName scwName = new ScwName();
        scwName.setProjectName("mal");
        scwName.setContext(contextPath);
        projectNameService.deleteProjectName("mal");
        projectNameService.addProjectName(scwName);

        //
        List<ScwName> scwNames = projectNameService.allProjectName();
        for(ScwName scwName1:scwNames){
            servletContext.setAttribute(scwName1.getProjectName(),scwName1.getContext());
          //  System.out.println(scwName1);
        }

        //以“/”开头，不以“/”结尾
       // servletContext.setAttribute("mal",servletContext.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
