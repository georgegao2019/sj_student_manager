package com.sj.oa.project.service.college;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.college.ClassMapper;
import com.sj.oa.project.po.college.Classall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
@Service
public class IClassServiceImpl implements IClassService {
    private Logger log = LoggerFactory.getLogger(IClassServiceImpl.class);

    @Autowired
    ClassMapper classMapper;


    @Override
    public int deleteByPrimaryKeys(Integer[] id) throws Exception {
        return classMapper.deleteByPrimaryKeys(id);

    }
    @Override
    public int insertSelective(Classall record) {
        return classMapper.insertSelective(record);
    }

    @Override
    public Classall selectByPrimaryKey(Integer id) {
        return classMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classall record) throws Exception {
        return classMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Classall> selectClassList(Classall classall) {
        return classMapper.selectClassList(classall);
    }

    /**
     *
     * @描述: 查询所有专业下的所有班级 班级归类 树状数据
     *
     * @date: 2018/9/27 11:25
     */
    @Override
    public List<Classall> selectClassAndMajor()
    {
        return classMapper.selectClassAndMajor();
    }

    @Override
    public String checkClassNameUnique(Classall record) {
        if (record.getId() == null)
        {
            record.setId(-1);
        }
        Integer majorId = record.getId();
        Classall info = classMapper.checkClassNameUnique(record.getClassName());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(majorId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }


}
