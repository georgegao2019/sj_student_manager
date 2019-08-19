package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

/**
 * Created by gaojun on 2019/8/6.
 */
public class CheckMorningExercises extends BasePo {

    private Integer id;

    //专业代号
    private String majorCode;

    //专业名称
    private String majorName;

    //班级id
    private Integer classId;

    //班级名称
    private String className;

    //应到人数
    private Integer totalNumber;

    //实到人数
    private Integer alreadNumber;

    //检查人
    private String checkPerson;

    //检查时间
    private Date checkTime;

    //状态 0有效  1失效
    private Integer status;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getAlreadNumber() {
        return alreadNumber;
    }

    public void setAlreadNumber(Integer alreadNumber) {
        this.alreadNumber = alreadNumber;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
