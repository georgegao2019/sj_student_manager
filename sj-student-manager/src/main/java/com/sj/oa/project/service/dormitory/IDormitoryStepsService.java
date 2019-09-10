package com.sj.oa.project.service.dormitory;

import com.sj.oa.project.po.dormitory.DormitorySteps;
import com.sj.oa.project.po.dto.DormitoryBuildingTree;
import com.sj.oa.project.po.dto.DormitoryStepsTree;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface IDormitoryStepsService {

    int insertSelective(DormitorySteps record);

    DormitorySteps selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DormitorySteps record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<DormitorySteps> selectByDormitorySteps(DormitorySteps record);

    /**
     * 校验宿舍楼楼层数
     * @param record
     * @return
     */
    String checkStepUnique(DormitorySteps record);

    List<DormitoryStepsTree> selectByBuildingCode(String buildingCode);
}
