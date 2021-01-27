package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTomcat;

/**
 * 测试Service接口
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
public interface ISysTomcatService 
{
    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    public SysTomcat selectSysTomcatById(Integer id);

    /**
     * 查询测试列表
     * 
     * @param sysTomcat 测试
     * @return 测试集合
     */
    public List<SysTomcat> selectSysTomcatList(SysTomcat sysTomcat);

    /**
     * 新增测试
     * 
     * @param sysTomcat 测试
     * @return 结果
     */
    public int insertSysTomcat(SysTomcat sysTomcat);

    /**
     * 修改测试
     * 
     * @param sysTomcat 测试
     * @return 结果
     */
    public int updateSysTomcat(SysTomcat sysTomcat);

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的测试ID
     * @return 结果
     */
    public int deleteSysTomcatByIds(Integer[] ids);

    /**
     * 删除测试信息
     * 
     * @param id 测试ID
     * @return 结果
     */
    public int deleteSysTomcatById(Integer id);
}
