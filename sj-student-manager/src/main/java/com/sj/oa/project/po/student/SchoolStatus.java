package com.sj.oa.project.po.student;

import com.sj.oa.framework.web.po.BasePo;

/**
 * 学生学籍状态
 * Created by gaojun on 2019/8/27.
 */
public class SchoolStatus extends BasePo {

    private Integer id;

    //学号
    private String studentid;

    //学生姓名
    private String studentName;

    //当前学籍状态
    private String currentStatus;

    //状态描述
    private String statusMsg;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
