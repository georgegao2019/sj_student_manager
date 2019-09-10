package com.sj.oa.project.controller.college;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.service.college.IYearSessionInfoService;
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
 * 应届管理controller
 */
@Controller
@RequestMapping("/yearSession")
public class YearSessionInfoController extends BaseController{
    //前缀
    private final static String prefix = "system/college";
    @Autowired
    IYearSessionInfoService iYearSessionInfoService;
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
    @RequiresPermissions("yearSession:list")
    public String toList(Model model) {
        return prefix + "/yearSessionInfo";
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
    public TableDataInfo tableList(YearSessionInfo record) {
        startPage();
        List<YearSessionInfo> records = iYearSessionInfoService.selectByYearSessionInfo(record);
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
        return prefix + "/yearSessionAdd";
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
    @RequiresPermissions("yearSession:add")
    @Operlog(modal = "应届管理",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(YearSessionInfo record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的应届管理记录默认是 有效 状态
        record.setStatus(0);
        return result(iYearSessionInfoService.insertSelective(record));
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
    @RequiresPermissions("yearSession:del")
    @Operlog(modal = "应届管理",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iYearSessionInfoService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/yearSession/{id}")
    @RequiresPermissions("yearSession:update")
    @Operlog(modal = "应届管理",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        YearSessionInfo record = iYearSessionInfoService.selectByPrimaryKey(id);
        model.addAttribute("note", record);
        return prefix + "/yearSessionEdit";
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
    @RequiresPermissions("yearSession:update")
    @Operlog(modal = "应届管理",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(YearSessionInfo record) {
        return result(iYearSessionInfoService.updateByPrimaryKeySelective(record));
    }

    /**
     *
     * @描述 ajax请求所有年级列表
     *
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<YearSessionInfo> list(YearSessionInfo dept)
    {
        List<YearSessionInfo> depts = iYearSessionInfoService.selectByYearSessionInfo(dept);
        return depts;
    }
}
