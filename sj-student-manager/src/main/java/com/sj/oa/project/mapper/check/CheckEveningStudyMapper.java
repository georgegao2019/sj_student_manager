package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;
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
    List<Classall> selectClassInfoByGrade(List<YearSessionInfo> yearSessionInfos);

    /**
     * 根据class_name查学生
     */
    List<User> selectUserByClassName(String[] classNames);

    List<Demerit> selectDemeritByType(String type);

    int insertCheckEveningStudy(List<CheckEveningStudy> checkEveningStudies);

    List<CheckEveningStudy> selectCheckEveningStudyByTime(String[] classNames);

    /**
     *  根据id删除
     */
    int updateCheckEveningStudyById(CheckEveningStudy checkEveningStudy);

    /**
     *  根据id查询
     */
    CheckEveningStudy selectCheckEveningStudyById(String id);

    /**
     *  根据id修改
     */
    int deleteCheckEveningStudyById(String[] ids);

    List<Demerit> selectDemeritByCode(String dCode);
}
