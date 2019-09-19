package com.sj.oa.project.service.student;

import com.sj.oa.project.po.student.NoticeVacation;

import java.util.List;

/**
 * 学籍状态 iservice
 * Created by gaojun on 2019/8/31.
 */
public interface INoticeVacationService {

    int insertSelective(NoticeVacation record);

    NoticeVacation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeVacation record);

    int deleteByPrimaryKeys(Integer[] id);

    /**
     * 列表条件查询
     * @param record
     * @return
     */
    List<NoticeVacation> selectByNoticeVacation(NoticeVacation record);
}
