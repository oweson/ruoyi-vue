package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * mq消息记录对象 sys_mq
 *
 * @author oweson
 * @date 2022-09-04
 */
public class SysMq extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 模块 */
    @Excel(name = "模块")
    private String module;

    /** 应用 */
    @Excel(name = "应用")
    private String application;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setModule(String module)
    {
        this.module = module;
    }

    public String getModule()
    {
        return module;
    }
    public void setApplication(String application)
    {
        this.application = application;
    }

    public String getApplication()
    {
        return application;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .append("module", getModule())
            .append("updateTime", getUpdateTime())
            .append("application", getApplication())
            .toString();
    }
}
