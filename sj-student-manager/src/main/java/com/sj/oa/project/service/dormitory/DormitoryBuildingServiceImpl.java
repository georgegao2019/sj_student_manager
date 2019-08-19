package com.sj.oa.project.service.dormitory;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.DormitoryBuildingMapper;
import com.sj.oa.project.po.dormitory.DormitoryBuilding;
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
public class DormitoryBuildingServiceImpl implements IDormitoryBuildingService {

    @Autowired
    private DormitoryBuildingMapper dormitoryBuildingMapper;

    @Override
    public int insertSelective(DormitoryBuilding record) {
        return dormitoryBuildingMapper.insertSelective(record);
    }

    @Override
    public DormitoryBuilding selectByPrimaryKey(Integer id) {
        return dormitoryBuildingMapper.selectByPrimaryKey(id);
    }
    @Override
    public DormitoryBuilding selectByBuildingCode(String buildingCode) {
        return dormitoryBuildingMapper.selectByBuildingCode(buildingCode);
    }

    @Override
    public int updateByPrimaryKeySelective(DormitoryBuilding record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return dormitoryBuildingMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<DormitoryBuilding> selectByDormitoryBuilding(DormitoryBuilding record) {
        return dormitoryBuildingMapper.selectByDormitoryBuilding(record);
    }

    @Override
    public String checkDmCodeUnique(DormitoryBuilding record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dmId = record.getId();
        DormitoryBuilding info = dormitoryBuildingMapper.checkDmCodeUnique(record.getBuildingCode());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dmId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

    @Override
    public String checkDmNameUnique(DormitoryBuilding record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dmId = record.getId();
        DormitoryBuilding info = dormitoryBuildingMapper.checkDmNameUnique(record.getBuildingName());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dmId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }
}
