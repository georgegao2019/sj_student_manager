package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

public class CheckMorningExercisesClass extends BasePo {
    private Integer id;
    //班级名称
    private String className;
    //专业code
    private String majorCode;
    //总人数
    private  Integer totalNumber;
    //应到人数
    private  Integer shouldNumber;
    //实到人数6:30
    private  Integer realNumber1;
    //实到人数6:35
    private  Integer realNumber2;
    //导员名字
    private String headmaster;
    //操前纪律分
    private Integer disciplineMark;
    //到勤人数分数
    private Integer totalNumberMark;
    //迟到早退人数分数
    private Integer lateMark;
    //迟到人员名字
    private String lateName;
    //请假人员名字
    private String qingjiaName;
    //动作不齐，原地踏步
    private Integer qMark1;
    //动作不齐，上肢运动
    private Integer qMark2;
    //动作不齐，颈部运动
    private Integer qMark3;
    //动作不齐，扩胸运动
    private Integer qMark4;
    //动作不齐，体转运动
    private Integer qMark5;
    //动作不齐，下肢运动
    private Integer qMark6;
    //动作不齐，全身运动
    private Integer qMark7;
    //动作不齐，跑跳运动
    private Integer qMark8;
    //动作不齐，整理运动
    private Integer qMark9;

    //动作不标准，原地踏步
    private Integer zMark1;
    //动作不标准，上肢运动
    private Integer zMark2;
    //动作不标准，颈部运动
    private Integer zMark3;
    //动作不标准，扩胸运动
    private Integer zMark4;
    //动作不标准，体转运动
    private Integer zMark5;
    //动作不标准，下肢运动
    private Integer zMark6;
    //动作不标准，全身运动
    private Integer zMark7;
    //动作不标准，跑跳运动
    private Integer zMark8;
    //动作不标准，整理运动
    private Integer zMark9;

    //总分
    private Integer totalMark;

    //名次

    private Integer rownum;

    //状态 0有效  1失效
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNamber) {
        this.totalNumber = totalNamber;
    }

    public Integer getShouldNumber() {
        return shouldNumber;
    }

    public void setShouldNumber(Integer shouldNumber) {
        this.shouldNumber = shouldNumber;
    }

    public Integer getRealNumber1() {
        return realNumber1;
    }

    public void setRealNumber1(Integer realNumber1) {
        this.realNumber1 = realNumber1;
    }

    public Integer getRealNumber2() {
        return realNumber2;
    }

    public void setRealNumber2(Integer realNumber2) {
        this.realNumber2 = realNumber2;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public Integer getDisciplineMark() {
        return disciplineMark;
    }

    public void setDisciplineMark(Integer disciplineMark) {
        this.disciplineMark = disciplineMark;
    }

    public Integer getTotalNumberMark() {
        return totalNumberMark;
    }

    public void setTotalNumberMark(Integer totalNumberMark) {
        this.totalNumberMark = totalNumberMark;
    }

    public Integer getLateMark() {
        return lateMark;
    }

    public void setLateMark(Integer lateMark) {
        this.lateMark = lateMark;
    }

    public String getLateName() {
        return lateName;
    }

    public void setLateName(String lateName) {
        this.lateName = lateName;
    }

    public String getQingjiaName() {
        return qingjiaName;
    }

    public void setQingjiaName(String qingjiaName) {
        this.qingjiaName = qingjiaName;
    }

    public Integer getqMark1() {
        return qMark1;
    }

    public void setqMark1(Integer qMark1) {
        this.qMark1 = qMark1;
    }

    public Integer getqMark2() {
        return qMark2;
    }

    public void setqMark2(Integer qMark2) {
        this.qMark2 = qMark2;
    }

    public Integer getqMark3() {
        return qMark3;
    }

    public void setqMark3(Integer qMark3) {
        this.qMark3 = qMark3;
    }

    public Integer getqMark4() {
        return qMark4;
    }

    public void setqMark4(Integer qMark4) {
        this.qMark4 = qMark4;
    }

    public Integer getqMark5() {
        return qMark5;
    }

    public void setqMark5(Integer qMark5) {
        this.qMark5 = qMark5;
    }

    public Integer getqMark6() {
        return qMark6;
    }

    public void setqMark6(Integer qMark6) {
        this.qMark6 = qMark6;
    }

    public Integer getqMark7() {
        return qMark7;
    }

    public void setqMark7(Integer qMark7) {
        this.qMark7 = qMark7;
    }

    public Integer getqMark8() {
        return qMark8;
    }

    public void setqMark8(Integer qMark8) {
        this.qMark8 = qMark8;
    }

    public Integer getqMark9() {
        return qMark9;
    }

    public void setqMark9(Integer qMark9) {
        this.qMark9 = qMark9;
    }

    public Integer getzMark1() {
        return zMark1;
    }

    public void setzMark1(Integer zMark1) {
        this.zMark1 = zMark1;
    }

    public Integer getzMark2() {
        return zMark2;
    }

    public void setzMark2(Integer zMark2) {
        this.zMark2 = zMark2;
    }

    public Integer getzMark3() {
        return zMark3;
    }

    public void setzMark3(Integer zMark3) {
        this.zMark3 = zMark3;
    }

    public Integer getzMark4() {
        return zMark4;
    }

    public void setzMark4(Integer zMark4) {
        this.zMark4 = zMark4;
    }

    public Integer getzMark5() {
        return zMark5;
    }

    public void setzMark5(Integer zMark5) {
        this.zMark5 = zMark5;
    }

    public Integer getzMark6() {
        return zMark6;
    }

    public void setzMark6(Integer zMark6) {
        this.zMark6 = zMark6;
    }

    public Integer getzMark7() {
        return zMark7;
    }

    public void setzMark7(Integer zMark7) {
        this.zMark7 = zMark7;
    }

    public Integer getzMark8() {
        return zMark8;
    }

    public void setzMark8(Integer zMark8) {
        this.zMark8 = zMark8;
    }

    public Integer getzMark9() {
        return zMark9;
    }

    public void setzMark9(Integer zMark9) {
        this.zMark9 = zMark9;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }
}
