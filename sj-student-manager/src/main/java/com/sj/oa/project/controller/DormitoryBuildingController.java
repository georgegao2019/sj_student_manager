package com.sj.oa.project.controller;

import com.sj.oa.common.utils.DateUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.DormitoryBuilding;
import com.sj.oa.project.po.User;
import com.sj.oa.project.service.dormitory.IDormitoryBuildingService;
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
 * @author gaojun
 * @date 2019/8/1
 * 宿舍楼管理controller
 */
@Controller
@RequestMapping("/dmb")
public class DormitoryBuildingController extends BaseController{
    //前缀
    private final static String prefix = "system/dormitory/dmb";
    @Autowired
    IDormitoryBuildingService iDormitoryBuildingService;
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
    @RequiresPermissions("dmb:list")
    public String toList(Model model) {
        return prefix + "/dmbList";
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
    public TableDataInfo tableList(DormitoryBuilding record) {
        startPage();
        if(record.getBuildingName() != null && record.getBuildingName().equals("")){
            record.setBuildingName(null);
        }
        List<DormitoryBuilding> records = iDormitoryBuildingService.selectByDormitoryBuilding(record);
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
    @RequiresPermissions("dmb:add")
    @Operlog(modal = "宿舍楼管理",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(DormitoryBuilding record) throws Exception {
        //设置更新时间
        Date date = new Date();
        record.setCreateTime(date);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的宿舍楼管理记录默认是 有效 状态
        record.setStatus(0);
        //设置buildingCode
        record.setBuildingCode("b"+ createUID());
        return result(iDormitoryBuildingService.insertSelective(record));
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
    @RequiresPermissions("dmb:del")
    @Operlog(modal = "宿舍楼管理",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iDormitoryBuildingService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("dmb:update")
    @Operlog(modal = "宿舍楼管理",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        DormitoryBuilding record = iDormitoryBuildingService.selectByPrimaryKey(id);
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
    @RequiresPermissions("dmb:update")
    @Operlog(modal = "宿舍楼管理",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(DormitoryBuilding record) {
        return result(iDormitoryBuildingService.updateByPrimaryKeySelective(record));
    }

    /**
     * 校验宿舍楼code
     * @param record
     * @return
     */
    @PostMapping("/checkDmCodeUnique")
    @ResponseBody
    public String checkDmCodeUnique(DormitoryBuilding record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryBuildingService.checkDmCodeUnique(record);
        }
        return uniqueFlag;
    }

    /**
     * 校验宿舍楼名称
     * @param record
     * @return
     */
    @PostMapping("/checkDmNameUnique")
    @ResponseBody
    public String checkDmNameUnique(DormitoryBuilding record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryBuildingService.checkDmNameUnique(record);
        }
        return uniqueFlag;
    }
}
