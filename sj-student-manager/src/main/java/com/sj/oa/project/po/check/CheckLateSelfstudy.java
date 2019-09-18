package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

/**
 * Created by gaojun on 2019/7/31.
 */
public class CheckLateSelfstudy extends BasePo {

    private Integer id;

    //专业code
    private String majorCode;

    //专业名称
    private String majorName;

    //班级名称
    private String className;

    //教师
    private String classRoom;

    //违纪学生学号
    private String studentid;

    //违纪学生姓名
    private String studentName;

    //是否已经请假 0未请假  1已请假
    private Integer isAsk;

    //请假方式
    private String askType;

    //理由
    private String reason;

    //检查人
    private String checkPerson;
    //检查时间
    private Date checkTime;
    //状态 0有效 1失效
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
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

    public Integer getIsAsk() {
        return isAsk;
    }

    public void setIsAsk(Integer isAsk) {
        this.isAsk = isAsk;
    }

    public String getAskType() {
        return askType;
    }

    public void setAskType(String askType) {
        this.askType = askType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
