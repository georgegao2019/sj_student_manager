package com.sj.oa.project.service.student;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.student.SchoolStatusRecordMapper;
import com.sj.oa.project.po.student.SchoolStatusRecord;
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
public class SchoolStatusRecordServiceImpl implements ISchoolStatusRecordService {

    @Autowired
    private SchoolStatusRecordMapper schoolStatusRecordMapper;

    @Override
    public int insertSelective(SchoolStatusRecord record) {
        return schoolStatusRecordMapper.insertSelective(record);
    }

    @Override
    public SchoolStatusRecord selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SchoolStatusRecord record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return schoolStatusRecordMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<SchoolStatusRecord> selectBySchoolStatusRecord(SchoolStatusRecord record) {
        return schoolStatusRecordMapper.selectBySchoolStatusRecord(record);
    }

}
