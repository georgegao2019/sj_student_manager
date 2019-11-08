package com.sj.oa.project.service.check;

import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;

import java.util.List;

public interface ICheckEveningStudyService {
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

    /**
     * 查违规类型
     */
    List<Demerit> selectDemeritByType(String type);

    int insertCheckEveningStudy(List<CheckEveningStudy> checkEveningStudies);

    List<CheckEveningStudy> selectCheckEveningStudyByTime(String[] classNames);
}
