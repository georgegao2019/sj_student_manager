package com.sj.oa.project.controller.check;

import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.check.CheckEveningStudy;
import com.sj.oa.project.po.check.CheckLateback;
import com.sj.oa.project.po.college.YearSessionInfo;
import com.sj.oa.project.po.demerit.Demerit;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sj.oa.project.service.check.ICheckEveningStudyService;
import com.sj.oa.project.po.college.Classall;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public AjaxResult addCheckEveningStudy(@RequestParam("studentid")String[] studentids,@RequestParam("dCode")String[] dCodes)
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
        return  null;
//        return null;
    }
}
