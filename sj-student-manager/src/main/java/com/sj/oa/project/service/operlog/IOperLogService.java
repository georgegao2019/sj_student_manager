package com.sj.oa.project.service.operlog;

import com.sj.oa.project.po.OperLog;

import java.util.List;

/**
 * @author 永健
 */
public interface IOperLogService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(OperLog record);

    OperLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperLog record);

    List<OperLog> selectOperLogList(OperLog operLog);

}
