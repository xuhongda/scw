package com.xu.scw.pojo;

/**
 * @authorxuhongda on 2017/12/10
 * com.xu.scw.pojo
 * scw-parent
 */
public enum EnmuStatus {

    //尚未审核
    UNCHECKED(0,"尚未审核"),
    //审核中
    CHECKING(1,"审核中"),
    //审核通过
    CHECKED(2,"审核通过");
    private EnmuStatus(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    Integer code;
    String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
