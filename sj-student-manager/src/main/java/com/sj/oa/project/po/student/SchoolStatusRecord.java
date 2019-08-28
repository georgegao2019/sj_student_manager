package com.sj.oa.project.po.student;

/**
 * Created by gaojun on 2019/8/27.
 */
public class SchoolStatusRecord {

    private Integer id;

    //学籍状态id
    private Integer schoolStatusId;

    //更改前学籍状态
    private String previousStatus;

    //更改前学籍状态描述
    private String previousMsg;

    //更改后学籍状态
    private String afterStatus;

    //更改后学籍状态描述
    private String afterMsg;

    //更改原因
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolStatusId() {
        return schoolStatusId;
    }

    public void setSchoolStatusId(Integer schoolStatusId) {
        this.schoolStatusId = schoolStatusId;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getPreviousMsg() {
        return previousMsg;
    }

    public void setPreviousMsg(String previousMsg) {
        this.previousMsg = previousMsg;
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getAfterMsg() {
        return afterMsg;
    }

    public void setAfterMsg(String afterMsg) {
        this.afterMsg = afterMsg;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
