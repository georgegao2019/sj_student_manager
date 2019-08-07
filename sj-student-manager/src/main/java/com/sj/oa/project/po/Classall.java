package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by dell on 2019-07-31.
 */
public class Classall extends BasePo {
    private int id;
    private String className;
    private String major;
    private String grade;
    private int totalNumber;
    private int manNumber;
    private int womenNumber;
    private String headmaster;
    private String majorCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getManNumber() {
        return manNumber;
    }

    public void setManNumber(int manNumber) {
        this.manNumber = manNumber;
    }

    public int getWomenNumber() {
        return womenNumber;
    }

    public void setWomenNumber(int womenNumber) {
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
