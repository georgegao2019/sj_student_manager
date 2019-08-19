package com.sj.oa.project.service.dormitory;

import com.sj.oa.project.po.DormitoryRoom;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface IDormitoryRoomService {

    int insertSelective(DormitoryRoom record);

    DormitoryRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DormitoryRoom record);

    int deleteByPrimaryKeys(Integer[] id);

    /**
     * 列表条件查询
     * @param record
     * @return
     */
    List<DormitoryRoom> selectByDormitoryRoom(DormitoryRoom record);

    /**
     * 校验宿舍code是否存在
     * @param record
     * @return
     */
    String checkRoomCodeUnique(DormitoryRoom record);

    /**
     * 校验宿舍name是否存在
     * @param record
     * @return
     */
    String checkRoomNameUnique(DormitoryRoom record);
}
