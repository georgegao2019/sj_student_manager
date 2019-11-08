package com.sj.oa.project.mapper.demerit;


import com.sj.oa.project.po.demerit.Demerit;

import java.util.List;

public interface DemeritMapper {
    /**
     *
     * 批量删除
     */
    int deleteByPrimaryKeys(String[] ids) throws Exception;


    /**
     * 添加
     * @param demerit
     * @return
     */
    int insertSelective(Demerit demerit);

    /**
     * 主键查询
     * @param dCode
     * @return
     */
    Demerit selectByPrimaryKey(String dCode);

    /**
     * 修改
     * @param demerit
     * @return
     */
    int updateByPrimaryKeySelective(Demerit demerit);


    /**
     *
     * @描述 扣分列表
     *
     * @date 2018/9/15 13:39
     */
    List<Demerit> selectDemeritList(Demerit demerit);



    /**
     *
     * @描述 检验扣分编码唯一性
     *
     * @date 2018/9/16 11:42
     */
    Demerit checkDemeritCodeUnique(String dCode);


}
