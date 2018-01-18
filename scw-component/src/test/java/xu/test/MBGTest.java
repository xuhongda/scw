package xu.test;

import com.xu.scw.bean.TUser;
import com.xu.scw.dao.TRoleMapper;
import com.xu.scw.dao.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * springMVC测试，测试逆向工程sql语句
 * @author xuhongda on 2017/10/21
 * com.xu.test
 * scw-parent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml",
                        "classpath:spring-mybatis.xml",
                "classpath:spring-tx.xml"})
public class MBGTest {


    @Autowired
    private TUserMapper tUserMapper;
    @Test
    public void testAll(){
        System.out.println("is ok");
    }
    @Test
    public void test001(){
        System.out.println("haha");
        for (int i = 0; i <999 ; i++) {
            TUser tUser = new TUser();
            String pswd="123"+i*(3*i);
            String name="xu"+i;
            String acct="abc"+i*(3*i);
            tUser.setUserpswd(pswd);
            tUser.setUsername(name);
            tUser.setLoginacct(acct);
            tUser.setEmail("11111@11.com");
            System.out.println(tUser == null);
            System.out.println(tUserMapper.insertSelective(tUser));
        }

    }

    @Test
    public void test002(){
        System.out.println(tUserMapper.selectByPrimaryKey(3));
    }

    @Test
    public void test003(){
        for (int i = 0; i <100 ; i++) {
            System.out.println(tUserMapper.deleteByPrimaryKey(i));
        }
        System.out.println(tUserMapper.deleteByPrimaryKey(4)==1?"correct":"error");
    }

    @Test
    public void testUpdate(){
        TUser tUser = tUserMapper.selectByPrimaryKey(15);
        System.out.println(tUser);
    }

    @Autowired
    TRoleMapper tRoleMapper;
    @Test
    public void testTrole(){
        int i = tRoleMapper.deleteByPrimaryKey(299);
        System.out.println(i);
    }

}
