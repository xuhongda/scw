package xu.test;

import com.xu.scw.bean.TPermission;
import com.xu.scw.bean.TRole;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.PermissionServiceImpl;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.RoleInterfaceImpl;
import com.xu.scw.service.roleAndUser.roleAndUserserviceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml",
        "classpath:spring-mybatis.xml",
        "classpath:spring-tx.xml"})
public class ServiceTest {
    @Autowired
    PermissionServiceImpl permissionService;
    @Autowired
    UserServiceImpl userService;
    @Test
    public void test001(){
        List<TPermission> list=permissionService.getAllMenus("xuhongda");
        for (TPermission tPermission :list){
            System.out.println("父"+tPermission.getName());
            List<TPermission> childs = tPermission.getChilds();
            for(TPermission tPermission1:childs){
                System.out.println("子"+tPermission1.getName());
            }
        }
    }
    @Autowired
    RoleInterfaceImpl roleInterface;
    @Test
    public void testEdit(){
        TRole tRole = new TRole();
        tRole.setId(1);
        tRole.setName("jjjjjjjjjjj");
        boolean edit = roleInterface.edit(tRole);
        System.out.println(edit);
    }

    @Test
    public void testPage(){
        int num = userService.selectNum(1044);
        System.out.println(num);
    }
}
