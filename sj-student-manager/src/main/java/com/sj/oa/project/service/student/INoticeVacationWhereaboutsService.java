package com.sj.oa.project.service.student;

import com.sj.oa.project.po.student.NoticeVacationWhereabouts;

import java.util.List;

/**
 * 学籍状态 iservice
 * Created by gaojun on 2019/8/31.
 */
public interface INoticeVacationWhereaboutsService {

    int insertSelective(NoticeVacationWhereabouts record);

    int insertBatch(List<NoticeVacationWhereabouts> records);

    NoticeVacationWhereabouts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeVacationWhereabouts record);

    int deleteByPrimaryKeys(Integer[] id);

    int deleteByNoticeId(Integer[] id);

    /**
     * 列表条件查询
     * @param record
     * @return
     */
    List<NoticeVacationWhereabouts> selectByNoticeVacationWhereabouts(NoticeVacationWhereabouts record);
}
