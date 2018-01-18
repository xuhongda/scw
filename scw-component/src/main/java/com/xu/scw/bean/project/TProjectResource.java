package com.xu.scw.bean.project;

public class TProjectResource {
    private Integer id;

    private String headimg;

    private String projectimg;

    private Integer pId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getProjectimg() {
        return projectimg;
    }

    public void setProjectimg(String projectimg) {
        this.projectimg = projectimg == null ? null : projectimg.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}