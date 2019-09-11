package com.sj.oa.project.po.dormitory;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/8/14.
 */
public class DormitoryRoom extends BasePo {

    private Integer id;
    //宿舍楼code
    private String buildingCode;
    //楼层code
    private String stepCode;
    //宿舍code
    private String roomCode;
    //房间号
    private String roomNumber;
    //宿舍名
    private String roomName;
    //可入住人数
    private Integer caninNumber;
    //已入住人数
    private Integer incomeNumber;
    //社长学号
    private String leaderStudentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCaninNumber() {
        return caninNumber;
    }

    public void setCaninNumber(Integer caninNumber) {
        this.caninNumber = caninNumber;
    }

    public Integer getIncomeNumber() {
        return incomeNumber;
    }

    public void setIncomeNumber(Integer incomeNumber) {
        this.incomeNumber = incomeNumber;
    }

    public String getLeaderStudentid() {
        return leaderStudentid;
    }

    public void setLeaderStudentid(String leaderStudentid) {
        this.leaderStudentid = leaderStudentid;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
