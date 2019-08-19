package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckLatelightout;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface ICheckLatelightoutService {

    int insertSelective(CheckLatelightout record);

    CheckLatelightout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckLatelightout record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckLatelightout> selectByCheckLatelightout(CheckLatelightout record);
}
