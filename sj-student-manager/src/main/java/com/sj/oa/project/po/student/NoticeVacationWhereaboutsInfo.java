package com.sj.oa.project.po.student;

/**
 * Created by gaojun on 2019/9/21.
 */
public class NoticeVacationWhereaboutsInfo {

    //id
    private Integer id;

    //总人数
    private Integer totalNumbers;

    //已填写人数
    private Integer alreadyInNumbers;

    //留校人数
    private Integer atSchoolNumbers;

    //回家人数
    private Integer atHomeNumbers;

    //外出人数
    private Integer goOutNumbers;


    public Integer getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(Integer totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    public Integer getAlreadyInNumbers() {
        return alreadyInNumbers;
    }

    public void setAlreadyInNumbers(Integer alreadyInNumbers) {
        this.alreadyInNumbers = alreadyInNumbers;
    }

    public Integer getAtSchoolNumbers() {
        return atSchoolNumbers;
    }

    public void setAtSchoolNumbers(Integer atSchoolNumbers) {
        this.atSchoolNumbers = atSchoolNumbers;
    }

    public Integer getAtHomeNumbers() {
        return atHomeNumbers;
    }

    public void setAtHomeNumbers(Integer atHomeNumbers) {
        this.atHomeNumbers = atHomeNumbers;
    }

    public Integer getGoOutNumbers() {
        return goOutNumbers;
    }

    public void setGoOutNumbers(Integer goOutNumbers) {
        this.goOutNumbers = goOutNumbers;
    }
}
