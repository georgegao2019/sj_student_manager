package com.sj.oa.project.controller.student;

import com.sj.oa.common.constant.DeptConstants;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.student.NoticeVacation;
import com.sj.oa.project.po.student.NoticeVacationWhereabouts;
import com.sj.oa.project.service.student.INoticeVacationService;
import com.sj.oa.project.service.student.INoticeVacationWhereaboutsService;
import com.sj.oa.project.service.user.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
@Controller
@RequestMapping("/nvacation")
public class NoticeVacationController extends BaseController {
    private String prefix = "system/vacation/";

    @Autowired
    INoticeVacationService iNoticeVacationService;

    @Autowired
    INoticeVacationWhereaboutsService iNoticeVacationWhereaboutsService;

    @Autowired
    IUserService iUserService;

    /**
     *
     * @描述 页面跳转到假期去向
     *
     * @date 2018/9/16 10:59
     */

    @RequestMapping("/tolist")
    @RequiresPermissions("nvacation:list")
    public String tolist(Model model)
    {
        return prefix + "noticeVacation";
    }

    /**
     *
     * @描述 假期去向列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(NoticeVacation NoticeVacation)
    {
        //开启分页
        startPage();
        List<NoticeVacation> NoticeVacations
                = iNoticeVacationService.selectByNoticeVacation(NoticeVacation);
        return getDataTable(NoticeVacations);
    }

    /**
     * @描述 ajax请求的所有假期去向
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<NoticeVacation> list(NoticeVacation noticeVacation)
    {
        List<NoticeVacation> resultList
                = iNoticeVacationService.selectByNoticeVacation(noticeVacation);
        return resultList;
    }
    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("nvacation:del")
    @ResponseBody
    @Operlog(modal = "假期去向管理",descr = "删除假期去向")
    public AjaxResult del(Integer[] ids)
    {
        try
        {
            Integer result = iNoticeVacationService.deleteByPrimaryKeys(ids);
            if(result > 0){
                //清除子表内容
                iNoticeVacationWhereaboutsService.deleteByNoticeId(ids);
            }
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return success();
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
        return prefix + "/noticeVacationAdd";
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */

    @RequestMapping("/addSave")
    @Operlog(modal = "假期去向管理",descr = "添加假期去向")
    @RequiresPermissions("nvacation:add")
    @ResponseBody
    public AjaxResult addNoticeVacation(NoticeVacation record)
    {
        record.setCreateTime(new Date());
        User user = getUser();
        record.setCreateUser(user.getName());
        record.setStatus(0);
        Integer noticeVacationId = iNoticeVacationService.insertSelective(record);
        if(noticeVacationId != null && noticeVacationId != 0){
            //查询所有的学生
            User param = new User();
            param.setDept(DeptConstants.DEPT_STUDENT);
            List<User> users = iUserService.selectByUser(param);

            List<NoticeVacationWhereabouts> list = new ArrayList<>();
            if(CollectionUtils.isNotEmpty(users)){
                for(User u : users){
                    NoticeVacationWhereabouts nv = new NoticeVacationWhereabouts();
                    nv.setStudentId(u.getStudentId());
                    nv.setStudentName(u.getName());
                    nv.setCreateTime(new Date());
                    nv.setCreateUser(user.getName());
                    list.add(nv);
                }
            }
            iNoticeVacationWhereaboutsService.insertBatch(list);
        }
        return  result(noticeVacationId);
    }


    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("nvacation:update")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        NoticeVacation NoticeVacation = iNoticeVacationService.selectByPrimaryKey(id);
        model.addAttribute(" noticeVacation", NoticeVacation);
        return prefix + "classInfoEdit";

    }



    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("nvacation:update")
    @Operlog(modal = "假期去向管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(NoticeVacation NoticeVacation)
    {
        int i = 0;
        try
        {
            i = iNoticeVacationService.updateByPrimaryKeySelective(NoticeVacation);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return result(i);
    }
}
