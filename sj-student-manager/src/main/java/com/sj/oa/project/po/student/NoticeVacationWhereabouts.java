package com.sj.oa.project.po.student;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

/**
 * Created by gaojun on 2019/9/18.
 */
public class NoticeVacationWhereabouts extends BasePo {

    private Integer id;

    //主表id
    private Integer noticeId;

    //标题
    private String title;

    //学号
    private String studentId;

    //姓名
    private String studentName;

    //去向
    private String whereabouts;

    //离校日期
    private Date leaveDate;

    //归校日期
    private Date returnDate;

    //状态 0未填写 1已填写
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getWhereabouts() {
        return whereabouts;
    }

    public void setWhereabouts(String whereabouts) {
        this.whereabouts = whereabouts;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
