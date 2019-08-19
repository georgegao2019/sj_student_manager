package com.sj.oa.project.service.dormitory;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.DormitoryRoomMapper;
import com.sj.oa.project.po.DormitoryRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/8/1.
 * 宿舍room serviceImpl
 */
@Service
@Transactional
public class DormitoryRoomServiceImpl implements IDormitoryRoomService {

    @Autowired
    private DormitoryRoomMapper dormitoryRoomMapper;

    @Override
    public int insertSelective(DormitoryRoom record) {
        return dormitoryRoomMapper.insertSelective(record);
    }

    @Override
    public DormitoryRoom selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DormitoryRoom record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return dormitoryRoomMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<DormitoryRoom> selectByDormitoryRoom(DormitoryRoom record) {
        return dormitoryRoomMapper.selectByDormitoryRoom(record);
    }


    @Override
    public String checkRoomCodeUnique(DormitoryRoom record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dsId = record.getId();
        DormitoryRoom info = dormitoryRoomMapper.checkRoomCodeUnique(record);

        //判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dsId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

    @Override
    public String checkRoomNameUnique(DormitoryRoom record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer dsId = record.getId();
        DormitoryRoom info = dormitoryRoomMapper.checkRoomNameUnique(record);

        //判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dsId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

}
