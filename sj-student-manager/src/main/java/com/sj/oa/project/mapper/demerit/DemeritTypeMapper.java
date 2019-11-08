package com.sj.oa.project.mapper.demerit;


import com.sj.oa.project.po.demerit.DemeritType;

import java.util.List;

public interface DemeritTypeMapper {

    /**
     *
     * 批量删除
     */
    int deleteByPrimaryKeys(String[] ids) throws Exception;


    /**
     * 添加
     * @param demerittype
     * @return
     */
    int insertSelective(DemeritType demerittype);

    /**
     * 主键查询
     * @param dType
     * @return
     */
    DemeritType selectByPrimaryKey(String dType);

    /**
     * 修改
     * @param demerittype
     * @return
     */
    int updateByPrimaryKeySelective(DemeritType demerittype);


    /**
     *
     * @描述 扣分列表
     *
     * @date 2018/9/15 13:39
     */
    List<DemeritType> selectDemeritTypeList(DemeritType demerittype);



    /**
     *
     * @描述 检验扣分编码唯一性
     *
     * @date 2018/9/16 11:42
     */
    DemeritType checkDemeritTypeUnique(String dType);
}
