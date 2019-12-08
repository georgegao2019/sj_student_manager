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


    //检查人
    private String checkPerson;

    //扣分编码
    private String dCode;

    //扣分分数
    private double dNumber;

    //状态 0有效  1失效
    private Integer status;

    //缺勤学生学号
    private String studentid;

    //缺勤学生姓名
    private String studentName;

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

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public double getdNumber() {
        return dNumber;
    }

    public void setdNumber(double dNumber) {
        this.dNumber = dNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
