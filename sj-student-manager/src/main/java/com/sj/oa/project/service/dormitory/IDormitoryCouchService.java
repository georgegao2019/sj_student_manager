package com.sj.oa.project.service.dormitory;

import com.sj.oa.project.po.dormitory.DormitoryCouch;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface IDormitoryCouchService {

    int insertSelective(DormitoryCouch record);

    DormitoryCouch selectByPrimaryKey(Integer id);

    DormitoryCouch selectByCouchCode(String buildingCode);

    int updateByPrimaryKeySelective(DormitoryCouch record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<DormitoryCouch> selectByDormitoryCouch(DormitoryCouch record);

    /**
     * 校验宿舍楼code
     * @param record
     * @return
     */
    String checkCouchNumberUnique(DormitoryCouch record);

}
