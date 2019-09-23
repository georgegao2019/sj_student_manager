package com.sj.oa.project.controller.student;

import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.User;
import com.sj.oa.project.po.student.NoticeVacationWhereabouts;
import com.sj.oa.project.service.student.INoticeVacationWhereaboutsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */
@Controller
@RequestMapping("/whereabouts")
public class NoticeVacationWhereaboutsController extends BaseController {
    private String prefix = "system/vacation/";

    @Autowired
    INoticeVacationWhereaboutsService iNoticeVacationWhereaboutsService;

    /**
     *
     * @描述 页面跳转到假期去向
     *
     * @date 2018/9/16 10:59
     */

    @RequestMapping("/tolist")
    @RequiresPermissions("whereabouts:list")
    public String tolist(Model model)
    {

        return prefix + "noticeVacationWhereabouts";
    }

    /**
     *
     * @描述 假期去向列表页
     *
     * @date 2018/9/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(NoticeVacationWhereabouts record)
    {
        //开启分页
        startPage();
        //查询登录用户
        User user = getUser();
        if(user != null && !StringUtils.isEmpty(user.getStudentId())
            && user.getDept() == 14){
            record.setStudentId(user.getStudentId());
        }
        List<NoticeVacationWhereabouts> resultList
                = iNoticeVacationWhereaboutsService.selectByNoticeVacationWhereabouts(record);
        return getDataTable(resultList);
    }

    /**
     * @描述 ajax请求的所有假期去向
     *`
     * @date 2018/9/16 10:48
     */
    @RequestMapping("/ajaxlist")
    @ResponseBody
    public List<NoticeVacationWhereabouts> list(NoticeVacationWhereabouts record)
    {
        List<NoticeVacationWhereabouts> resultList
                = iNoticeVacationWhereaboutsService.selectByNoticeVacationWhereabouts(record);
        return resultList;
    }
    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("whereabouts:del")
    @ResponseBody
    @Operlog(modal = "假期去向管理",descr = "删除假期去向")
    public AjaxResult del(Integer[] ids)
    {
        try
        {
            iNoticeVacationWhereaboutsService.deleteByPrimaryKeys(ids);
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
        return prefix + "/add";
    }

    /**
     *
     * @描述 执行保存操作
     *
     * @date 2018/9/16 11:54
     */

    @RequestMapping("/addSave")
    @Operlog(modal = "假期去向管理",descr = "添加假期去向")
    @RequiresPermissions("whereabouts:add")
    @ResponseBody
    public AjaxResult addNoticeVacation(NoticeVacationWhereabouts record)
    {
        record.setCreateTime(new Date());
        User user = getUser();
        record.setCreateUser(user.getName());
        return  result(iNoticeVacationWhereaboutsService.insertSelective(record));
    }


    /**
     *
     * @描述 编辑修改页面
     *
     * @date 2018/9/16 14:06
     */
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("whereabouts:update")
    @Operlog(modal = "假期去向管理",descr = "更新")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        NoticeVacationWhereabouts notice
                = iNoticeVacationWhereaboutsService.selectByPrimaryKey(id);
        model.addAttribute("notice",notice);
        return prefix + "edit";
    }



    /**
     *
     * @描述 修改保存
     *
     * @date 2018/9/16 16:12
     */
    @RequestMapping("/editSave")
    @RequiresPermissions("whereabouts:update")
    @Operlog(modal = "假期去向管理",descr = "修改信息")
    @ResponseBody
    public AjaxResult save(NoticeVacationWhereabouts record)
    {
        int i = 0;
        try
        {
            record.setStatus(1);
            i = iNoticeVacationWhereaboutsService.updateByPrimaryKeySelective(record);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return result(i);
    }
}
