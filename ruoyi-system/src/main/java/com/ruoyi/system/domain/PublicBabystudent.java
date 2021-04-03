package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * baby名字对象 public_babystudent
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicBabystudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private String id;

    /** 学生id */
    @Excel(name = "学生id")
    private String alostudentid;

    /** 创建者id */
    @Excel(name = "创建者id")
    private Long studentuserid;

    /** 电话 */
    @Excel(name = "电话")
    private String alostudentphone;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyid;

    /** 校区id */
    @Excel(name = "校区id")
    private Long campusid;

    /** 中文名字 */
    @Excel(name = "中文名字")
    private String chinesename;

    /** 英文名字 */
    @Excel(name = "英文名字")
    private String englishname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setAlostudentid(String alostudentid) 
    {
        this.alostudentid = alostudentid;
    }

    public String getAlostudentid() 
    {
        return alostudentid;
    }
    public void setStudentuserid(Long studentuserid) 
    {
        this.studentuserid = studentuserid;
    }

    public Long getStudentuserid() 
    {
        return studentuserid;
    }
    public void setAlostudentphone(String alostudentphone) 
    {
        this.alostudentphone = alostudentphone;
    }

    public String getAlostudentphone() 
    {
        return alostudentphone;
    }
    public void setCompanyid(Long companyid) 
    {
        this.companyid = companyid;
    }

    public Long getCompanyid() 
    {
        return companyid;
    }
    public void setCampusid(Long campusid) 
    {
        this.campusid = campusid;
    }

    public Long getCampusid() 
    {
        return campusid;
    }
    public void setChinesename(String chinesename) 
    {
        this.chinesename = chinesename;
    }

    public String getChinesename() 
    {
        return chinesename;
    }
    public void setEnglishname(String englishname) 
    {
        this.englishname = englishname;
    }

    public String getEnglishname() 
    {
        return englishname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("alostudentid", getAlostudentid())
            .append("studentuserid", getStudentuserid())
            .append("alostudentphone", getAlostudentphone())
            .append("companyid", getCompanyid())
            .append("campusid", getCampusid())
            .append("chinesename", getChinesename())
            .append("englishname", getEnglishname())
            .toString();
    }
}
