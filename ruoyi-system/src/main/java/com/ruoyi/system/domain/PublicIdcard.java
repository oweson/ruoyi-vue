package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 身份归属对象 public_idcard
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicIdcard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 身份证号码前6位 */
    private Integer fCode;

    /** 省/直辖市 */
    @Excel(name = "省/直辖市")
    private String fProvince;

    /** 市/直辖市的区 */
    @Excel(name = "市/直辖市的区")
    private String fCity;

    /** 区/直辖市无此列 */
    @Excel(name = "区/直辖市无此列")
    private String fArea;

    public void setfCode(Integer fCode) 
    {
        this.fCode = fCode;
    }

    public Integer getfCode() 
    {
        return fCode;
    }
    public void setfProvince(String fProvince) 
    {
        this.fProvince = fProvince;
    }

    public String getfProvince() 
    {
        return fProvince;
    }
    public void setfCity(String fCity) 
    {
        this.fCity = fCity;
    }

    public String getfCity() 
    {
        return fCity;
    }
    public void setfArea(String fArea) 
    {
        this.fArea = fArea;
    }

    public String getfArea() 
    {
        return fArea;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fCode", getfCode())
            .append("fProvince", getfProvince())
            .append("fCity", getfCity())
            .append("fArea", getfArea())
            .toString();
    }
}
