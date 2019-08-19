package com.sj.oa.project.po.college;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/8/7.
 */
public class YearSessionInfo extends BasePo {

    private Integer id;

    private Integer yearSession;

    private Integer studentNumbers;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYearSession() {
        return yearSession;
    }

    public void setYearSession(Integer yearSession) {
        this.yearSession = yearSession;
    }

    public Integer getStudentNumbers() {
        return studentNumbers;
    }

    public void setStudentNumbers(Integer studentNumbers) {
        this.studentNumbers = studentNumbers;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
