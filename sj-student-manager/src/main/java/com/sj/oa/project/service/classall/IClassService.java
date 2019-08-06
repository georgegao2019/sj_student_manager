package com.sj.oa.project.service.classall;

import com.sj.oa.project.po.Classall;
import com.sj.oa.project.po.Major;

import java.util.List;

/**
 * Created by dell on 2019-08-03.
 */
public interface IClassService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated
     */
    int deleteByPrimaryKeys(Integer[] id) throws Exception ;



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated
     */
    int insertSelective(Classall record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated
     */
    Classall selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Classall record) throws Exception;

    /**
     *
     * @描述 专业列表
     *
     * @date 2018/9/15 13:39
     */
    List<Classall> selectClassList(Classall classall);




}
