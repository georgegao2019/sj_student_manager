package com.sj.oa.project.controller;

import com.sj.oa.common.constant.CsEnum;
import com.sj.oa.common.constant.DeptConstants;
import com.sj.oa.common.constant.PositionConstants;
import com.sj.oa.common.constant.RoleConstants;
import com.sj.oa.common.exception.file.FileNameLengthException;
import com.sj.oa.common.exception.file.FileSizeException;
import com.sj.oa.common.utils.HttpHeaderUtil;
import com.sj.oa.common.utils.StringUtils;
import com.sj.oa.common.utils.file.UploadFile;
import com.sj.oa.common.utils.shiro.Encryption;
import com.sj.oa.common.utils.shiro.ShiroUtils;
import com.sj.oa.framework.annotation.Operlog;
import com.sj.oa.framework.web.controller.BaseController;
import com.sj.oa.framework.web.page.TableDataInfo;
import com.sj.oa.framework.web.po.AjaxResult;
import com.sj.oa.project.po.*;
import com.sj.oa.project.service.classall.IClassService;
import com.sj.oa.project.service.dept.IDeptService;
import com.sj.oa.project.service.major.IMajorService;
import com.sj.oa.project.service.major.IMajorServiceImpl;
import com.sj.oa.project.service.position.IPositionService;
import com.sj.oa.project.service.role.IRoleService;
import com.sj.oa.project.service.user.IUserService;
import org.activiti.engine.impl.util.CollectionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 永健
 *
 * 学生管理页面
 */

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController{

    private String prefix = "system/student/";

    @Autowired
    IUserService iUserService;
    @Autowired
    IRoleService iRoleService;
    @Autowired
    IDeptService iDeptService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IMajorService iMajorService;
    @Autowired
    IClassService iClassService;


    /**
     *
     * @描述 跳转到学生页面
     *
     * @date 2018/9/16 10:54
     */
    @RequestMapping("/tolist")
    @RequiresPermissions("student:list")
    public String toUserList(Model model)
    {
        //专业
        List<Major> majors
                = iMajorService.selectMajorList(new Major());
        model.addAttribute("majors",majors);
        //班级
        List<Classall> classalls
                = iClassService.selectClassList(new Classall());
        model.addAttribute("classalls",classalls);
        return prefix + "student";
    }


    /**
     * @描述 学生数据
     * @date 2018/9/15 12:30
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo list(User user)
    {
        startPage();
        //默认查询所有学生部
        user.setDept(DeptConstants.DEPT_STUDENT);
        List<User> users = iUserService.selectByUser(user);

        return getDataTable(users);
    }


    /**
     *
     * 编辑用户 system/user/edit/20180914-1
     */
    @RequiresPermissions("student:update")
    @RequestMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, Model model)
    {
        // 个人信息
        User user = iUserService.selectByPrimaryKey(userId);

        Map<String, Object> role_post_dept = getRole_Post_Dept();
        model.addAttribute("depts", role_post_dept.get("dept"));
        model.addAttribute("roles", role_post_dept.get("role"));
        model.addAttribute("positions", role_post_dept.get("position"));
        model.addAttribute("user", user);
        return prefix + "edit";
    }

    /**
     * 查看用户详情
     * system/user/info
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("student:info")
    @Operlog(modal = "用户管理", descr = "查看用户信息详情")
    public String userInfo(@PathVariable("userId") String userId,Model model){
        //个人信息
        User user = iUserService.selectByPrimaryKey(userId);
        model.addAttribute("user", user);
        return prefix + "info";
    }

    /**
     *
     * @描述 保存用户
     *
     * @date 2018/9/15 18:53
     */
    @PostMapping("/editSave")
    @RequiresPermissions("student:update")
    @Operlog(modal = "用户管理", descr = "修改用户信息")
    @ResponseBody
    public AjaxResult save(User user)
    {
        if (StringUtils.isNotNull(user.getUid()) && User.isBoss(user.getUid()))
        {
            return error("不允许修改管理员用户");
        }
        return result(iUserService.updateByPrimaryKeySelective(user));
    }


    /**
     * @描述 添加用户页面
     * @date 2018/9/15 18:46
     */
    @RequestMapping("/toAdd")
    @RequiresPermissions("student:add")
    public String toaddUser(Model model)
    {
        Map<String, Object> role_post_dept = getRole_Post_Dept();
        model.addAttribute("depts", role_post_dept.get("dept"));
        model.addAttribute("roles", role_post_dept.get("role"));
        model.addAttribute("positions", role_post_dept.get("position"));
        //查询班级信息
        List<Classall> classalls
                = iClassService.selectClassList(new Classall());
        model.addAttribute("classalls",classalls);
        return prefix + "add";
    }

    /**
     *
     * @描述 添加用户
     *
     * @date 2018/9/15 20:40
     */

    @RequestMapping("/addSave")
    @RequiresPermissions("student:add")
    @Operlog(modal = "用户管理", descr = "添加用户")
    @ResponseBody
    public AjaxResult addUser(User user)
    {
        user.setUid(createUID());
        user.setAvatar(CsEnum.avatar.USER_AVATAR.getValue());
        //通过此路径添加的用户都属于学生
        user.setDept(DeptConstants.DEPT_STUDENT);
        user.setRole_ID(RoleConstants.ROLE_STUDENT);
        user.setPosition(PositionConstants.POSITION_STUDENT);
        user.setCreateTime(new Date());
        //查询学生班级所在的年纪和专业
        Classall classall = new Classall();
        classall.setClassName(user.getClassName());
        List<Classall> classalls = iClassService.selectClassList(classall);
        if(CollectionUtils.isNotEmpty(classalls)){
            Classall result = classalls.get(0);
            user.setGrade(Integer.parseInt(result.getGrade()));
            user.setMajorCode(result.getMajorCode());
            user.setMajorName(result.getClassName());
        }
        return result(iUserService.insertSelective(user));
    }

    /**
     *
     * @描述 批量删除
     *
     * @date 2018/9/16 9:31
     */
    @RequestMapping("/del")
    @RequiresPermissions("student:del")
    @Operlog(modal = "用户模块", descr = "删除用户")
    @ResponseBody
    public AjaxResult delByUserIds(String[] ids)
    {
        try
        {
            int i = iUserService.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success();
    }

    /**
     *
     * @描述 编辑密码修改页面
     *
     * @date 2018/9/16 10:25
     */
    @RequestMapping("/resetPwd/{userId}")
    @RequiresPermissions("student:update")
    public String editPwd(@PathVariable("userId") String id, Model model)
    {
        model.addAttribute("uid", id);
        return prefix + "resetPwd";
    }


    /**
     *
     * @描述 密码修改
     *
     * @date 2018/9/16 10:42
     */

    @RequestMapping("/resetPwd")
    @RequiresPermissions("user:update")
    @Operlog(modal = "用户模块", descr = "修改密码")
    @ResponseBody
    public AjaxResult resetPwd(User user)
    {
        return result(iUserService.resrtPwd(user));
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(User user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = iUserService.checkPhoneUnique(user);
        }
        return uniqueFlag;
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(User user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = iUserService.checkEmailUnique(user);
        }
        return uniqueFlag;
    }


    /**
     *
     * @描述: 校验登录名唯一性
     *
     * @params:
     * @return:
     * @date: 2018/10/2 17:06
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(User user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = iUserService.checkLoginNameUnique(user);
        }
        return uniqueFlag;
    }

    @PostMapping("/getUserByStudentId")
    @ResponseBody
    public Object getUserByStudentId(User user){
        AjaxResult result = null;
        if(!StringUtils.isEmpty(user.getStudentId())){
            User userInfo = iUserService.selectByStudentId(user.getStudentId());
            if(userInfo != null){
                result = AjaxResult.success("操作成功");
                result.put("user",userInfo);
            }else{
                result = AjaxResult.error(1,"学号不存在");
            }
        }else{
            result = AjaxResult.error(2,"请求参数不全");
        }

        return result;
    }


    public Map<String, Object> getRole_Post_Dept()
    {
        Map<String, Object> map = new HashMap<>();
//        角色
        List<Role> roles = iRoleService.selectRoleList(new Role());
//        部门信息
        List<Dept> depts = iDeptService.selectDeptList(new Dept());
//        岗位
        List<Position> positions = iPositionService.selectPositionList(new Position());
        map.put("role", roles);
        map.put("dept", depts);
        map.put("position", positions);

        return map;
    }


    /**
     * 用户个人信息查看页面
     */
    @RequestMapping("/myMsg")
    public String ToMyMsg(Model model, HttpServletRequest request)
    {
        User user = iUserService.selectByPrimaryKey(getUserId());
        model.addAttribute("user", user);
        model.addAttribute("loginIp", HttpHeaderUtil.getIpAddr(request));
        return prefix + "profile/msg";
    }


    /**
     * 密码修改页面
     */
    @RequestMapping("/resetMyPwd")
    public String toResetPwd(Model model)
    {
        User user = iUserService.selectByPrimaryKey(getUserId());
        model.addAttribute("user", user);
        return prefix + "profile/resetPwd";
    }

    /**
     * 密码修改保存
     */
    @RequestMapping("/updateMyPwdSave")
    @ResponseBody
    @RequiresPermissions("user:update")
    @Operlog(modal = "个人信息", descr = "修改密码")
    public AjaxResult updateMyPwdSave(String password)
    {
        User user = new User();
        //将密码加密 用户id 作为盐
        user.setPwd(Encryption.getMD5(password, getUserId()).toString());
        user.setUid(getUserId());
        int i = iUserService.updateByPrimaryKeySelective(user);
        if (i > 0)
        {
            //更新shiro中的信息
            ShiroUtils.reloadUser(iUserService.selectByPrimaryKey(getUserId()));
            return success();
        }
        return error();
    }

    /**
     * 编辑用户头像修改
     */
    @RequestMapping("/updateAvatar")
    public String toupdateAvatar(Model model)
    {
        model.addAttribute("user", getUser());
        return prefix + "profile/avatar";
    }

    /**
     * 修改保存用户头像
     */
    @RequestMapping("/updateAvatarSave")
    @RequiresPermissions("user:update")
    @Operlog(modal = "个人信息", descr = "修改头像")
    @ResponseBody
    public AjaxResult toupdateAvatar(MultipartFile file)
    {
        try
        {
            String imgPath = UploadFile.uploadUserImg(file);
            if (StringUtils.isEmpty(imgPath))
            {
                return error("图片上传失败，稍后再试！");
            }

            User user = new User();
            user.setUid(getUserId());
            user.setAvatar(imgPath);
            int i = iUserService.updateByPrimaryKeySelective(user);
            if (i > 0)
            {
                ShiroUtils.reloadUser(iUserService.selectByPrimaryKey(getUserId()));
            }
            return result(i);
        }
        catch (IOException e)
        {
            return error();
        }
        catch (FileSizeException e)
        {
            //文件过大
            return error(e.getMsg());
        }
        catch (FileNameLengthException e)
        {
            //文件名字超长
            return error(e.getMsg());
        }
    }


    /**
     * 校验密码和原来密码是否相同
     */
    @RequestMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password)
    {
        //加密后与数据库密码比较
        String md5 = Encryption.getMD5(password, getUserId()).toString();
        if (md5.equals(getPwd()))
        {
            return true;
        }
        return false;
    }


}
