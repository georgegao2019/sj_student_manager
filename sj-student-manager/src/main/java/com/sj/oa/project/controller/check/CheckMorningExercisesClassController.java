package com.sj.oa.project.controller.check;

import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckMorningExercises;
import com.sj.oa.project.po.check.CheckMorningExercisesClass;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;
import com.sj.oa.project.service.check.ICheckEveningStudyService;
import com.sj.oa.project.service.check.ICheckMorningExercisesClassService;
import com.sj.oa.project.service.check.ICheckMorningExercisesService;
import com.sj.oa.project.service.college.IClassService;
import com.sj.oa.project.service.college.IMajorService;
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
@RequestMapping("/cMorningExercisesClass")
public class CheckMorningExercisesClassController extends BaseController {

    //前缀
    private final static String prefix = "system/cMorningExercises";
    @Autowired
    ICheckMorningExercisesClassService ICheckMorningExercisesClassService;
    @Autowired
    IUserService iUserService;
    @Autowired
    com.sj.oa.project.service.demerit.IDemeritService IDemeritService;
    @Autowired
    private ICheckEveningStudyService iCheckEveningStudyService;
    @Autowired
    IClassService IClassService;
    @Autowired
    ICheckMorningExercisesService iCheckMorningExercisesService;

    /**
     *
     * @描述: 跳转到列表页
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:13
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("cMorningExercisesClass:list")
    public String toList(Model model) {
        //查询全部专业
        //List<Major> majors = iMajorService.selectMajorList();
        List<CheckMorningExercisesClass> records = ICheckMorningExercisesClassService.selectByCheckMorningExercisesClass();

        model.addAttribute("Records", records);

        return prefix + "/cMorningExercisesClass";
    }
    /**
     *
     * @描述: 返回表格数据
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:15
     */
//    @RequestMapping("/tableList")
//    @ResponseBody
//    public TableDataInfo tableList(CheckMorningExercisesClass record) {
//        startPage();
//        List<CheckMorningExercisesClass> records = iCheckMorningExercisesClassService.selectByCheckMorningExercisesClass(record);
//        return getDataTable(records);
//    }
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
        return prefix + "/addClass";
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
    public AjaxResult addSave(CheckMorningExercisesClass record) throws Exception {
        record.setCreateTime(new Date());
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        record.setCreateUser(loginUser.getName());
        //新增的早操检查记录默认是 有效 状态
        record.setStatus(0);
        return result(ICheckMorningExercisesClassService.insertSelective(record));
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
    @RequiresPermissions("cMorningExercisesClass:del")
    @Operlog(modal = "早操检查",descr = "删除记录")
    @ResponseBody
    public AjaxResult del(Integer[] ids) {
        return result(ICheckMorningExercisesClassService.deleteByPrimaryKeys(ids));
    }
    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2019/8/26 21:17
     */
    @RequestMapping("/cMorningExercisesClass/{id}")
    @RequiresPermissions("cMorningExercisesClass:update")
    @Operlog(modal = "早操检查",descr = "查询记录")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        CheckMorningExercisesClass record = ICheckMorningExercisesClassService.selectByPrimaryKey(id);
        model.addAttribute("note", record);
        return prefix + "/editClass";
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
    @RequiresPermissions("cMorningExercisesClass:update")
    @Operlog(modal = "早操检查",descr = "修改记录")
    @ResponseBody
    public AjaxResult editSave(CheckMorningExercisesClass record) {
        return result(ICheckMorningExercisesClassService.updateByPrimaryKeySelective(record));
    }




    @RequestMapping("/findTotalnumber")
    @ResponseBody
    public Classall findTotalnumber(Model model, String className){
        Classall  Class = IClassService.findTotalNumber(className);
        return Class;

    }

    @RequestMapping("/findlateName")
    @ResponseBody
    public String findlateName(String className){
        String  name = iCheckMorningExercisesService.findlateName(className);
        return name;

    }

    @RequestMapping("/findqingjiaName")
    @ResponseBody
    public String findqingjiaName(String className){
        String  name = iCheckMorningExercisesService.findqingjiaName(className);
        return name;

    }



}
