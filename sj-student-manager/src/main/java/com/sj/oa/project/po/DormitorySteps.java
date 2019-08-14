package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/8/12.
 */
public class DormitorySteps extends BasePo {

    private Integer id;
    //宿舍楼id
    private Integer buildingId;
    //宿舍楼名称
    private String buildingName;
    //层数
    private Integer step;
    //宿舍数
    private Integer allNumbers;
    //已入住宿舍数
    private Integer alreadyNumbers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getAllNumbers() {
        return allNumbers;
    }

    public void setAllNumbers(Integer allNumbers) {
        this.allNumbers = allNumbers;
    }

    public Integer getAlreadyNumbers() {
        return alreadyNumbers;
    }

    public void setAlreadyNumbers(Integer alreadyNumbers) {
        this.alreadyNumbers = alreadyNumbers;
    }
}
