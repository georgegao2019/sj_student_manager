package com.sj.oa.project.po.demerit;

import com.sj.oa.framework.web.po.BasePo;

public class Demerit extends BasePo {

    private Integer id;

    //扣分编码
    private String dCode;

    //扣分信息
    private String dMsg;

    //扣分分数
    private String dNumber;

    //扣分类型
    private String dType;

    //状态 0 有效    1 失效
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdCode() {
        return dCode;
    }

    public void setdCode(String dCode) {
        this.dCode = dCode;
    }

    public String getdMsg() {
        return dMsg;
    }

    public void setdMsg(String dMsg) {
        this.dMsg = dMsg;
    }

    public String getdNumber() {
        return dNumber;
    }

    public void setdNumber(String dNumber) {
        this.dNumber = dNumber;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}