package com.xu.scw.service.certManager.certManagerImpl;

import com.xu.scw.bean.TCert;
import com.xu.scw.bean.TCertExample;
import com.xu.scw.dao.TCertMapper;
import com.xu.scw.service.certManager.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.scw.service.certManager.certManagerImpl
 * scw-parent
 */
@Service
public class CertServiceImpl implements CertService {
    @Autowired
    TCertMapper tCertMapper;
    @Override
    public List<TCert> list() {
        List<TCert> tCerts = tCertMapper.selectByExample(null);
        return tCerts;
    }

    @Override
    public boolean add(TCert tCert) {
        int i = tCertMapper.insertSelective(tCert);
        return i>0;
    }

    @Override
    public boolean delete(String ids) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String str:split){
            int i = Integer.parseInt(str);
            list.add(i);
        }
        TCertExample tCertExample  = new TCertExample();
        TCertExample.Criteria criteria = tCertExample.createCriteria();
        criteria.andIdIn(list);
        int i = tCertMapper.deleteByExample(tCertExample);
        return i>0;
    }

    @Override
    public TCert selectOne(Integer id) {
        TCert tCert = tCertMapper.selectByPrimaryKey(id);
        return tCert;
    }

    @Override
    public boolean edit(TCert tCert) {
        int i = tCertMapper.updateByPrimaryKeySelective(tCert);
        return i>0;
    }




}
