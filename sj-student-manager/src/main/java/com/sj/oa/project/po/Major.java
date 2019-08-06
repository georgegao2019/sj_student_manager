package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by dell on 2019-08-03.
 */
public class Major extends BasePo {

    private Integer id;
    private String majorCode;
    private String majorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", majorCode='" + majorCode + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
