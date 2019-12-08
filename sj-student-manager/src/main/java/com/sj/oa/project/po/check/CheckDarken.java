package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.dormitory.DormitoryCouch;
import com.sj.oa.project.po.dormitory.DormitoryRoom;

public class CheckDarken extends BasePo {

    private Integer id;

    //楼编码
    private String buildingCode;

    //楼层编码
    private String stepCode;

    //宿舍编码
    private String roomCode;

    //扣分编码
    private String dCode;

    //检查人
    private String checkPerson;

    //状态 0有效 1失效
    private Integer status;

    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

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

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }







}
