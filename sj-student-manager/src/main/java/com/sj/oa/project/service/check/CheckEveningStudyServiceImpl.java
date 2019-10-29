package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.check.CheckEveningStudyMapper;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckEveningStudyServiceImpl implements ICheckEveningStudyService {

    @Autowired
    private CheckEveningStudyMapper checkEveningStudyMapper;

    /**
     * 根据limit查年级
     */
    public List<YearSessionInfo> selectYearSessionInfoByLimit(Integer number){
        return checkEveningStudyMapper.selectYearSessionInfoByLimit(number);
        //return null;
    }

    /**
     * 根据grade查班级
     */
    public List<Classall> selectClassInfoByGrade(List<String> grades){
        return checkEveningStudyMapper.selectClassInfoByGrade(grades);
    }

    /**
     * 根据class_name查学生
     */
    public List<User> selectUserByClassName(List<String> className){
        return checkEveningStudyMapper.selectUserByClassName(className);
    }
}
