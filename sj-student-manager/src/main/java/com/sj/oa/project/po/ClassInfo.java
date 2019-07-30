package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/7/30.
 * 班级信息bean
 * t_class_info
 */
public class ClassInfo extends BasePo {

    Integer id;

    //班级名称
    String className;
    //所属专业
    String belongMajor;
    //年级
    String grade;
    //全班总人数
    Integer totalNumber;
    //男生人数
    Integer manNumber;
    //女生人数
    Integer womenNumber;
    //班主任
    String headmaster;

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

    public String getBelongMajor() {
        return belongMajor;
    }

    public void setBelongMajor(String belongMajor) {
        this.belongMajor = belongMajor;
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
}
