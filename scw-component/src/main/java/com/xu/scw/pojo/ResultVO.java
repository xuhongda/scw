package com.xu.scw.pojo;


import java.util.Map;

/**
 * @authorxuhongda on 2017/11/15
 * com.xu.scw.pojo
 * scw-parent
 */
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T content;
    private Map<String,Object> ext;


    /**
     * 成功
     * @param msg
     * @param obj
     * @param map
     * @param <T>
     * @return
     */
    public static<T> ResultVO success(String msg, T obj, Map<String,Object> map){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.code = 0;
        if (msg != null) {
            resultVO.msg = msg;
        }
        resultVO.content = obj;
        resultVO.ext = map;
        return resultVO;
    }

    /**
     * 失败
     * @param msg
     * @param obj
     * @param map
     * @param <T>
     * @return
     */
    public static<T> ResultVO error(String msg,T obj,Map<String,Object> map) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.code=1;
        if(msg != null){
            resultVO.msg=msg;
        }
        resultVO.content = obj;
        resultVO.ext = map;
        return resultVO;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                ", ext=" + ext +
                '}';
    }

}
