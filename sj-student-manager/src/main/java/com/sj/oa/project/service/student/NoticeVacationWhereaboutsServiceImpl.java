package com.sj.oa.project.service.student;

import com.sj.oa.project.mapper.student.NoticeVacationWhereaboutsMapper;
import com.sj.oa.project.po.student.NoticeVacationWhereabouts;
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
public class NoticeVacationWhereaboutsServiceImpl implements INoticeVacationWhereaboutsService {

    @Autowired
    private NoticeVacationWhereaboutsMapper noticeVacationWhereaboutsMapper;

    @Override
    public int insertSelective(NoticeVacationWhereabouts record) {
        return noticeVacationWhereaboutsMapper.insertSelective(record);
    }

    @Override
    public int insertBatch(List<NoticeVacationWhereabouts> records) {
        return noticeVacationWhereaboutsMapper.insertBatch(records);
    }

    @Override
    public NoticeVacationWhereabouts selectByPrimaryKey(Integer id) {

        return noticeVacationWhereaboutsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NoticeVacationWhereabouts record) {
        return noticeVacationWhereaboutsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return noticeVacationWhereaboutsMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int deleteByNoticeId(Integer[] id) {
        return noticeVacationWhereaboutsMapper.deleteByNoticeId(id);
    }

    @Override
    public List<NoticeVacationWhereabouts> selectByNoticeVacationWhereabouts(NoticeVacationWhereabouts record) {
        return noticeVacationWhereaboutsMapper.selectByNoticeVacationWhereabouts(record);
    }

}
