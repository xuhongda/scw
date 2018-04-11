package com.xu.scw.pojo;

/**
 * @authorxuhongda on 2017/11/22
 * com.xu.scw.pojo
 * scw-parent
 */

public enum CertTypeEnmu {

    BUSSINESSCOMPANY(1,"商业公司"),
    PERSONCOMPANY(2,"个体工商户"),
    ONEBUSINESS(3,"个人经营"),
    NON_ORGANIZATIONS(4,"政府及非盈利组织");
     CertTypeEnmu(Integer id, String name){
        this.id=id;
        this.name=name;
     }
    Integer id;
    String name;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
