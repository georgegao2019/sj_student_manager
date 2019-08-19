package com.sj.oa.project.service.dormitory;

import com.sj.oa.project.po.dormitory.DormitoryBuilding;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface IDormitoryBuildingService {

    int insertSelective(DormitoryBuilding record);

    DormitoryBuilding selectByPrimaryKey(Integer id);

    DormitoryBuilding selectByBuildingCode(String buildingCode);

    int updateByPrimaryKeySelective(DormitoryBuilding record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<DormitoryBuilding> selectByDormitoryBuilding(DormitoryBuilding record);

    /**
     * 校验宿舍楼code
     * @param record
     * @return
     */
    String checkDmCodeUnique(DormitoryBuilding record);

    /**
     * 校验宿舍楼名称
     * @param record
     * @return
     */
    String checkDmNameUnique(DormitoryBuilding record);
}
