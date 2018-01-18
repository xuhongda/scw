import com.xu.scw.bean.TMember;
import com.xu.scw.vo.MemberVO;
import org.junit.Test;

/**
 * @authorxuhongda on 2017/12/12
 * PACKAGE_NAME
 * scw-parent
 */
public class ApiVO {
    @Test
    public void test(){
        System.out.println(
                com.xu.scw.vo.ApiVO.success("hh", new MemberVO()).notes("sss", "dss")
                .notes("hh", "dvjn "));
    }
    @Test
    public void test002(){
        System.out.println(com.xu.scw.vo.ApiVO.success("suc", new MemberVO()).notes("av", "b").notes("c", "d"));
    }
    @Test
    public void testIntrger(){
        Integer integer = new Integer(11);

        Integer integer1 = 13;
        Integer integer2= 13;
        System.out.println(integer1==integer2); //true
        TMember tMember1;
        TMember tMember2;


        String s="s";
        String ss ="s";
        System.out.println(s==ss);//true

        String str = new String("s");
        String str2 = new String("s");
        System.out.println(str==str2);//false

        String password="ok";
        String password2=new String("ok");
        System.out.println(password==password2);//false

        Byte b = 2;
        Byte b2=2;
        System.out.println(b==b2);
    }
}
