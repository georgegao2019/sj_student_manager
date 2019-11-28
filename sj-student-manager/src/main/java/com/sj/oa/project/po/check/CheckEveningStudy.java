package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.demerit.Demerit;

public class CheckEveningStudy  extends BasePo {

    private Integer id;

    //学号
    private String studentid;

    //姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdMsg() {
        return dMsg;
    }

    public void setdMsg(String dMsg) {
        this.dMsg = dMsg;
    }

    //扣分信息
    private String dMsg;

    //扣分编号
    private String dCode;

    //请假状态 0未请假 1请假
    private Integer vacate;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;

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


}
