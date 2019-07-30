package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/7/30.
 * 专业信息bean
 * t_major_info
 */
public class MajorInfo extends BasePo {

    Integer id;
    //专业code
    String majorCode;
    //专业名称
    String majorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
