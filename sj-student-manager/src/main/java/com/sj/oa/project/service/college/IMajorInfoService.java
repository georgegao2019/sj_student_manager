package com.sj.oa.project.service.college;

import com.sj.oa.project.po.MajorInfo;

import java.util.List;

/**
 * Created by gaojun on 2019/7/30.
 */
public interface IMajorInfoService {

    int insertSelective(MajorInfo majorInfo);

    MajorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorInfo majorInfo);

    //列表条件查询
    List<MajorInfo> selectByMajorInfo(MajorInfo record);
}
