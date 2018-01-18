package com.xu.scw.service.certManager;

import com.xu.scw.bean.TAccountTypeCert;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authorxuhongda on 2017/11/23
 * com.xu.scw.service.certManager
 * scw-parent
 */

public interface TAccountCertservice {
    /**
     * 资质维护
     * @param list
     * @return
     */
    boolean allocateCert(List<TAccountTypeCert> list);


    List<TAccountTypeCert> getAccCert();

    int deleteAll();
}
