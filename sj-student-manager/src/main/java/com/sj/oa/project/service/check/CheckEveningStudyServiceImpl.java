package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.check.CheckEveningStudyMapper;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;
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
    public List<Classall> selectClassInfoByGrade(List<YearSessionInfo> yearSessionInfos){
        return checkEveningStudyMapper.selectClassInfoByGrade(yearSessionInfos);
        //return null;
    }

    /**
     * 根据class_name查学生
     */
    public List<User> selectUserByClassName(String[] classNames){
        return checkEveningStudyMapper.selectUserByClassName(classNames);
    }

    public List<Demerit> selectDemeritByType(String type){
        return checkEveningStudyMapper.selectDemeritByType(type);
    }

    public int insertCheckEveningStudy(List<CheckEveningStudy> checkEveningStudies){
        return checkEveningStudyMapper.insertCheckEveningStudy(checkEveningStudies);
    }

    public List<CheckEveningStudy> selectCheckEveningStudyByTime(String[] classNames){
        return checkEveningStudyMapper.selectCheckEveningStudyByTime(classNames);
    }

    /**
     *  根据id删除
     */
    public int updateCheckEveningStudyById(CheckEveningStudy checkEveningStudy){
        return checkEveningStudyMapper.updateCheckEveningStudyById(checkEveningStudy);
    }

    /**
     *  根据id修改
     */
    public int deleteCheckEveningStudyById(String[] ids){
        return checkEveningStudyMapper.deleteCheckEveningStudyById(ids);
    }

    public CheckEveningStudy selectCheckEveningStudyById(String id){
        return checkEveningStudyMapper.selectCheckEveningStudyById(id);
    }

    public List<Demerit> selectDemeritByCode(String dCode){
        return checkEveningStudyMapper.selectDemeritByCode(dCode);
    }
}
