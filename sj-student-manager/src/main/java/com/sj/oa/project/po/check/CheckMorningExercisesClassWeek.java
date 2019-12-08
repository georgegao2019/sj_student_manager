package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

public class CheckMorningExercisesClassWeek extends BasePo {

    private Integer id;
    //班级名称
    private String className;
    //周一 默认为 1
    private Integer week1;
    //周二 默认为 2
    private Integer week2;
    //周三 默认为 3
    private Integer week3;
    //周四 默认为 4
    private Integer week4;
    //周五 默认为 5
    private Integer week5;
    //周六 默认为 6
    private Integer week6;
    //周日 默认为 7
    private Integer week7;
    //平均分
    private double averageMark;

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

    public Integer getWeek1() {
        return week1;
    }

    public void setWeek1(Integer week1) {
        this.week1 = week1;
    }

    public Integer getWeek2() {
        return week2;
    }

    public void setWeek2(Integer week2) {
        this.week2 = week2;
    }

    public Integer getWeek3() {
        return week3;
    }

    public void setWeek3(Integer week3) {
        this.week3 = week3;
    }

    public Integer getWeek4() {
        return week4;
    }

    public void setWeek4(Integer week4) {
        this.week4 = week4;
    }

    public Integer getWeek5() {
        return week5;
    }

    public void setWeek5(Integer week5) {
        this.week5 = week5;
    }

    public Integer getWeek6() {
        return week6;
    }

    public void setWeek6(Integer week6) {
        this.week6 = week6;
    }

    public Integer getWeek7() {
        return week7;
    }

    public void setWeek7(Integer week7) {
        this.week7 = week7;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
