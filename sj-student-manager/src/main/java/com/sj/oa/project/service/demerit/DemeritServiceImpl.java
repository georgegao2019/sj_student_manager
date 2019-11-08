package com.sj.oa.project.service.demerit;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.demerit.DemeritMapper;
import com.sj.oa.project.po.demerit.Demerit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemeritServiceImpl implements IDemeritService {

    private Logger log = LoggerFactory.getLogger(DemeritServiceImpl.class);
    @Autowired
    DemeritMapper demeritMapper;

    /**
     * 批量删除专业
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKeys(String[] ids) throws Exception {
        return demeritMapper.deleteByPrimaryKeys(ids);
    }

    /**
     * 新增专业
     * @param demerit
     * @return
     */
    @Override
    public int insertSelective(Demerit demerit) {
        return demeritMapper.insertSelective(demerit);
    }

    /**
     * 根据主键查询专业
     * @param id
     * @return
     */
    @Override
    public Demerit selectByPrimaryKey(String id) {
        return demeritMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新专业
     * @param demerit
     * @return
     * @throws Exception
     */
    @Override
    public int updateByPrimaryKeySelective(Demerit demerit) throws Exception {
        return demeritMapper.updateByPrimaryKeySelective(demerit);
    }

    /**
     * 查询专业列表
     * @param demerit
     * @return
     */
    @Override
    public List<Demerit> selectDemeritList(Demerit demerit) {
        return demeritMapper.selectDemeritList(demerit);
    }




    /**
     * 校验专业代码唯一
     * @param demerit 专业信息
     * @return
     */
    @Override
    public String checkDemeritCodeUnique(Demerit demerit) {
        if (demerit.getId() == null)
        {
            demerit.setId(-1);
        }
        Integer dId = demerit.getId();
        Demerit info = demeritMapper.checkDemeritCodeUnique(demerit.getdCode());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

}
