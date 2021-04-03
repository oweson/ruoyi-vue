package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 码段归属对象 public_mobile
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicMobile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Integer id;

    /** 手机号码段 */
    @Excel(name = "手机号码段")
    private String phone;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 运营商 */
    @Excel(name = "运营商")
    private String serviceProvider;

    /** 区号 */
    @Excel(name = "区号")
    private String cityCode;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postcode;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setServiceProvider(String serviceProvider) 
    {
        this.serviceProvider = serviceProvider;
    }

    public String getServiceProvider() 
    {
        return serviceProvider;
    }
    public void setCityCode(String cityCode) 
    {
        this.cityCode = cityCode;
    }

    public String getCityCode() 
    {
        return cityCode;
    }
    public void setPostcode(String postcode) 
    {
        this.postcode = postcode;
    }

    public String getPostcode() 
    {
        return postcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("serviceProvider", getServiceProvider())
            .append("cityCode", getCityCode())
            .append("postcode", getPostcode())
            .toString();
    }
}
