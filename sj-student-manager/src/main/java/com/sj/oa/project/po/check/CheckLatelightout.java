package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

/**
 * Created by gaojun on 2019/8/6.
 */
public class CheckLatelightout extends BasePo {

    private Integer id;
    //宿舍号
    private String dormitoryCode;
    //晚熄灯时间
    private Date lightoutTime;
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

    public String getDormitoryCode() {
        return dormitoryCode;
    }

    public void setDormitoryCode(String dormitoryCode) {
        this.dormitoryCode = dormitoryCode;
    }

    public Date getLightoutTime() {
        return lightoutTime;
    }

    public void setLightoutTime(Date lightoutTime) {
        this.lightoutTime = lightoutTime;
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
