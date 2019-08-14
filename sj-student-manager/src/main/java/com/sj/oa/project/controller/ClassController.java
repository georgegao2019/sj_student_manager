package com.sj.oa.project.controller;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.Classall;
import com.sj.oa.project.po.Major;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.YearSessionInfo;
import com.sj.oa.project.service.classall.IClassService;
import com.sj.oa.project.service.college.IYearSessionInfoService;
import com.sj.oa.project.service.major.IMajorService;
import org.activiti.engine.impl.util.CollectionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by dell on 2019-07-31.
 */
@Controller
@RequestMapping("/class")
public class ClassController extends BaseController {
    private String prefix = "system/college/";

    @Autowired
    IClassService iClassService;

    @Autowired
    IYearSessionInfoService iYearSessionInfoService;

    @Autowired
    IMajorService iMajorService;


    /**
     *
     * @描述 页面跳转到班级
     *
     * @date 2018/9/16 10:59
     */

    @RequestMapping("/tolist")
    @RequiresPermissions("class:list")
    public String tolist(Model model)
    {
        //携带所有应届年份 和 专业信息
        List<YearSessionInfo> yearSessionInfos
                = iYearSessionInfoService.selectByYearSessionInfo(new YearSessionInfo());
        List<Major> majors
                = iMajorService.selectMajorList(new Major());
        model.addAttribute("yearSessions",yearSessionInfos);
        model.addAttribute("majors",majors);
        return prefix + "classInfo";
    }


    /**
     *
     * @描述 ajax请求的所有班级
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<Classall> list(Classall classall)
    {
        List<Classall> classalls = iClassService.selectClassList(classall);
        return classalls;
    }

    /**
     *
     * @描述 班级列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(Classall classall)
    {
        //开启分页
        startPage();
        List<Classall> classalls = iClassService.selectClassList(classall);
        return getDataTable(classalls);
    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("class:del")
    @ResponseBody
    @Operlog(modal = "班级管理",descr = "删除班级")
    public AjaxResult del(Integer[] ids)
    {
        try
        {
            iClassService.deleteByPrimaryKeys(ids);
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
        //携带所有应届年份 和 专业信息
        List<YearSessionInfo> yearSessionInfos
                = iYearSessionInfoService.selectByYearSessionInfo(new YearSessionInfo());
        List<Major> majors
                = iMajorService.selectMajorList(new Major());
        model.addAttribute("yearSessions",yearSessionInfos);
        model.addAttribute("majors",majors);
        return prefix + "/classInfoAdd";
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */

    @RequestMapping("/addSave")
    @Operlog(modal = "班级管理",descr = "添加班级")
    @RequiresPermissions("class:add")
    @ResponseBody
    public AjaxResult addClassall(Classall classall)
    {
        classall.setCreateTime(new Date());
        User user = getUser();
        classall.setCreateUser(user.getName());
        //查询专业名称
        Major major = new Major();
        major.setMajorCode(classall.getMajorCode());
        List<Major> majors = iMajorService.selectMajorList(major);
        if(CollectionUtils.isNotEmpty(majors)){
            classall.setMajor(majors.get(0).getMajorName());
        }
        return  result(iClassService.insertSelective(classall));
    }


    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("class:update")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        Classall classall = iClassService.selectByPrimaryKey(id);


        model.addAttribute(" Classall", classall);
        return prefix + "classInfoEdit";

    }



    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("class:update")
    @Operlog(modal = "班级管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(Classall classall)
    {
        int i = 0;
        try
        {
            i = iClassService.updateByPrimaryKeySelective(classall);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return result(i);
    }

    /**
     * 校验班级名称
     * @param record
     * @return
     */
    @PostMapping("/checkClassNameUnique")
    @ResponseBody
    public String checkClassNameUnique(Classall record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iClassService.checkClassNameUnique(record);
        }
        return uniqueFlag;
    }

}
