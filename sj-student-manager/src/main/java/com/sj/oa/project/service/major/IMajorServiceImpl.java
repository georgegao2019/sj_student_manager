package com.sj.oa.project.service.major;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.MajorMapper;
import com.sj.oa.project.po.Major;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2019-08-03.
 */
@Service
public class IMajorServiceImpl implements IMajorService {

    private Logger log = LoggerFactory.getLogger(IMajorServiceImpl.class);
    @Autowired
    MajorMapper majorMapper;

    /**
     * 批量删除专业
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKeys(String[] ids) throws Exception {
        return majorMapper.deleteByPrimaryKeys(ids);
    }

    /**
     * 新增专业
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Major record) {
        return majorMapper.insertSelective(record);
    }

    /**
     * 根据主键查询专业
     * @param id
     * @return
     */
    @Override
    public Major selectByPrimaryKey(String id) {
        return majorMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新专业
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public int updateByPrimaryKeySelective(Major record) throws Exception {
        return majorMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 查询专业列表
     * @param major
     * @return
     */
    @Override
    public List<Major> selectMajorList(Major major) {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 校验专业名称唯一
     * @param major 专业信息
     * @return
     */
    @Override
    public String checkMajorNameUnique(Major major) {
        if (major.getId() == null)
        {
            major.setId(-1);
        }
        Integer majorId = major.getId();
        Major info = majorMapper.checkMajorNameUnique(major.getMajorName());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(majorId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

    /**
     * 校验专业代码唯一
     * @param major 专业信息
     * @return
     */
    @Override
    public String checkMajorCodeUnique(Major major) {
        if (major.getId() == null)
        {
            major.setId(-1);
        }
        Integer majorId = major.getId();
        Major info = majorMapper.checkMajorCodeUnique(major.getMajorCode());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(majorId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }
}
