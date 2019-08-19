package com.sj.oa.project.service.college;

import com.sj.oa.project.po.college.YearSessionInfo;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface IYearSessionInfoService {

    int insertSelective(YearSessionInfo record);

    YearSessionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YearSessionInfo record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<YearSessionInfo> selectByYearSessionInfo(YearSessionInfo record);
}
