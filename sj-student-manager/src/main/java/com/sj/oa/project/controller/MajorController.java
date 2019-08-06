package com.sj.oa.project.controller;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.Major;
import com.sj.oa.project.service.major.IMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
@Controller
@RequestMapping("/major")
public class MajorController extends BaseController {
    private String prefix = "system/major/";

    @Autowired
    IMajorService majorService;

    /**
     *
     * @描述 页面跳转到专业
     *
     * @date 2018/9/16 10:59
     */

    @RequestMapping("/tolist")
    @RequiresPermissions("major:list")
    public String tolist()
    {
        return prefix + "major";
    }

    /**
     *
     * @描述 ajax请求的所有专业
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<Major> list(Major major)
    {
        List<Major> majors = majorService.selectMajorList(major);
        return majors;
    }

    /**
     *
     * @描述 专业列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(Major major)
    {
        //开启分页
        startPage();
        List<Major> majors = majorService.selectMajorList(major);
        return getDataTable(majors);
    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("major:del")
    @ResponseBody
    @Operlog(modal = "专业管理",descr = "删除专业")
    public AjaxResult del(String[] ids)
    {
        try
        {
            majorService.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return success();
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */
    @RequestMapping("/addSave")
    @Operlog(modal = "专业管理",descr = "添加专业")
    @RequiresPermissions("major:add")
    @ResponseBody
    public AjaxResult addMajor(Major major)
    {
        return  result(majorService.insertSelective(major));
    }

    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("major:update")
    public String edit(@PathVariable("id") String id, Model model)
    {
        Major major = majorService.selectByPrimaryKey(id);
        model.addAttribute("Major", major);
        return prefix + "edit";

    }

    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("major:update")
    @Operlog(modal = "专业管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(Major major)
    {
        int i = 0;
        try
        {
            i = majorService.updateByPrimaryKeySelective(major);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return result(i);
    }

}
