package com.xu.scw.service.certManager;

import com.xu.scw.bean.TAccountTypeCert;
import com.xu.scw.bean.TCert;
import com.xu.scw.bean.TRole;

import java.util.List;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.scw.service.certManager
 * scw-parent
 */
public interface CertService {
    List<TCert> list();

    boolean add(TCert tCert);

    boolean delete(String ids);

    TCert selectOne(Integer Id);

    boolean edit(TCert tCert);





}
