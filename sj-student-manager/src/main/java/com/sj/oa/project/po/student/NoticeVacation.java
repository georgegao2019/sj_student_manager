package com.sj.oa.project.po.student;

import com.sj.oa.framework.web.po.BasePo;

/**
 * Created by gaojun on 2019/9/18.
 */
public class NoticeVacation extends BasePo {

    private Integer id;

    //标题
    private String title;

    //内容
    private String content;

    //状态 0有效 1失效
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
