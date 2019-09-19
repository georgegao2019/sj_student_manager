package com.sj.oa.project.mapper.student;


import com.sj.oa.project.po.student.NoticeVacation;

import java.util.List;

/**
 * 假期去向 mapper
 * Created by gaojun on 2019/8/27.
 */
public interface NoticeVacationMapper {

    /*
     * 添加
     */
    int insertSelective(NoticeVacation record);

    /*
     * 根据Id主键查询假期去向信息
     */
    NoticeVacation selectByPrimaryKey(Integer id);

    /*
     * 根据studentid查询学生假期去向
     */
    NoticeVacation selectByStudentid(String studentid);

    /*
     * 更改学生假期去向
     */
    int updateByPrimaryKeySelective(NoticeVacation record);

    /*
     * 批量删除假期去向
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     * 查询学籍列表
     */
    List<NoticeVacation> selectByNoticeVacation(NoticeVacation record);


}
