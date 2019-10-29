package com.sj.oa.project.service.check;

import com.sj.oa.project.po.User;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;

import java.util.List;

public interface ICheckEveningStudyService {
    /**
     * 根据limit查年级
     */
    List<YearSessionInfo> selectYearSessionInfoByLimit(Integer number);

    /**
     * 根据grade查班级
     */
    List<Classall> selectClassInfoByGrade(List<String> grades);

    /**
     * 根据class_name查学生
     */
    List<User> selectUserByClassName(List<String> className);
}
