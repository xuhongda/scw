package xu.test;

import com.xu.scw.pojo.CertTypeEnmu;
import org.junit.Test;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.test
 * scw-parent
 */
public class EnumTest {
    @Test
    public void test(){
        Class<CertTypeEnmu> certTypeClass = CertTypeEnmu.class;
        for(CertTypeEnmu certTypeEnmu :certTypeClass.getEnumConstants()){
            System.out.println(certTypeEnmu.getName());
        }
        //System.out.println(CertTypeEnmu.BUSSINESSCOMPANY.getId());
    }
}
