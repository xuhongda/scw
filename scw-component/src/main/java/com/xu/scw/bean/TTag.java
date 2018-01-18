package com.xu.scw.bean;

import java.util.List;

public class TTag {
    private Integer id;

    private Integer pid;

    private String name;

    private List<TTag> childs;

    public List<TTag> getChilds() {
        return childs;
    }

    public void setChilds(List<TTag> childs) {
        this.childs = childs;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}