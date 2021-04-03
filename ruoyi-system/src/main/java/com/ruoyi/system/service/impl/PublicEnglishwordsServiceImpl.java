package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicEnglishwordsMapper;
import com.ruoyi.system.domain.PublicEnglishwords;
import com.ruoyi.system.service.IPublicEnglishwordsService;

/**
 * 单词管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class PublicEnglishwordsServiceImpl implements IPublicEnglishwordsService 
{
    @Autowired
    private PublicEnglishwordsMapper publicEnglishwordsMapper;

    /**
     * 查询单词管理
     * 
     * @param id 单词管理ID
     * @return 单词管理
     */
    @Override
    public PublicEnglishwords selectPublicEnglishwordsById(Integer id)
    {
        return publicEnglishwordsMapper.selectPublicEnglishwordsById(id);
    }

    /**
     * 查询单词管理列表
     * 
     * @param publicEnglishwords 单词管理
     * @return 单词管理
     */
    @Override
    public List<PublicEnglishwords> selectPublicEnglishwordsList(PublicEnglishwords publicEnglishwords)
    {
        return publicEnglishwordsMapper.selectPublicEnglishwordsList(publicEnglishwords);
    }

    /**
     * 新增单词管理
     * 
     * @param publicEnglishwords 单词管理
     * @return 结果
     */
    @Override
    public int insertPublicEnglishwords(PublicEnglishwords publicEnglishwords)
    {
        return publicEnglishwordsMapper.insertPublicEnglishwords(publicEnglishwords);
    }

    /**
     * 修改单词管理
     * 
     * @param publicEnglishwords 单词管理
     * @return 结果
     */
    @Override
    public int updatePublicEnglishwords(PublicEnglishwords publicEnglishwords)
    {
        return publicEnglishwordsMapper.updatePublicEnglishwords(publicEnglishwords);
    }

    /**
     * 批量删除单词管理
     * 
     * @param ids 需要删除的单词管理ID
     * @return 结果
     */
    @Override
    public int deletePublicEnglishwordsByIds(Integer[] ids)
    {
        return publicEnglishwordsMapper.deletePublicEnglishwordsByIds(ids);
    }

    /**
     * 删除单词管理信息
     * 
     * @param id 单词管理ID
     * @return 结果
     */
    @Override
    public int deletePublicEnglishwordsById(Integer id)
    {
        return publicEnglishwordsMapper.deletePublicEnglishwordsById(id);
    }
}
