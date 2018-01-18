package com.xu.scw.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TAccountTypeCert {
    private Integer id;

    @JsonProperty("a_id")
    private String accttype;
    @JsonProperty("c_id")
    private Integer certid;

    @Override
    public String toString() {
        return "TAccountTypeCert{" +
                "id=" + id +
                ", accttype='" + accttype + '\'' +
                ", certid=" + certid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype == null ? null : accttype.trim();
    }

    public Integer getCertid() {
        return certid;
    }

    public void setCertid(Integer certid) {
        this.certid = certid;
    }
}