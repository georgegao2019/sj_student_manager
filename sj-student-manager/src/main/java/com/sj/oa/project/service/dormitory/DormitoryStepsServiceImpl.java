package com.sj.oa.project.service.dormitory;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.dormitory.DormitoryStepsMapper;
import com.sj.oa.project.po.dormitory.DormitorySteps;
import com.sj.oa.project.po.dto.DormitoryBuildingTree;
import com.sj.oa.project.po.dto.DormitoryStepsTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/8/1.
 * 晚归检查service
 */
@Service
@Transactional
public class DormitoryStepsServiceImpl implements IDormitoryStepsService {

    @Autowired
    private DormitoryStepsMapper dormitoryStepsMapper;

    @Override
    public int insertSelective(DormitorySteps record) {
        return dormitoryStepsMapper.insertSelective(record);
    }

    @Override
    public DormitorySteps selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DormitorySteps record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return dormitoryStepsMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<DormitorySteps> selectByDormitorySteps(DormitorySteps record) {
        return dormitoryStepsMapper.selectByDormitorySteps(record);
    }


    @Override
    public String checkStepUnique(DormitorySteps record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dsId = record.getId();
        DormitorySteps info = dormitoryStepsMapper.checkStepUnique(record);

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dsId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

    @Override
    public List<DormitoryStepsTree> selectByBuildingCode(String buildingCode) {
        return dormitoryStepsMapper.selectByBuildingCode(buildingCode);
    }

}
