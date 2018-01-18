package com.xu.scw.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @authorxuhongda on 2017/11/29
 * com.xu.scw.vo
 * scw-parent
 */
@ApiModel(description = "会员对象")
public class MemberVO {
    private Integer id;
    @ApiModelProperty(required = true,notes = "登陆账号",dataType = "string")
    private String loginacct;
    @ApiModelProperty(required = true,notes = "登陆密码",dataType = "String")

    private String userpswd;

    private String username;

    private String email;

    private char authstatus;

    private char usertype;

    private String realname;

    private String cardnum;

    private String accttype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct;
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getAuthstatus() {
        return authstatus;
    }

    public void setAuthstatus(char authstatus) {
        this.authstatus = authstatus;
    }

    public char getUsertype() {
        return usertype;
    }

    public void setUsertype(char usertype) {
        this.usertype = usertype;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }
}
