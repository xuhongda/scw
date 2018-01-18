package com.xu.scw.service.certManager.certManagerImpl;

import com.xu.scw.bean.TAccountTypeCert;
import com.xu.scw.dao.TAccountTypeCertMapper;
import com.xu.scw.service.certManager.TAccountCertservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authorxuhongda on 2017/11/23
 * com.xu.scw.service.certManager.certManagerImpl
 * scw-parent
 */
@Service
public class TAccountCertserviceImpl implements TAccountCertservice {
    @Autowired
    TAccountTypeCertMapper tAccountTypeCertMapper;
    @Override
    public boolean allocateCert(List<TAccountTypeCert> list) {
        int i = tAccountTypeCertMapper.deleteByExample(null);

        if(list.size()==0){
            return true;
        }
        int insert=0;
       /* for(TAccountTypeCert tAccountTypeCert:list){
            insert = tAccountTypeCertMapper.insert(tAccountTypeCert);

        }*/

        long start = System.currentTimeMillis();
       /* for (int j = 0; j < 10000; j++) {
            TAccountTypeCert tAccountTypeCert = new TAccountTypeCert();
            tAccountTypeCert.setAccttype("j");
            tAccountTypeCert.setCertid(j);
            insert = tAccountTypeCertMapper.insert(tAccountTypeCert);
        }*/
       /* for (int j = 0; j < 10000; j++) {
            TAccountTypeCert tAccountTypeCert = new TAccountTypeCert();
            tAccountTypeCert.setAccttype("j");
            tAccountTypeCert.setCertid(j);
            list.add(tAccountTypeCert);


        }*/
        long end= System.currentTimeMillis();
        long time=end-start;
        System.out.println("时间=========》》》》"+time);
       return tAccountTypeCertMapper.allocateCert(list)>0;
       // return insert>0 ;

    }

    @Override
    public List<TAccountTypeCert> getAccCert() {
        List<TAccountTypeCert> list = tAccountTypeCertMapper.selectByExample(null);
        System.out.println(list);
        return list;
    }

    @Override
    public int deleteAll() {
        return tAccountTypeCertMapper.deleteByExample(null);
    }


}
