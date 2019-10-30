package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckEveningStudyMapper {

    /**
     * 根据limit查年级
     */
    List<YearSessionInfo> selectYearSessionInfoByLimit(Integer number);

    /**
     * 根据grade查班级
     */
    List<Classall> selectClassInfoByGrade(@Param("yearSessionInfos") List<YearSessionInfo> yearSessionInfos);

    /**
     * 根据class_name查学生
     */
    List<User> selectUserByClassName(List<Classall> Classall);

}
