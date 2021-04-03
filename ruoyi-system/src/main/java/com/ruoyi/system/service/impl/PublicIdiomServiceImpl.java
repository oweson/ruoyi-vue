package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicIdiomMapper;
import com.ruoyi.system.domain.PublicIdiom;
import com.ruoyi.system.service.IPublicIdiomService;

/**
 * 成语管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class PublicIdiomServiceImpl implements IPublicIdiomService 
{
    @Autowired
    private PublicIdiomMapper publicIdiomMapper;

    /**
     * 查询成语管理
     * 
     * @param id 成语管理ID
     * @return 成语管理
     */
    @Override
    public PublicIdiom selectPublicIdiomById(Long id)
    {
        return publicIdiomMapper.selectPublicIdiomById(id);
    }

    /**
     * 查询成语管理列表
     * 
     * @param publicIdiom 成语管理
     * @return 成语管理
     */
    @Override
    public List<PublicIdiom> selectPublicIdiomList(PublicIdiom publicIdiom)
    {
        return publicIdiomMapper.selectPublicIdiomList(publicIdiom);
    }

    /**
     * 新增成语管理
     * 
     * @param publicIdiom 成语管理
     * @return 结果
     */
    @Override
    public int insertPublicIdiom(PublicIdiom publicIdiom)
    {
        return publicIdiomMapper.insertPublicIdiom(publicIdiom);
    }

    /**
     * 修改成语管理
     * 
     * @param publicIdiom 成语管理
     * @return 结果
     */
    @Override
    public int updatePublicIdiom(PublicIdiom publicIdiom)
    {
        return publicIdiomMapper.updatePublicIdiom(publicIdiom);
    }

    /**
     * 批量删除成语管理
     * 
     * @param ids 需要删除的成语管理ID
     * @return 结果
     */
    @Override
    public int deletePublicIdiomByIds(Long[] ids)
    {
        return publicIdiomMapper.deletePublicIdiomByIds(ids);
    }

    /**
     * 删除成语管理信息
     * 
     * @param id 成语管理ID
     * @return 结果
     */
    @Override
    public int deletePublicIdiomById(Long id)
    {
        return publicIdiomMapper.deletePublicIdiomById(id);
    }
}
