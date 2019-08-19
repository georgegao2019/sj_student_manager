package com.sj.oa.project.mapper;


import com.sj.oa.project.po.college.Major;

import java.util.List;

/**
 * Created by dell on 2019-08-03.
 */
public interface MajorMapper {
    /**
     *
     * 批量删除
     */
    int deleteByPrimaryKeys(String[] ids) throws Exception;


    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(Major record);

    /**
     * 主键查询
     * @param majorId
     * @return
     */
    Major selectByPrimaryKey(String majorId);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Major record);


    /**
     *
     * @描述 部门列表
     *
     * @date 2018/9/15 13:39
     */
    List<Major> selectMajorList(Major dept);

    /**
     *
     * @描述 检验名称唯一性
     *
     * @date 2018/9/16 11:42
     */
    Major checkMajorNameUnique(String majorName);

    /**
     *
     * @描述 检验编码唯一性
     *
     * @date 2018/9/16 11:42
     */
    Major checkMajorCodeUnique(String majorCode);



}
