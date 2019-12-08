package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

public class CheckCourse extends BasePo {
    private Integer id;

    private String studentid;

    private String name;

    private String courseName;

    private String courseTeacher;

    private Integer beginNumber;

    private Integer endNumber;

    private  String dCode;

    private  Integer vacate;

    private  Integer status;

    private Date createTime;

    private  String createUser;

    private String className;

    private  Date updateTime;

    private  String updateTser;

    private Integer week;

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Integer getBeginNumber() {
        return beginNumber;
    }

    public void setBeginNumber(Integer beginNumber) {
        this.beginNumber = beginNumber;
    }

    public Integer getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(Integer endNumber) {
        this.endNumber = endNumber;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public Integer getVacate() {
        return vacate;
    }

    public void setVacate(Integer vacate) {
        this.vacate = vacate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTser() {
        return updateTser;
    }

    public void setUpdateTser(String updateTser) {
        this.updateTser = updateTser;
    }
}
