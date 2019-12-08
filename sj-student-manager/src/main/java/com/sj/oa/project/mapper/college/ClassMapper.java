package com.sj.oa.project.mapper.college;

import com.sj.oa.project.po.college.Classall;

import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
public interface ClassMapper {
    /**
     * 班级列表
     * @param classall
     * @return
     */
    List<Classall> selectClassList(Classall classall);

    /**
     *
     * 批量删除
     */
    int deleteByPrimaryKeys(Integer[] ids) throws Exception;


    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(Classall record);

    /**
     * 主键查询
     * @param classId
     * @return
     */
    Classall selectByPrimaryKey(Integer classId);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Classall record);


    /**
     *
     * @描述: 查询所有专业下的所有班级 专业归类 树状数据
     *
     * @date: 2018/9/27 11:25
     */
    List<Classall> selectClassAndMajor();

    Classall checkClassNameUnique(String className);


    Classall findTotalNumber(String className);
}
