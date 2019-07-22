package com.sj.oa.project.service.tel;

import com.sj.oa.project.po.Tel;

import java.util.List;

/**
 * @author 永健
 */
public interface ITelService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Tel record);

    Tel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tel record);

    List<Tel> selectTelList(Tel tel);
}
