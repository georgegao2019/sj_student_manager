package com.sj.oa.project.controller.dormitory;

import com.sj.oa.common.utils.DateUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.dormitory.DormitoryCouch;
import com.sj.oa.project.po.dormitory.DormitoryRoom;
import com.sj.oa.project.po.dto.DormitoryModel;
import com.sj.oa.project.service.dormitory.IDormitoryCouchService;
import com.sj.oa.project.service.dormitory.IDormitoryRoomService;
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

import java.util.Date;
import java.util.List;

/**
 * @author gaojun
 * @date 2019/8/1
 * 宿舍管理controller
 */
@Controller
@RequestMapping("/dmc")
public class DormitoryCouchController extends BaseController{
    //前缀
    private final static String prefix = "system/dormitory/dmc/";

    @Autowired
    IDormitoryCouchService iDormitoryCouchService;

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
     * @date: 2019/8/20 21:13
     */
    @RequestMapping("/tolist/{roomCode}")
    @RequiresPermissions("dmc:list")
    public String toList(@PathVariable("roomCode") String roomCode,Model model) {
        DormitoryModel modelParam = new DormitoryModel();
        //查询房间名称
        DormitoryRoom param = new DormitoryRoom();
        param.setRoomCode(roomCode);
        List<DormitoryRoom> dormitoryRooms = iDormitoryRoomService.selectByDormitoryRoom(param);
        if(CollectionUtils.isNotEmpty(dormitoryRooms)){
            modelParam.setRoomCode(roomCode);
            modelParam.setRoomName(dormitoryRooms.get(0).getRoomName());
            model.addAttribute("roomInfo",modelParam);
        }
        return prefix + "/dmcList";
    }
    /**
     *
     * @描述: 返回表格数据
     *
     * @params:
     * @return:
     * @date: 2019/8/20 21:15
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo tableList(DormitoryCouch record) {
        startPage();
        List<DormitoryCouch> records
                = iDormitoryCouchService.selectByDormitoryCouch(record);
        return getDataTable(records);
    }



    /**
     *
     * @描述: 添加页面
     *
     * @params:
     * @return:
     * @date: 2019/8/20 21:15
     */
    @RequestMapping("/toAdd/{roomCode}")
    public String toAdd(@PathVariable("roomCode") String roomCode,Model model) {
        DormitoryModel modelParam = new DormitoryModel();
        modelParam.setRoomCode(roomCode);
        model.addAttribute("roomInfo",modelParam);
        return prefix + "/add";
    }
    /**
     *
     * @描述: 添加保存
     *
     * @params:
     * @return:
     * @date: 2019/8/20 21:16
     */
    @RequestMapping("/addSave")
    @RequiresPermissions("dmc:add")
    @Operlog(modal = "宿舍管理",descr = "添加记录")
    @ResponseBody
    public AjaxResult addSave(DormitoryCouch record) throws Exception {
        //设置更新时间
        Date date = new Date();
        record.setCreateTime(date);
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //生成couchCode
        record.setCouchCode(record.getRoomCode() + "-c" + record.getCouchNumber());
        //设置入住时间
        record.setMoveInDate(date);
        return result(iDormitoryCouchService.insertSelective(record));
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
    @RequiresPermissions("dmc:del")
    @Operlog(modal = "宿舍管理",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(iDormitoryCouchService.deleteByPrimaryKeys(ids));
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
    @RequiresPermissions("dmc:update")
    @Operlog(modal = "宿舍管理",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        DormitoryCouch record = iDormitoryCouchService.selectByPrimaryKey(id);
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
    @RequiresPermissions("dmc:update")
    @Operlog(modal = "宿舍管理",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(DormitoryCouch record) {
        return result(iDormitoryCouchService.updateByPrimaryKeySelective(record));
    }

    /**
     * 校验宿舍楼code
     * @param record
     * @return
     */
    @PostMapping("/checkDmCodeUnique")
    @ResponseBody
    public String checkDmCodeUnique(DormitoryCouch record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryCouchService.checkCouchNumberUnique(record);
        }
        return uniqueFlag;
    }

    /**
     * 校验宿舍楼名称
     * @param record
     * @return
     */
    @PostMapping("/checkCouchNumberUnique")
    @ResponseBody
    public String checkCouchNumberUnique(DormitoryCouch record)
    {
        String uniqueFlag = "0";
        if (record != null) {
            uniqueFlag = iDormitoryCouchService.checkCouchNumberUnique(record);
        }
        return uniqueFlag;
    }

    /**
     * 查看宿舍床位详情
     *
     * @param roomCode
     * @param model
     * @return
     */
    @RequestMapping("/couchInfo/{roomCode}")
    /*@RequiresPermissions("couch:info")*/
    @Operlog(modal = "床位管理", descr = "查看房间详情")
    public String couchInfo(@PathVariable("roomCode") String roomCode,Model model){
        model.addAttribute("roomCode", roomCode);
        //查询房间名称
        DormitoryRoom param = new DormitoryRoom();
        param.setRoomCode(roomCode);
        List<DormitoryRoom> dormitoryRooms = iDormitoryRoomService.selectByDormitoryRoom(param);
        if(CollectionUtils.isNotEmpty(dormitoryRooms)){
            model.addAttribute("roomName",dormitoryRooms.get(0).getRoomName());
        }
        return prefix + "dmcList";
    }
}
