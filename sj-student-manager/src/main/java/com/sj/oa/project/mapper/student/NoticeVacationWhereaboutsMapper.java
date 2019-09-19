package com.sj.oa.project.mapper.student;


import com.sj.oa.project.po.student.NoticeVacationWhereabouts;

import java.util.List;

/**
 * 学生假期去向 mapper
 * Created by gaojun on 2019/8/27.
 */
public interface NoticeVacationWhereaboutsMapper {

    /*
     * 添加
     */
    int insertSelective(NoticeVacationWhereabouts record);

    /*
     * 批量添加
     */
    int insertBatch(List<NoticeVacationWhereabouts> list);

    /*
     * 根据Id主键查询假期去向信息
     */
    NoticeVacationWhereabouts selectByPrimaryKey(Integer id);

    /*
     * 根据studentid查询学生假期去向
     */
    NoticeVacationWhereabouts selectByStudentid(String studentid);

    /*
     * 更改学生假期去向
     */
    int updateByPrimaryKeySelective(NoticeVacationWhereabouts record);

    /*
     * 批量删除假期去向
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     * 根据主表id删除
     */
    int deleteByNoticeId(Integer[] ids);


    /*
     * 查询学籍列表
     */
    List<NoticeVacationWhereabouts> selectByNoticeVacationWhereabouts(NoticeVacationWhereabouts record);


}
