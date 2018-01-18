package xu.test;

import com.xu.scw.bean.project.ScwName;
import com.xu.scw.service.projectName.projectNameImpl.ProjectNameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @authorxuhongda on 2017/12/9
 * xu.test
 * scw-parent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml",
        "classpath:spring-mybatis.xml",
        "classpath:spring-tx.xml"})
public class ProjectNameTest {

    @Autowired
    ProjectNameServiceImpl projectNameService;
    @Test
    public void test(){
        //
        ScwName scwName = new ScwName();
        scwName.setId(1);
        scwName.setProjectName("front");
        scwName.setContext("dd");
        //projectNameService.addProjectName(scwName);
        ScwName scwName1 = projectNameService.oneProjectName("aa");
        System.out.println(scwName1);
    }
    @Test
    public void test002(){
        ScwName scwName = new ScwName();
        scwName.setId(5);
        scwName.setProjectName("mal");
        scwName.setContext("vv");
       projectNameService.addProjectName(scwName);
       /* List<ScwName> scwNames = projectNameService.allProjectName();
        System.out.println(scwNames);*/
    }

}
