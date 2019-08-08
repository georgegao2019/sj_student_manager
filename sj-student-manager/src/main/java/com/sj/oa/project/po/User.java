package com.sj.oa.project.po;

import com.sj.oa.framework.web.po.BasePo;

import java.util.Date;

public class User extends BasePo{

    private String uid;
    //密码
    private String pwd;
    //登录用户名
    private String loginName;
    //学生姓名
    private String name;
    //学生学号
    private String studentId;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //部门
    private Integer dept;
    //身份证号
    private String cardNo;
    //专业
    private String major;
    //专业名称
    private String majorName;
    //应届年份
    private Integer grade;
    //班级名称
    private String className;
    //岗位
    private Integer position;
    //爱好
    private String hobby;
    //联系方式
    private String tel;
    //邮箱
    private String email;
    //头像地址
    private String avatar;
    //创建时间
    private Date createTime;
    //状态
    private Integer status;
    //是否删除
    private Integer isdel;
    //自我介绍
    private String self_introduction;
    //角色ID
    private Integer role_ID;

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 角色
     */
    private Role role;
    //部门
    private Dept deptPo;

    /**
     * 岗位
     */
    private Position positionPo;


    /**
     * 判断是否是管理员
     */
    public static boolean isBoss(String uid)
    {
        return uid.equals("1111111111") ? true : false;
    }

    public static boolean isAdmin(User user){
        if(user != null && user.getDept() != null){
            return user.getDept()==1||user.getDept()==13? true:false;
        }else{
            return false;
        }
    }
    /**
     * 判断用户角色是不是信息管理中心干员
     * @return
     */
    public static boolean isInformationCenterP(Integer role_ID){
        return role_ID==41? true:false;
    }
    /**
     * 判断用户角色是不是信息管理中心部长
     * @return
     */
    public static boolean isInformationCenterM(Integer role_ID){
        return role_ID==42? true:false;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getDept()
    {
        return dept;
    }

    public void setDept(Integer dept)
    {
        this.dept = dept;
    }

    public Integer getPosition()
    {
        return position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getIsdel()
    {
        return isdel;
    }

    public void setIsdel(Integer isdel)
    {
        this.isdel = isdel;
    }

    public String getSelf_introduction()
    {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction)
    {
        this.self_introduction = self_introduction;
    }

    public Integer getRole_ID()
    {
        return role_ID;
    }

    public void setRole_ID(Integer role_ID)
    {
        this.role_ID = role_ID;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public Dept getDeptPo()
    {
        return deptPo;
    }

    public void setDeptPo(Dept deptPo)
    {
        this.deptPo = deptPo;
    }

    public Position getPositionPo()
    {
        return positionPo;
    }

    public void setPositionPo(Position positionPo)
    {
        this.positionPo = positionPo;
    }


    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("uid='").append(uid).append('\'');
        sb.append(", pwd='").append(pwd).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", age=").append(age);
        sb.append(", dept=").append(dept);
        sb.append(", position=").append(position);
        sb.append(", hobby='").append(hobby).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", isdel=").append(isdel);
        sb.append(", self_introduction='").append(self_introduction).append('\'');
        sb.append(", role_ID=").append(role_ID);
        sb.append(", role=").append(role);
        sb.append(", deptPo=").append(deptPo);
        sb.append(", positionPo=").append(positionPo);
        sb.append('}');
        return sb.toString();
    }
}