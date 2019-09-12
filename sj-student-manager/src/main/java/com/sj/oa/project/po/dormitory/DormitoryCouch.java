package com.sj.oa.project.po.dormitory;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

/**
 * 床位 po
 * Created by gaojun on 2019/8/19.
 */
public class DormitoryCouch extends BasePo {

    private Integer id;

    //宿舍编号
    private String roomCode;

    //床位编号
    private String couchCode;

    //床号
    private Integer couchNumber;

    //是否为上铺  0下铺 1上铺
    private Integer isBerth;

    //学号
    private String studentid;

    //学生姓名
    private String studentName;

    //入住日期
    private Date moveInDate;

    //结束日期
    private Date endDate;

    //是否是舍长 0 不是  1 是
    private Integer isPresident;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getCouchCode() {
        return couchCode;
    }

    public void setCouchCode(String couchCode) {
        this.couchCode = couchCode;
    }

    public Integer getCouchNumber() {
        return couchNumber;
    }

    public void setCouchNumber(Integer couchNumber) {
        this.couchNumber = couchNumber;
    }

    public Integer getIsBerth() {
        return isBerth;
    }

    public void setIsBerth(Integer isBerth) {
        this.isBerth = isBerth;
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

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsPresident() {
        return isPresident;
    }

    public void setIsPresident(Integer isPresident) {
        this.isPresident = isPresident;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
