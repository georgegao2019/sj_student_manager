package com.sj.oa.project.po.college;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by dell on 2019-07-31.
 */
public class Classall extends BasePo {
    private Integer id;
    private String className;
    private String major;
    private String grade;
    private Integer totalNumber;
    private Integer manNumber;
    private Integer womenNumber;
    private String headmaster;
    private String majorCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getManNumber() {
        return manNumber;
    }

    public void setManNumber(Integer manNumber) {
        this.manNumber = manNumber;
    }

    public Integer getWomenNumber() {
        return womenNumber;
    }

    public void setWomenNumber(Integer womenNumber) {
        this.womenNumber = womenNumber;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    @Override
    public String toString() {
        return "Classall{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", totalNumber=" + totalNumber +
                ", manNumber=" + manNumber +
                ", womenNumber=" + womenNumber +
                ", headmaster='" + headmaster + '\'' +
                ", majorCode='" + majorCode + '\'' +
                '}';
    }
}