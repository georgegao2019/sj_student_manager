package com.sj.oa.project.controller.check;

import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.project.po.college.YearSessionInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sj.oa.project.service.check.ICheckEveningStudyService;

import java.util.List;

@Controller
@RequestMapping("/cEveningStudy")
public class CheckEveningStudyController extends BaseController {

    //前缀
    private final static String prefix = "system/cEveningStudy";

    @Autowired
    private ICheckEveningStudyService iCheckEveningStudyService;

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
        //List<>
        //iCheckEveningStudyService.selectClassInfoByGrade()
        model.addAttribute("yearSessionInfos",yearSessionInfos);
        return prefix + "/selectclass";
    }



}
