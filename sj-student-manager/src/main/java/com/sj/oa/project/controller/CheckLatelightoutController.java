package com.sj.oa.project.controller;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.CheckLatelightout;
import com.sj.oa.project.po.User;
import com.sj.oa.project.service.check.ICheckLatelightoutService;
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
 * 晚熄灯检查controller
 */
@Controller
@RequestMapping("/cLatelightout")
public class CheckLatelightoutController extends BaseController{
    //前缀
    private final static String prefix = "system/cLatelightout";
    @Autowired
    ICheckLatelightoutService iCheckLatelightoutService;
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
    @RequiresPermissions("cLatelightout:list")
    public String toList(Model model) {
        return prefix + "/cLatelightout";
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
    public TableDataInfo tableList(CheckLatelightout record) {
        startPage();
        List<CheckLatelightout> records = iCheckLatelightoutService.selectByCheckLatelightout(record);
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
    @RequiresPermissions("cLatelightout:add")
    @Operlog(modal = "晚熄灯检查",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(CheckLatelightout record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的晚熄灯检查记录默认是 有效 状态
        record.setStatus(0);
        return result(iCheckLatelightoutService.insertSelective(record));
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
    @RequiresPermissions("cLatelightout:del")
    @Operlog(modal = "晚熄灯检查",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iCheckLatelightoutService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/cLatelightout/{id}")
    @RequiresPermissions("cLatelightout:update")
    @Operlog(modal = "晚熄灯检查",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        CheckLatelightout record = iCheckLatelightoutService.selectByPrimaryKey(id);
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
    @RequiresPermissions("cLatelightout:update")
    @Operlog(modal = "晚熄灯检查",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(CheckLatelightout record) {
        return result(iCheckLatelightoutService.updateByPrimaryKeySelective(record));
    }
}
