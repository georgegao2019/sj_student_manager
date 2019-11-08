package com.sj.oa.project.service.demerit;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.project.mapper.demerit.DemeritTypeMapper;
import com.sj.oa.project.po.demerit.DemeritType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemeritTypeServiceImpl implements IDemeritTypeService {

    private Logger log = LoggerFactory.getLogger(DemeritTypeServiceImpl.class);
    @Autowired
    DemeritTypeMapper demeritTypeMapper;

    /**
     * 批量删除专业
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKeys(String[] ids) throws Exception {
        return demeritTypeMapper.deleteByPrimaryKeys(ids);
    }

    /**
     * 新增专业
     * @param demerittype
     * @return
     */
    @Override
    public int insertSelective(DemeritType demerittype) {
        return demeritTypeMapper.insertSelective(demerittype);
    }

    /**
     * 根据主键查询专业
     * @param id
     * @return
     */
    @Override
    public DemeritType selectByPrimaryKey(String id) {
        return demeritTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新专业
     * @param demerittype
     * @return
     * @throws Exception
     */
    @Override
    public int updateByPrimaryKeySelective(DemeritType demerittype) throws Exception {
        return demeritTypeMapper.updateByPrimaryKeySelective(demerittype);
    }

    /**
     * 查询专业列表
     * @param demerittype
     * @return
     */
    @Override
    public List<DemeritType> selectDemeritTypeList(DemeritType demerittype) {
        return demeritTypeMapper.selectDemeritTypeList(demerittype);
    }




    /**
     * 校验专业代码唯一
     * @param demerittype 专业信息
     * @return
     */
    @Override
    public String checkDemeritTypeUnique(DemeritType demerittype) {
        if (demerittype.getId() == null)
        {
            demerittype.setId(-1);
        }
        Integer dId = demerittype.getId();
        DemeritType info = demeritTypeMapper.checkDemeritTypeUnique(demerittype.getdType());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getId())
                && !info.getId().equals(dId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }


}
