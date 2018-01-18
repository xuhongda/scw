package com.xu.scw.listener;



import com.xu.scw.bean.project.ScwName;
import com.xu.scw.service.projectName.projectNameImpl.ProjectNameServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.logging.Logger;

/**
 * @authorxuhongda on 2017/11/28
 * com.xu.scw.listener
 * scw-parent
 */
public class MyAppListener implements ServletContextListener {

/*
    @Autowired
    ProjectNameServiceImpl projectNameService;
*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger logger =  Logger.getLogger("启动");
        logger.info("front");
       /* ServletContext servletContext = sce.getServletContext();
        String contextPath = servletContext.getContextPath();*/
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        ServletContext servletContext = webApplicationContext.getServletContext();
        String contextPath = servletContext.getContextPath();
        ProjectNameServiceImpl projectNameService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(ProjectNameServiceImpl.class);
        //
        ScwName scwName = new ScwName();
        scwName.setProjectName("front");
        scwName.setContext(contextPath);
        projectNameService.deleteProjectName("front");
        projectNameService.addProjectName(scwName);

        //
        List<ScwName> scwNames = projectNameService.allProjectName();
        for(ScwName scwName1:scwNames){
            servletContext.setAttribute(scwName1.getProjectName(),scwName1.getContext());
            logger.info(scwName1.toString());
        }

        //以“/”开头，不以“/”结尾
       //servletContext.setAttribute("front",servletContext.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
