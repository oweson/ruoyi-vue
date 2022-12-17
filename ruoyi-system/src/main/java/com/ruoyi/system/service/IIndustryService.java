package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Industry;

/**
 * 行业Service接口
 * 
 * @author oweson
 * @date 2022-11-30
 */
public interface IIndustryService 
{
    /**
     * 查询行业
     * 
     * @param code 行业主键
     * @return 行业
     */
    public Industry selectIndustryByCode(String code);

    /**
     * 查询行业列表
     * 
     * @param industry 行业
     * @return 行业集合
     */
    public List<Industry> selectIndustryList(Industry industry);

    /**
     * 新增行业
     * 
     * @param industry 行业
     * @return 结果
     */
    public int insertIndustry(Industry industry);

    /**
     * 修改行业
     * 
     * @param industry 行业
     * @return 结果
     */
    public int updateIndustry(Industry industry);

    /**
     * 批量删除行业
     * 
     * @param codes 需要删除的行业主键集合
     * @return 结果
     */
    public int deleteIndustryByCodes(String[] codes);

    /**
     * 删除行业信息
     * 
     * @param code 行业主键
     * @return 结果
     */
    public int deleteIndustryByCode(String code);
}
