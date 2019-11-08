package com.sj.oa.project.mapper.dormitory;



import com.sj.oa.project.po.dormitory.DormitoryRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface DormitoryRoomMapper {

    /**
     * 添加
     */
    int insertSelective(DormitoryRoom record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    DormitoryRoom selectByPrimaryKey(Integer id);

    /**
     * 根据roomCode查询单个宿舍
     */

    DormitoryRoom selectByRoomCode(String roomCode);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(DormitoryRoom record);

    /* 批量删除用户 */
    int deleteByPrimaryKeys(Integer[] ids);

    /* 用户列表 以及 根据条件查询 */
    List<DormitoryRoom> selectByDormitoryRoom(DormitoryRoom record);

    /* 校验房间编号 */
    DormitoryRoom checkRoomNumberUnique(DormitoryRoom record);

    /* 更新已入住人数 */
    int updateIncomeNumberByRoomCode(
            @Param(value = "roomCode") String roomCode,
            @Param(value = "number") Integer number);

    /**
     * 根据楼层查找房间对象
     * @param stepCode
     * @return
     */
    List<DormitoryRoom> findRoom(String stepCode);

}
