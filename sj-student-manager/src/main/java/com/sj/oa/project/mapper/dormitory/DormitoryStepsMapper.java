package com.sj.oa.project.mapper.dormitory;


import com.sj.oa.project.po.dormitory.DormitorySteps;
import com.sj.oa.project.po.dto.DormitoryBuildingTree;
import com.sj.oa.project.po.dto.DormitoryStepsTree;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface DormitoryStepsMapper {

    /**
     * 添加
     */
    int insertSelective(DormitorySteps record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    DormitorySteps selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(DormitorySteps record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     * 宿舍楼层列表
     */
    List<DormitorySteps> selectByDormitorySteps(DormitorySteps record);

    /* 校验宿舍楼code */
    DormitorySteps checkStepUnique(DormitorySteps record);

    List<DormitoryBuildingTree> selectDormitoryBuildingTree();

    List<DormitoryStepsTree> selectByBuildingCode(String buildingCode);

    /**
     * 根据stepCode 查询楼层信息
     */
    DormitorySteps selectByStepCode(String stepCode);

    List<DormitorySteps> findStep(String buildingCode);
}
