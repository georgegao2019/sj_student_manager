package com.sj.oa.project.controller.demerit;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.demerit.Demerit;
import com.sj.oa.project.po.demerit.DemeritType;
import com.sj.oa.project.service.demerit.IDemeritService;
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
@RequestMapping("/demerit")
public class DemeritController extends BaseController {
    private String prefix = "system/demerit/";

    @Autowired
    IDemeritService IDemeritService;

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
    @RequiresPermissions("demerit:list")
    public String tolist(Model model)
    {




        return prefix + "demeritInfo";
    }

    /**
     *
     * @描述 ajax请求的所有专业
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<Demerit> list(Demerit demerit)
    {
        List<Demerit> demerits = IDemeritService.selectDemeritList(demerit);
        return demerits;
    }

    /**
     *
     * @描述 专业列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(Demerit demerit)
    {
        //开启分页
        startPage();
        List<Demerit> demerits = IDemeritService.selectDemeritList(demerit);
        return getDataTable(demerits);
    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("demerit:del")
    @ResponseBody
    @Operlog(modal = "专业管理",descr = "删除专业")
    public AjaxResult del(String[] ids)
    {
        try
        {
            IDemeritService.deleteByPrimaryKeys(ids);
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
        //携带所有扣分类型信息
        List<DemeritType> DemeritTypeInfos
                = IDemeritTypeService.selectDemeritTypeList(new DemeritType());

        model.addAttribute("DemeritTypes",DemeritTypeInfos);
        return prefix + "demeritInfoAdd";
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */
    @RequestMapping("/addSave")
    @Operlog(modal = "专业管理",descr = "添加专业")
    @RequiresPermissions("demerit:add")
    @ResponseBody
    public AjaxResult addDemerit(Demerit demerit)
    {
        demerit.setStatus(0);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        demerit.setCreateUser(loginUser.getName());
        demerit.setCreateTime(new Date());
        return  result(IDemeritService.insertSelective(demerit));
    }

    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("demerit:update")
    public String edit(@PathVariable("id") String id, Model model)
    {
        Demerit demerit = IDemeritService.selectByPrimaryKey(id);
        model.addAttribute("demerit", demerit);
        //携带所有扣分类型信息
        List<DemeritType> DemeritTypeInfos
                = IDemeritTypeService.selectDemeritTypeList(new DemeritType());

        model.addAttribute("DemeritTypes",DemeritTypeInfos);
        return prefix + "demeritInfoEdit";

    }

    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("demerit:update")
    @Operlog(modal = "专业管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(Demerit demerit)
    {
        int i = 0;
        try
        {
            i = IDemeritService.updateByPrimaryKeySelective(demerit);
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
    @PostMapping("/checkDemeritCodeUnique")
    @ResponseBody
    public String checkDemeritCodeUnique(Demerit demerit)
    {
        String uniqueFlag = "0";
        if (demerit != null) {
            uniqueFlag = IDemeritService.checkDemeritCodeUnique(demerit);
        }
        return uniqueFlag;
    }

}
