package com.sj.oa.project.controller.check;

import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.check.CheckLateback;
import com.sj.oa.project.po.college.Major;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sj.oa.project.service.check.ICheckEveningStudyService;
import com.sj.oa.project.po.college.Classall;
import com.sj.oa.project.service.user.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/cEveningStudy")
public class CheckEveningStudyController extends BaseController {

    private final static String prefix = "system/cEveningStudy";

    @Autowired
    private ICheckEveningStudyService iCheckEveningStudyService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/list")
    @RequiresPermissions("cEveningStudy:list")
    public String toList() {
        return prefix + "/classinfo";
    }

    @RequestMapping("/classlist")
    @ResponseBody
    public TableDataInfo classList()
    {
        List<YearSessionInfo> yearSessionInfos = iCheckEveningStudyService.selectYearSessionInfoByLimit(1);
        startPage();
        List<Classall> classAlls = iCheckEveningStudyService.selectClassInfoByGrade(yearSessionInfos);
        return getDataTable(classAlls);
    }

    @RequestMapping("/selectUsers/{className}")
    @RequiresPermissions("cEveningStudy:add")
    public String selectUsers(@PathVariable("className")String className,Model model) {
//        List<Classall> classList = new ArrayList<Classall>(classes.length);
//        for(int i = 0;i<classList.size();i++){
//            classList.get(i).setClassName(classes[i]);
//        }
        //String[] classes = {className};
        List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByType("WZXDM");
        model.addAttribute("className",className);
        model.addAttribute("demerits",demerits);
        return prefix+"/named";
    }

    @RequestMapping("/users")
    @ResponseBody
    public TableDataInfo userList(String className)
    {

        String[] classes = {className};
        List<User> users = iCheckEveningStudyService.selectUserByClassName(classes);
        return getDataTable(users);
    }

    @RequestMapping("/selectDemerit")
    public String selectDemerit(@RequestParam("class")String[] classes,Model model) {
        List<CheckEveningStudy> cess = iCheckEveningStudyService.selectCheckEveningStudyByTime(classes);
        //List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByType("WZXDM");
        //model.addAttribute("users",users);
        model.addAttribute("cess",cess);
        return prefix+"/selectdemerit";
    }

    @RequestMapping("/addSave")
    @ResponseBody
    public AjaxResult addCheckEveningStudy(@RequestParam("studentid")String[] studentids,@RequestParam("dCode")String[] dCodes)
    {
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        List<CheckEveningStudy> cess = new ArrayList<>();
        for(int i = 0;i<studentids.length;i++){
            if(dCodes[i] != null && !dCodes[i].isEmpty()){
                CheckEveningStudy ces = new CheckEveningStudy();
                ces.setStudentid(studentids[i].trim());
                ces.setdCode(dCodes[i].trim());
                ces.setCreateUser(loginUser.getName());
                ces.setCreateTime(new Date());
                cess.add(ces);
            }
        }

        Integer r = 0;
        if(cess.size()>0)
        r = iCheckEveningStudyService.insertCheckEveningStudy(cess);
        return  result(r);
    }

    @RequestMapping("/selectDemerits/{className}")
    public String selectDemerits(@PathVariable("className") String className, Model model)
    {
        model.addAttribute("className", className);
        return prefix + "/selectdemerit";

    }

    @RequestMapping("/demeritAll")
    @ResponseBody
    public TableDataInfo demeritList(String className)
    {
        String[] classNames = {className};
        startPage();
        List<CheckEveningStudy> checkEveningStudies = iCheckEveningStudyService.selectCheckEveningStudyByTime(classNames);
        return getDataTable(checkEveningStudies);
    }

    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("cEveningStudy:update")
    public String edit(@PathVariable("id") String id, Model model)
    {
        CheckEveningStudy ces = iCheckEveningStudyService.selectCheckEveningStudyById(id);
        model.addAttribute("ces", ces);
        return prefix + "/checkEveningStudyInfoEdit";

    }


    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("major:update")
    @Operlog(modal = "专业管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(CheckEveningStudy checkEveningStudy)
    {
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        checkEveningStudy.setUpdateUser(loginUser.getName());
        checkEveningStudy.setUpdateTime(new Date());
        int i = 0;
        try
        {
            i = iCheckEveningStudyService.updateCheckEveningStudyById(checkEveningStudy);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return result(i);
    }


    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("cEveningStudy:delete")
    @ResponseBody
    @Operlog(modal = "专业管理",descr = "删除专业")
    public AjaxResult del(String[] ids)
    {
        try
        {
            iCheckEveningStudyService.deleteCheckEveningStudyById(ids);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return success();
    }

    @RequestMapping("/toAdd")
    @RequiresPermissions("cEveningStudy:add")
    public String toAdd(Model model) {
        List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByType("WZXZTJC");
        model.addAttribute("demerits", demerits);
        return prefix + "/add";
    }

    @PostMapping("/getDCode")
    @ResponseBody
    public Object getDCode(String dCode){
        AjaxResult result = null;
        if(!StringUtils.isEmpty(dCode)){
            List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByCode(dCode);

            if(demerits != null){
                result = AjaxResult.success("操作成功");
                result.put("demerits",demerits);
            }
        }

        return result;
    }

}
