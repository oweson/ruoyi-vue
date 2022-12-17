package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Industry;
import com.ruoyi.system.mapper.IndustryMapper;
import com.ruoyi.system.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行业Service业务层处理
 *
 * @author oweson
 * @date 2022-11-30
 */
@Service
public class IndustryServiceImpl implements IIndustryService
{
    @Autowired
    private IndustryMapper industryMapper;

    /**
     * 查询行业
     *
     * @param code 行业主键
     * @return 行业
     */
    @Override
    public Industry selectIndustryByCode(String code)
    {
        return industryMapper.selectIndustryByCode(code);
    }

    /**
     * 查询行业列表
     *
     * @param industry 行业
     * @return 行业
     */
    @Override
    public List<Industry> selectIndustryList(Industry industry)
    {
        return industryMapper.selectIndustryList(industry);
    }

    /**
     * 新增行业
     *
     * @param industry 行业
     * @return 结果
     */
    @Override
    public int insertIndustry(Industry industry)
    {
        return industryMapper.insertIndustry(industry);
    }

    /**
     * 修改行业
     *
     * @param industry 行业
     * @return 结果
     */
    @Override
    public int updateIndustry(Industry industry)
    {
        return industryMapper.updateIndustry(industry);
    }

    /**
     * 批量删除行业
     *
     * @param codes 需要删除的行业主键
     * @return 结果
     */
    @Override
    public int deleteIndustryByCodes(String[] codes)
    {
        return industryMapper.deleteIndustryByCodes(codes);
    }

    /**
     * 删除行业信息
     *
     * @param code 行业主键
     * @return 结果
     */
    @Override
    public int deleteIndustryByCode(String code)
    {
        return industryMapper.deleteIndustryByCode(code);
    }
}
