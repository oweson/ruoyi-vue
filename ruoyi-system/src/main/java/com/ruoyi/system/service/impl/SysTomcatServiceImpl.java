package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTomcatMapper;
import com.ruoyi.system.domain.SysTomcat;
import com.ruoyi.system.service.ISysTomcatService;

/**
 * 测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
@Service
public class SysTomcatServiceImpl implements ISysTomcatService 
{
    @Autowired
    private SysTomcatMapper sysTomcatMapper;

    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public SysTomcat selectSysTomcatById(Integer id)
    {
        return sysTomcatMapper.selectSysTomcatById(id);
    }

    /**
     * 查询测试列表
     * 
     * @param sysTomcat 测试
     * @return 测试
     */
    @Override
    public List<SysTomcat> selectSysTomcatList(SysTomcat sysTomcat)
    {
        return sysTomcatMapper.selectSysTomcatList(sysTomcat);
    }

    /**
     * 新增测试
     * 
     * @param sysTomcat 测试
     * @return 结果
     */
    @Override
    public int insertSysTomcat(SysTomcat sysTomcat)
    {
        sysTomcat.setCreateTime(DateUtils.getNowDate());
        return sysTomcatMapper.insertSysTomcat(sysTomcat);
    }

    /**
     * 修改测试
     * 
     * @param sysTomcat 测试
     * @return 结果
     */
    @Override
    public int updateSysTomcat(SysTomcat sysTomcat)
    {
        sysTomcat.setUpdateTime(DateUtils.getNowDate());
        return sysTomcatMapper.updateSysTomcat(sysTomcat);
    }

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的测试ID
     * @return 结果
     */
    @Override
    public int deleteSysTomcatByIds(Integer[] ids)
    {
        return sysTomcatMapper.deleteSysTomcatByIds(ids);
    }

    /**
     * 删除测试信息
     * 
     * @param id 测试ID
     * @return 结果
     */
    @Override
    public int deleteSysTomcatById(Integer id)
    {
        return sysTomcatMapper.deleteSysTomcatById(id);
    }
}
