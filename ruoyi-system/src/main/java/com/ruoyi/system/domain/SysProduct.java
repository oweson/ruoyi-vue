package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 产品对象 sys_product
 * 
 * @author oweson
 * @date 2022-11-25
 */
public class SysProduct extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
    @Excel(name = "产品id")
    private Long productId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品状态（0正常 1停用） */
    @Excel(name = "产品状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("parentId", getParentId())
            .append("productName", getProductName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .toString();
    }
}
