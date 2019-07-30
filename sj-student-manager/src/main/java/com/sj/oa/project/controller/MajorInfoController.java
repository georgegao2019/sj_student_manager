package com.sj.oa.project.controller;

import com.sj.oa.common.constant.CsEnum;
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
import com.sj.oa.project.po.Dept;
import com.sj.oa.project.po.Position;
import com.sj.oa.project.po.Role;
import com.sj.oa.project.po.User;
import com.sj.oa.project.service.college.IMajorInfoService;
import com.sj.oa.project.service.dept.IDeptService;
import com.sj.oa.project.service.position.IPositionService;
import com.sj.oa.project.service.role.IRoleService;
import com.sj.oa.project.service.user.IUserService;
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
 * @author gaojun
 * @date 2019/07/30
 */

@Controller
@RequestMapping("/major")
public class MajorInfoController extends BaseController{

    private String prefix = "system/major/";

    @Autowired
    IMajorInfoService majorInfoService;




}
