package com.sj.oa.project.controller.dormitory;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.dormitory.DormitoryBuilding;
import com.sj.oa.project.po.dormitory.DormitoryRoom;
import com.sj.oa.project.po.dormitory.DormitorySteps;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.dto.DormitoryBuildingTree;
import com.sj.oa.project.po.dto.DormitoryStepsTree;
import com.sj.oa.project.service.dormitory.IDormitoryBuildingService;
import com.sj.oa.project.service.dormitory.IDormitoryCouchService;
import com.sj.oa.project.service.dormitory.IDormitoryRoomService;
import com.sj.oa.project.service.dormitory.IDormitoryStepsService;
import com.sj.oa.project.service.user.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gaojun
 * @date 2019/8/19
 * 宿舍房间管理 controller
 */
@Controller
@RequestMapping("/dmr")
public class DormitoryRoomController extends BaseController{
    //前缀
    private final static String prefix = "system/dormitory/dmr";
    @Autowired
    IDormitoryStepsService iDormitoryStepsService;
    @Autowired
    IDormitoryBuildingService iDormitoryBuildingService;
    @Autowired
    IDormitoryRoomService iDormitoryRoomService;
    @Autowired
    IUserService iUserService;
    /**
     *
     * @描述: 跳转到列表页
     *
     * @params:
     * @return:
     * @date: 2019/9/18 11:00
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("dmr:list")
    public String toList(Model model) {
        List<DormitoryBuilding> dormitoryBuildings
                = iDormitoryBuildingService.selectByDormitoryBuilding(new DormitoryBuilding());
        model.addAttribute("dormitoryBuildings",dormitoryBuildings);
        return prefix + "/dmrList";
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
    public TableDataInfo tableList(DormitoryRoom record) {
        startPage();
        List<DormitoryRoom> records = iDormitoryRoomService.selectByDormitoryRoom(record);
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
    @RequestMapping("/toAdd/{stepCode}")
    public String toAdd(@PathVariable("stepCode") String stepCode,Model model) {
        //查询楼层信息
        DormitorySteps dormitorySteps
                = iDormitoryStepsService.selectByStepCode(stepCode);
        //携带楼层信息返回
        model.addAttribute("stepInfo",dormitorySteps);
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
    @RequiresPermissions("dmr:add")
    @Operlog(modal = "宿舍房间管理",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(DormitoryRoom record) throws Exception {
        Date date = new Date();
        record.setCreateTime(date);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //默认已入住人数为0
        record.setIncomeNumber(0);
        //设置roomCode
        record.setRoomCode(record.getStepCode() + "-r" + record.getRoomNumber());
        return result(iDormitoryRoomService.insertSelective(record));
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
    @RequiresPermissions("dmr:del")
    @Operlog(modal = "宿舍房间管理",descr = "删除记录")
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
    @RequiresPermissions("dmr:update")
    @Operlog(modal = "宿舍房间管理",descr = "查询记录")
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
    @RequiresPermissions("dmr:update")
    @Operlog(modal = "宿舍房间管理",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(DormitorySteps record) {
        return result(iDormitoryStepsService.updateByPrimaryKeySelective(record));
    }

    /**
     * 校验房间编号唯一性
     * @param record
     * @return
     */
    @PostMapping("/checkRoomNumberUnique")
    @ResponseBody
    public String checkRoomNumberUnique(DormitoryRoom record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryRoomService.checkRoomNumberUnique(record);
        }
        return uniqueFlag;
    }

    /**
     *
     * @描述 ajax宿舍楼+宿舍楼层树状结构
     *
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<DormitoryBuildingTree> list()
    {
        List<DormitoryBuildingTree> resultTree = new ArrayList<>();

        List<DormitoryBuilding> buildings
                = iDormitoryBuildingService.selectByDormitoryBuilding(new DormitoryBuilding());
        if(CollectionUtils.isNotEmpty(buildings)){
            for(DormitoryBuilding building : buildings){
                DormitoryBuildingTree dormitoryBuildingTree = new DormitoryBuildingTree();
                dormitoryBuildingTree.setId(building.getBuildingCode());
                //查询宿舍楼下的全部楼层
                List<DormitoryStepsTree> steps
                        = iDormitoryStepsService.selectByBuildingCode(building.getBuildingCode());
                dormitoryBuildingTree.setChildren(steps);
                dormitoryBuildingTree.setName(building.getBuildingName());
                resultTree.add(dormitoryBuildingTree);
            }
        }
        return resultTree;
    }
}
