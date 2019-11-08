package com.sj.oa.project.controller.check;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckDarken;
import com.sj.oa.project.po.dormitory.DormitoryRoom;
import com.sj.oa.project.po.dormitory.DormitorySteps;
import com.sj.oa.project.po.dormitory.DormitoryBuilding;
import com.sj.oa.project.service.check.ICheckDarkenService;
import com.sj.oa.project.service.dormitory.IDormitoryBuildingService;
import com.sj.oa.project.service.dormitory.IDormitoryCouchService;
import com.sj.oa.project.service.dormitory.IDormitoryRoomService;
import com.sj.oa.project.service.dormitory.IDormitoryStepsService;
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


@Controller
@RequestMapping("/cDarken")
public class CheckDarkenController extends BaseController {
    //前缀
    private final static String prefix = "system/cDarken";
    @Autowired
    ICheckDarkenService iCheckDarkenService;
    @Autowired
    IDormitoryBuildingService iDormitoryBuildingService;
    @Autowired
    IDormitoryCouchService iDormitoryCouchService;
    @Autowired
    IDormitoryRoomService iDormitoryRoomService;
    @Autowired
    IDormitoryStepsService iDormitoryStepsService;
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
    @RequiresPermissions("cDarken:list")
    public String toList(Model model) {
        return prefix + "/cDarken";
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
    public TableDataInfo tableList(CheckDarken record) {
        startPage();
        List<CheckDarken> records = iCheckDarkenService.selectByCheckDarken(record);
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
    @RequiresPermissions("cDarken:add")
    @Operlog(modal = "晚熄灯检查",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(CheckDarken record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的晚熄灯检查记录默认是 有效 状态
        record.setStatus(0);
        return result(iCheckDarkenService.insertSelective(record));
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
    @RequiresPermissions("cDarken:del")
    @Operlog(modal = "晚熄灯检查",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iCheckDarkenService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/cDarken/{id}")
    @RequiresPermissions("cDarken:update")
    @Operlog(modal = "晚熄灯检查",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        CheckDarken record = iCheckDarkenService.selectByPrimaryKey(id);
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
    @RequiresPermissions("cDarken:update")
    @Operlog(modal = "晚熄灯检查",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(CheckDarken record) {
        return result(iCheckDarkenService.updateByPrimaryKeySelective(record));
    }

    @RequestMapping("/findStep")
    @ResponseBody
    public List<DormitorySteps> addStep(Model model,String buildingCode){
        List<DormitorySteps>  DormitoryStep = iDormitoryStepsService.findStep(buildingCode);
        return DormitoryStep;

    }

    @RequestMapping("/findRoom")
    @ResponseBody
    public List<DormitoryRoom> addRoom(Model model, String stepCode){
        List<DormitoryRoom>  DormitoryRoom = iDormitoryRoomService.findRoom(stepCode);
        return DormitoryRoom;

    }


}
