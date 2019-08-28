package com.sj.oa.project.service.student;

import com.sj.oa.project.po.student.SchoolStatusRecord;

import java.util.List;

/**
 * 学籍状态 iservice
 * Created by gaojun on 2019/8/31.
 */
public interface ISchoolStatusRecordService {

    int insertSelective(SchoolStatusRecord record);

    SchoolStatusRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchoolStatusRecord record);

    int deleteByPrimaryKeys(Integer[] id);

    /**
     * 列表条件查询
     * @param record
     * @return
     */
    List<SchoolStatusRecord> selectBySchoolStatusRecord(SchoolStatusRecord record);
}
