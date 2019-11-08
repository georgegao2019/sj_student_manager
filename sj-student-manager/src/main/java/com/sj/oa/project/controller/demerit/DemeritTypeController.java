package com.sj.oa.project.controller.demerit;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;

import com.sj.oa.project.po.demerit.DemeritType;

import com.sj.oa.project.service.demerit.IDemeritTypeService;
import com.sj.oa.project.service.user.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
@Controller
@RequestMapping("/demeritType")
public class DemeritTypeController extends BaseController {
    private String prefix = "system/demerit/";

    @Autowired
    IDemeritTypeService IDemeritTypeService;

    @Autowired
    private IUserService iUserService;

    /**
     *
     * @描述 页面跳转到专业
     *
     * @date 2018/9/16 10:59
     */

    @RequestMapping("/tolist")
    @RequiresPermissions("demeritType:list")
    public String tolist()
    {
        return prefix + "demeritTypeInfo";
    }

    /**
     *
     * @描述 ajax请求的所有专业
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<DemeritType> list(DemeritType demeritType)
    {
        List<DemeritType> demeritTypes = IDemeritTypeService.selectDemeritTypeList(demeritType);
        return demeritTypes;
    }

    /**
     *
     * @描述 专业列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(DemeritType demeritType)
    {
        //开启分页
        startPage();
        List<DemeritType> demeritTypes = IDemeritTypeService.selectDemeritTypeList(demeritType);
        return getDataTable(demeritTypes);
    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("demeritType:del")
    @ResponseBody
    @Operlog(modal = "专业管理",descr = "删除专业")
    public AjaxResult del(String[] ids)
    {
        try
        {
            IDemeritTypeService.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return success();
    }

    /**
     *
     * @描述: 添加页面
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:15
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        return prefix + "demeritTypeInfoAdd";
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */
    @RequestMapping("/addSave")
    @Operlog(modal = "专业管理",descr = "添加专业")
    @RequiresPermissions("demeritType:add")
    @ResponseBody
    public AjaxResult addDemeritType(DemeritType demeritType)
    {
        demeritType.setStatus(0);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        demeritType.setCreateUser(loginUser.getName());
        demeritType.setCreateTime(new Date());
        return  result(IDemeritTypeService.insertSelective(demeritType));
    }

    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("demeritType:update")
    public String edit(@PathVariable("id") String id, Model model)
    {
        DemeritType demeritType = IDemeritTypeService.selectByPrimaryKey(id);
        model.addAttribute("demeritType", demeritType);
        return prefix + "demeritTypeInfoEdit";

    }

    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("demeritType:update")
    @Operlog(modal = "专业管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(DemeritType demeritType)
    {
        int i = 0;
        try
        {
            i = IDemeritTypeService.updateByPrimaryKeySelective(demeritType);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return result(i);
    }

    /**
     * 校验专业编号
     */
    @PostMapping("/checkDemeritTypeUnique")
    @ResponseBody
    public String checkDemeritTypeUnique(DemeritType demeritType)
    {
        String uniqueFlag = "0";
        if (demeritType != null) {
            uniqueFlag = IDemeritTypeService.checkDemeritTypeUnique(demeritType);
        }
        return uniqueFlag;
    }

}
