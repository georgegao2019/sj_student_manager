package com.sj.oa.project.mapper.student;



import com.sj.oa.project.po.student.SchoolStatusRecord;

import java.util.List;

/**
 * 学籍状态修改记录 mapper
 * Created by gaojun on 2019/8/27.
 */
public interface SchoolStatusRecordMapper {

    /*
     * 添加
     */
    int insertSelective(SchoolStatusRecord record);

    /*
     * 根据Id主键查询学籍修改记录信息 登录用此方法
     */
    SchoolStatusRecord selectByPrimaryKey(Integer id);

    /*
     * 更改学生学籍修改记录
     */
    int updateByPrimaryKeySelective(SchoolStatusRecord record);

    /*
     * 批量删除学籍修改记录
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     * 查询学籍修改记录列表
     */
    List<SchoolStatusRecord> selectBySchoolStatusRecord(SchoolStatusRecord record);


}
