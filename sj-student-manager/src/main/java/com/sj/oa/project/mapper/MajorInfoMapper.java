package com.sj.oa.project.mapper;

import com.sj.oa.project.po.MajorInfo;

import java.util.List;

/**
 * Created by gaojun on 2019/7/30.
 */
public interface MajorInfoMapper {

    /**
     * 添加
     */
    int insertSelective(MajorInfo record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    MajorInfo selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(MajorInfo record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(String[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<MajorInfo> selectByMajorInfo(MajorInfo record);
}
