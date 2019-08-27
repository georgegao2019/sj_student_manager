package com.sj.oa.project.po.dto;

import com.sj.oa.project.po.dormitory.DormitoryBuilding;
import com.sj.oa.project.po.dormitory.DormitorySteps;

import java.util.List;

/**
 * Created by gaojun on 2019/8/20.
 */
public class DormitoryBuildingTree extends DormitoryBuilding {

    private List<DormitorySteps> steps;

    public List<DormitorySteps> getSteps() {
        return steps;
    }

    public void setSteps(List<DormitorySteps> steps) {
        this.steps = steps;
    }
}
