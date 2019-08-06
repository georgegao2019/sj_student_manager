package com.sj.oa.project.controller;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.CheckMorningExercises;
import com.sj.oa.project.po.User;
import com.sj.oa.project.service.check.ICheckMorningExercisesService;
import com.sj.oa.project.service.check.ICheckMorningExercisesService;
import com.sj.oa.project.service.user.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author gaojun
 * @date 2019/8/1
 * 早操检查controller
 */
@Controller
@RequestMapping("/cMorningExercises")
public class CheckMorningExercisesController extends BaseController{
    //前缀
    private final static String prefix = "system/cMorningExercises";
    @Autowired
    ICheckMorningExercisesService iCheckMorningExercisesService;
    @Autowired
    IUserService iUserService;
    /**
     *
     * @描述: 跳转到列表页
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:13
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("cMorningExercises:list")
    public String toList(Model model) {
        return prefix + "/cMorningExercises";
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
    public TableDataInfo tableList(CheckMorningExercises record) {
        startPage();
        List<CheckMorningExercises> records = iCheckMorningExercisesService.selectByCheckMorningExercises(record);
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
        return prefix + "/add";
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
    @RequiresPermissions("cMorningExercises:add")
    @Operlog(modal = "早操检查",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(CheckMorningExercises record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的早操检查记录默认是 有效 状态
        record.setStatus(0);
        return result(iCheckMorningExercisesService.insertSelective(record));
    }
    /**
     *
     * @描述: 删除
     *
     * @params:
     * @return:
     * @date: 2019/8/1 22:02
     */
    @RequestMapping("/del")
    @RequiresPermissions("cMorningExercises:del")
    @Operlog(modal = "早操检查",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iCheckMorningExercisesService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/cMorningExercises/{id}")
    @RequiresPermissions("cMorningExercises:update")
    @Operlog(modal = "早操检查",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        CheckMorningExercises record = iCheckMorningExercisesService.selectByPrimaryKey(id);
        model.addAttribute("note", record);
        return prefix + "/edit";
    }
    /**
     *
     * @描述: 修改保存
     *
     * @params:
     * @return:
     * @date: 2019/8/1 21:01
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("cMorningExercises:update")
    @Operlog(modal = "早操检查",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(CheckMorningExercises record) {
        return result(iCheckMorningExercisesService.updateByPrimaryKeySelective(record));
    }
}
