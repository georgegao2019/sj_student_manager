package com.sj.oa.project.controller.check;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;

import com.sj.oa.project.po.check.CheckMorningExercisesClassWeek;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;

import com.sj.oa.project.service.check.ICheckEveningStudyService;
import com.sj.oa.project.service.check.ICheckMorningExercisesClassWeekService;
import com.sj.oa.project.service.check.ICheckMorningExercisesClassService;
import com.sj.oa.project.service.college.IClassService;

import com.sj.oa.project.service.user.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/cMorningExercisesClassWeek")
public class CheckMorningExercisesClassWeekController extends BaseController {

    //前缀
    private final static String prefix = "system/cMorningExercises";
    @Autowired
    ICheckMorningExercisesClassWeekService ICheckMorningExercisesClassWeekService;
    @Autowired
    IUserService iUserService;

    @Autowired
    private ICheckEveningStudyService iCheckEveningStudyService;
    @Autowired
    IClassService IClassService;
    @Autowired
    ICheckMorningExercisesClassService ICheckMorningExercisesClassService;

    /**
     *
     * @描述: 跳转到列表页
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:13
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("cMorningExercisesClassWeek:list")
    public String toList(Model model) {
        return prefix + "/cMorningExercisesClassWeek";
    }
    /**
     *
     * @描述: 返回表格数据
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:15
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo tableList(CheckMorningExercisesClassWeek record) {

        List<CheckMorningExercisesClassWeek> records = ICheckMorningExercisesClassWeekService.selectByCheckMorningExercisesClassWeek();
        return getDataTable(records);
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

        List<YearSessionInfo> yearSessionInfos = iCheckEveningStudyService.selectYearSessionInfoByLimit(1);
        List<Classall> classAlls = iCheckEveningStudyService.selectClassInfoByGrade(yearSessionInfos);
        model.addAttribute("classes",classAlls);
        return prefix + "/addClassWeek";
    }
    /**
     *
     * @描述: 添加保存
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:16
     */
    @RequestMapping("/addSave")
    @RequiresPermissions("cMorningExercisesClass:add")
    @Operlog(modal = "早操检查",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(CheckMorningExercisesClassWeek record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的早操检查记录默认是 有效 状态
        record.setStatus(0);
        return result(ICheckMorningExercisesClassWeekService.insertSelective(record));
    }






    @RequestMapping("/getWeek1Mark")
    @ResponseBody
    public String getWeek1Mark(String className){
        String  mark = ICheckMorningExercisesClassWeekService.getWeek1Mark(className);
        return mark;

    }

    @RequestMapping("/getWeek2Mark")
    @ResponseBody
    public String getWeek2Mark(String className){
        String  mark = ICheckMorningExercisesClassWeekService.getWeek2Mark(className);
        return mark;

    }

    @RequestMapping("/getWeek3Mark")
    @ResponseBody
    public String getWeek3Mark(String className){
        String  mark = ICheckMorningExercisesClassWeekService.getWeek3Mark(className);
        return mark;

    }

    @RequestMapping("/getWeek4Mark")
    @ResponseBody
    public String getWeek4Mark(String className){
        String  mark = ICheckMorningExercisesClassWeekService.getWeek4Mark(className);
        return mark;

    }

    @RequestMapping("/getWeek5Mark")
    @ResponseBody
    public String getWeek5Mark(String className){
        String  mark = ICheckMorningExercisesClassWeekService.getWeek5Mark(className);
        return mark;

    }





}
