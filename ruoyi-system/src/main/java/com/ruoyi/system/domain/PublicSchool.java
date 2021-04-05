package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 高校管理对象 public_school
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public class PublicSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 学校编号 */
    @Excel(name = "学校编号")
    private String schoolId;

    /** 名字 */
    @Excel(name = "名字")
    private String schoolName;

    /** 省份id */
    private String provinceId;

    /** 省份 */
    @Excel(name = "省份")
    private String provinceName;

    /** 城市id */
    private String cityId;

    /** 城市名 */
    @Excel(name = "城市名")
    private String cityName;

    /** 高校级别 */
    @Excel(name = "高校级别")
    private String level;

    /** 高校所属 */
    @Excel(name = "高校所属")
    private String department;

    /** 其他 */
    @Excel(name = "其他")
    private String other;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSchoolId(String schoolId) 
    {
        this.schoolId = schoolId;
    }

    public String getSchoolId() 
    {
        return schoolId;
    }
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setProvinceId(String provinceId) 
    {
        this.provinceId = provinceId;
    }

    public String getProvinceId() 
    {
        return provinceId;
    }
    public void setProvinceName(String provinceName) 
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName() 
    {
        return provinceName;
    }
    public void setCityId(String cityId) 
    {
        this.cityId = cityId;
    }

    public String getCityId() 
    {
        return cityId;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("schoolId", getSchoolId())
            .append("schoolName", getSchoolName())
            .append("provinceId", getProvinceId())
            .append("provinceName", getProvinceName())
            .append("cityId", getCityId())
            .append("cityName", getCityName())
            .append("level", getLevel())
            .append("department", getDepartment())
            .append("other", getOther())
            .toString();
    }
}
