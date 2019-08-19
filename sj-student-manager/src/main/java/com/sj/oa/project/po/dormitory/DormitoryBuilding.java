package com.sj.oa.project.po.dormitory;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/8/12.
 */
public class DormitoryBuilding extends BasePo {

    private Integer id;

    //宿舍楼code
    private String buildingCode;
    //宿舍楼名称
    private String buildingName;
    //宿舍楼地址
    private String buildingAddress;
    //宿舍楼楼层数
    private Integer buildingSteps;
    //状态
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public Integer getBuildingSteps() {
        return buildingSteps;
    }

    public void setBuildingSteps(Integer buildingSteps) {
        this.buildingSteps = buildingSteps;
    }
}
