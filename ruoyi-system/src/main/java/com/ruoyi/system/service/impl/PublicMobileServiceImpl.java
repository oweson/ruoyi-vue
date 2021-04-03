package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.mapper.PublicMobileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.PublicMobile;
import com.ruoyi.system.service.IPublicMobileService;

/**
 * 码段归属地Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
@Service
public class PublicMobileServiceImpl implements IPublicMobileService 
{
    @Autowired
    private PublicMobileMapper publicMobileMapper;

    /**
     * 查询码段归属地
     * 
     * @param id 码段归属地ID
     * @return 码段归属地
     */
    @Override
    public PublicMobile selectPublicMobileById(Integer id)
    {
        return publicMobileMapper.selectPublicMobileById(id);
    }

    /**
     * 查询码段归属地列表
     * 
     * @param publicMobile 码段归属地
     * @return 码段归属地
     */
    @Override
    public List<PublicMobile> selectPublicMobileList(PublicMobile publicMobile)
    {
        return publicMobileMapper.selectPublicMobileList(publicMobile);
    }

    /**
     * 新增码段归属地
     * 
     * @param publicMobile 码段归属地
     * @return 结果
     */
    @Override
    public int insertPublicMobile(PublicMobile publicMobile)
    {
        return publicMobileMapper.insertPublicMobile(publicMobile);
    }

    /**
     * 修改码段归属地
     * 
     * @param publicMobile 码段归属地
     * @return 结果
     */
    @Override
    public int updatePublicMobile(PublicMobile publicMobile)
    {
        return publicMobileMapper.updatePublicMobile(publicMobile);
    }

    /**
     * 批量删除码段归属地
     * 
     * @param ids 需要删除的码段归属地ID
     * @return 结果
     */
    @Override
    public int deletePublicMobileByIds(Integer[] ids)
    {
        return publicMobileMapper.deletePublicMobileByIds(ids);
    }

    /**
     * 删除码段归属地信息
     * 
     * @param id 码段归属地ID
     * @return 结果
     */
    @Override
    public int deletePublicMobileById(Integer id)
    {
        return publicMobileMapper.deletePublicMobileById(id);
    }
}
