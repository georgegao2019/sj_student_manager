package com.sj.oa.project.mapper;


import com.sj.oa.project.po.DormitoryBuilding;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface DormitoryBuildingMapper {

    /**
     * 添加
     */
    int insertSelective(DormitoryBuilding record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    DormitoryBuilding selectByPrimaryKey(Integer id);

    /**
     * 根据buildingCode查询单个用户
     */
    DormitoryBuilding selectByBuildingCode(String buildingCode);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(DormitoryBuilding record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<DormitoryBuilding> selectByDormitoryBuilding(DormitoryBuilding record);

    /* 校验宿舍楼code */
    DormitoryBuilding checkDmCodeUnique(String dmCode);

    /* 校验宿舍楼名称 */
    DormitoryBuilding checkDmNameUnique(String dmName);

}
