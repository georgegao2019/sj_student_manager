package com.sj.oa.project.service.dormitory;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.dormitory.DormitoryCouchMapper;
import com.sj.oa.project.po.dormitory.DormitoryCouch;
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
public class DormitoryCouchServiceImpl implements IDormitoryCouchService {

    @Autowired
    private DormitoryCouchMapper dormitoryCouchMapper;

    @Override
    public int insertSelective(DormitoryCouch record) {
        return dormitoryCouchMapper.insertSelective(record);
    }

    @Override
    public DormitoryCouch selectByPrimaryKey(Integer id) {
        return dormitoryCouchMapper.selectByPrimaryKey(id);
    }

    @Override
    public DormitoryCouch selectByCouchCode(String couchCode) {
        return dormitoryCouchMapper.selectByCouchCode(couchCode);
    }

    @Override
    public int updateByPrimaryKeySelective(DormitoryCouch record) {
        return dormitoryCouchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return dormitoryCouchMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<DormitoryCouch> selectByDormitoryCouch(DormitoryCouch record) {
        return dormitoryCouchMapper.selectByDormitoryCouch(record);
    }

    @Override
    public String checkCouchNumberUnique(DormitoryCouch record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dmId = record.getId();
        DormitoryCouch info = dormitoryCouchMapper.checkCouchNumberUnique(record.getCouchNumber(),record.getRoomCode());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dmId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }
}
