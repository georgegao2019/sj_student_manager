package com.sj.oa.project.po.dto;

import com.sj.oa.project.po.dormitory.DormitoryBuilding;
import com.sj.oa.project.po.dormitory.DormitorySteps;

import java.util.List;

/**
 * Created by gaojun on 2019/8/20.
 */
public class DormitoryBuildingTree {

    private String id;

    private String name;

    private List<DormitoryStepsTree> children;

    public List<DormitoryStepsTree> getChildren() {
        return children;
    }

    public void setChildren(List<DormitoryStepsTree> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
