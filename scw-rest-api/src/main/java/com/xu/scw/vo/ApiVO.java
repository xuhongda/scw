package com.xu.scw.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorxuhongda on 2017/12/13
 * PACKAGE_NAME
 * scw-parent
 */
public class ApiVO<T> {
    /**
     * 返回状态
     * 0 success
     * 1 failed
     */
    private Integer code;
    /**
     *返回消息
     */
    private String msg;

    /**
     * map
     */
    private Map<String,Object> map;
    /**
     * 返回的对象
     */
    private T type;


    /**
     * 请求成功
     * @param msg
     * @param obj
     *
     * @param <T>
     * @return
     */
    public  static  <T>ApiVO success(String msg, T obj){

        ApiVO<T> ApiVO = new ApiVO<>();
        ApiVO.code=0;
        ApiVO.type=obj;
        ApiVO.msg=msg;
        return ApiVO;
    }

    /**
     * 请求失败
     * @param msg
     * @param obj
     * @return
     */
    public  static ApiVO error(String msg, Object obj){
        ApiVO ApiVO = new ApiVO<>();
        ApiVO.code=1;
        ApiVO.type=obj;
        ApiVO.msg=msg;
        return ApiVO;
    }
    Map<String,Object> notemap = new HashMap<>();
    public ApiVO notes(String note, Object obj){
        if(!(note==null)){
            notemap.put(note,obj);
            map=notemap;
            return this;
        }else {
            return new ApiVO();
        }
    }

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

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "ApiVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", map=" + map +
                ", type=" + type +
                '}';
    }
}
