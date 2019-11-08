package com.sj.oa.project.po.demerit;

import com.sj.oa.framework.web.po.BasePo;

public class DemeritType extends BasePo {
    private Integer id;

    //扣分类型
    private String dType;

    //扣分信息
    private String tMsg;

    //状态 0 有效    1 失效
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String gettMsg() {
        return tMsg;
    }

    public void settMsg(String tMsg) {
        this.tMsg = tMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
