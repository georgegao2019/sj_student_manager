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

    //前缀
    private final static String prefix = "system/cEveningStudy";

    @Autowired
    private ICheckEveningStudyService iCheckEveningStudyService;

    @Autowired
    private IUserService iUserService;

    /**
     *
     * @描述: 跳转到选择班级页
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:13
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("cEveningStudy:tolist")
    public String toList(Model model) {
        List<YearSessionInfo> yearSessionInfos = iCheckEveningStudyService.selectYearSessionInfoByLimit(1);
        List<Classall> classAlls = iCheckEveningStudyService.selectClassInfoByGrade(yearSessionInfos);
        model.addAttribute("classes",classAlls);
        return prefix + "/selectclass";
    }

    /**
     *
     * @描述: 返回表格数据
     *
     * @params:
     * @return:
     * @date: 2018/9/26 21:15
     */
    @RequestMapping("/selectUsers")
    public String selectUsers(@RequestParam("class")String[] classes,Model model) {
//        List<Classall> classList = new ArrayList<Classall>(classes.length);
//        for(int i = 0;i<classList.size();i++){
//            classList.get(i).setClassName(classes[i]);
//        }
        List<User> users = iCheckEveningStudyService.selectUserByClassName(classes);
        List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByType("WZXDM");
        model.addAttribute("users",users);
        model.addAttribute("demerits",demerits);
        return prefix+"/named";
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
    public String addCheckEveningStudy(@RequestParam("studentid")String[] studentids,@RequestParam("dCode")String[] dCodes,Model model)
    {
        //List<CheckEveningStudy> checkEveningStudies
        User loginUser = iUserService.selectByPrimaryKey(getUserId());
        //request.;
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

//        Iterator<CheckEveningStudy> it = checkEveningStudies.iterator();
//        while(it.hasNext()){
//            CheckEveningStudy ces = it.next();
//            if(ces.getdCode() !=null && !ces.getdCode().isEmpty()){
//                ces.setCreateUser(loginUser.getName());
//                ces.setCreateTime(new Date());
//
//            }else{
//                it.remove();
//            }
//        }
        iCheckEveningStudyService.insertCheckEveningStudy(cess);
        List<YearSessionInfo> yearSessionInfos = iCheckEveningStudyService.selectYearSessionInfoByLimit(1);
        List<Classall> classAlls = iCheckEveningStudyService.selectClassInfoByGrade(yearSessionInfos);
        model.addAttribute("classes",classAlls);
        return  prefix + "/selectclass";
//        return null;
    }

    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    //@RequiresPermissions("major:update")
    public String edit(@PathVariable("id") String id, Model model)
    {
        CheckEveningStudy checkEveningStudy = iCheckEveningStudyService.selectCheckEveningStudyById(id);
        List<Demerit> demerits = iCheckEveningStudyService.selectDemeritByType("WZXDM");
        model.addAttribute("checkEveningStudy", checkEveningStudy);
        model.addAttribute("demerits", demerits);
        return prefix + "/checkEveningStudyInfoEdit";

    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    //@RequiresPermissions("major:del")
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
