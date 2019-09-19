package com.sj.oa.project.service.student;

import com.sj.oa.project.mapper.student.NoticeVacationMapper;
import com.sj.oa.project.po.student.NoticeVacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/8/1.
 * 学籍状态 serviceImpl
 */
@Service
@Transactional
public class NoticeVacationServiceImpl implements INoticeVacationService {

    @Autowired
    private NoticeVacationMapper noticeVacationMapper;

    @Override
    public int insertSelective(NoticeVacation record) {
        return noticeVacationMapper.insertSelective(record);
    }

    @Override
    public NoticeVacation selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(NoticeVacation record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return noticeVacationMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<NoticeVacation> selectByNoticeVacation(NoticeVacation record) {
        return noticeVacationMapper.selectByNoticeVacation(record);
    }

}
