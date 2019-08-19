package com.sj.oa.project.controller.dormitory;

import com.sj.oa.common.utils.DateUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.DormitoryBuilding;
import com.sj.oa.project.po.DormitorySteps;
import com.sj.oa.project.po.User;
import com.sj.oa.project.service.dormitory.IDormitoryBuildingService;
import com.sj.oa.project.service.dormitory.IDormitoryStepsService;
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
 * 宿舍楼层管理controller
 */
@Controller
@RequestMapping("/dms")
public class DormitoryStepsController extends BaseController{
    //前缀
    private final static String prefix = "system/dormitory/dms";
    @Autowired
    IDormitoryStepsService iDormitoryStepsService;
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
    @RequiresPermissions("dms:list")
    public String toList(Model model) {
        List<DormitoryBuilding> dormitoryBuildings
                = iDormitoryBuildingService.selectByDormitoryBuilding(new DormitoryBuilding());
        model.addAttribute("dormitoryBuildings",dormitoryBuildings);
        return prefix + "/dmsList";
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
    public TableDataInfo tableList(DormitorySteps record) {
        startPage();
        List<DormitorySteps> records = iDormitoryStepsService.selectByDormitorySteps(record);
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
        List<DormitoryBuilding> dormitoryBuildings
                = iDormitoryBuildingService.selectByDormitoryBuilding(new DormitoryBuilding());
        model.addAttribute("dormitoryBuildings",dormitoryBuildings);
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
    @RequiresPermissions("dms:add")
    @Operlog(modal = "宿舍楼层管理",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(DormitorySteps record) throws Exception {
        Date date = new Date();
        record.setCreateTime(date);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        record.setAlreadyNumbers(0);
        //查询宿舍楼名称
        DormitoryBuilding dormitoryBuilding
                = iDormitoryBuildingService.selectByBuildingCode(record.getBuildingCode());
        record.setBuildingName(dormitoryBuilding.getBuildingName());
        //设置stepCode
        record.setStepCode("s" + createUID());
        return result(iDormitoryStepsService.insertSelective(record));
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
    @RequiresPermissions("dms:del")
    @Operlog(modal = "宿舍楼层管理",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iDormitoryStepsService.deleteByPrimaryKeys(ids));
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
    @RequiresPermissions("dms:update")
    @Operlog(modal = "宿舍楼层管理",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        DormitorySteps record = iDormitoryStepsService.selectByPrimaryKey(id);
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
    @RequiresPermissions("dms:update")
    @Operlog(modal = "宿舍楼层管理",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(DormitorySteps record) {
        return result(iDormitoryStepsService.updateByPrimaryKeySelective(record));
    }

    /**
     * 校验宿舍楼code
     * @param record
     * @return
     */
    @PostMapping("/checkStepUnique")
    @ResponseBody
    public String checkStepUnique(DormitorySteps record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryStepsService.checkStepUnique(record);
        }
        return uniqueFlag;
    }
}
