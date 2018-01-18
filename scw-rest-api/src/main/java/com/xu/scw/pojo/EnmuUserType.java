package com.xu.scw.pojo;

/**
 * @authorxuhongda on 2017/12/10
 * com.xu.scw.pojo
 * scw-parent
 */
public enum EnmuUserType {
    MEMBER(0,"会员"),
    MANAGERMENT(1,"管理");
    private EnmuUserType(Integer type,String msg){
        this.type=type;
        this.msg=msg;
    };
    Integer type;
    String msg;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
