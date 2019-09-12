package com.sj.oa.project.mapper.dormitory;


import com.sj.oa.project.po.dormitory.DormitoryCouch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface DormitoryCouchMapper {

    /**
     * 添加
     */
    int insertSelective(DormitoryCouch record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    DormitoryCouch selectByPrimaryKey(Integer id);

    /**
     * 根据CouchCode查询单个用户
     */
    DormitoryCouch selectByCouchCode(String CouchCode);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(DormitoryCouch record);


     /* 批量删除用户 */
    int deleteByPrimaryKeys(Integer[] ids);

    /* 根据条件查询 床位列表 */
    List<DormitoryCouch> selectByDormitoryCouch(DormitoryCouch record);

    /* 校验宿舍楼code */
    DormitoryCouch checkCouchNumberUnique(
            @Param(value = "couchNumber") Integer couchNumber,
            @Param(value = "roomCode") String roomCode);
}
