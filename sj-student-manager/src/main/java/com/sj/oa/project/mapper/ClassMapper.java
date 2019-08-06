package com.sj.oa.project.mapper;

import com.sj.oa.project.po.Classall;

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
}
