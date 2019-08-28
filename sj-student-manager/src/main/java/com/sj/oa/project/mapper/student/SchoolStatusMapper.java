package com.sj.oa.project.mapper.student;


import com.sj.oa.project.po.student.SchoolStatus;

import java.util.List;

/**
 * 学籍状态 mapper
 * Created by gaojun on 2019/8/27.
 */
public interface SchoolStatusMapper {

    /*
     * 添加
     */
    int insertSelective(SchoolStatus record);

    /*
     * 根据Id主键查询学籍状态信息 登录用此方法
     */
    SchoolStatus selectByPrimaryKey(Integer id);

    /*
     * 根据studentid查询学生学籍状态
     */
    SchoolStatus selectByStudentid(String studentid);

    /*
     * 更改学生学籍状态
     */
    int updateByPrimaryKeySelective(SchoolStatus record);

    /*
     * 批量删除学籍状态
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     * 查询学籍列表
     */
    List<SchoolStatus> selectBySchoolStatus(SchoolStatus record);


}
