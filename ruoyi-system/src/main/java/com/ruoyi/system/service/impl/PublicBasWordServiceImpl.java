package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicBasWordMapper;
import com.ruoyi.system.domain.PublicBasWord;
import com.ruoyi.system.service.IPublicBasWordService;

/**
 * 汉字大全Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class PublicBasWordServiceImpl implements IPublicBasWordService 
{
    @Autowired
    private PublicBasWordMapper publicBasWordMapper;

    /**
     * 查询汉字大全
     * 
     * @param id 汉字大全ID
     * @return 汉字大全
     */
    @Override
    public PublicBasWord selectPublicBasWordById(Long id)
    {
        return publicBasWordMapper.selectPublicBasWordById(id);
    }

    /**
     * 查询汉字大全列表
     * 
     * @param publicBasWord 汉字大全
     * @return 汉字大全
     */
    @Override
    public List<PublicBasWord> selectPublicBasWordList(PublicBasWord publicBasWord)
    {
        return publicBasWordMapper.selectPublicBasWordList(publicBasWord);
    }

    /**
     * 新增汉字大全
     * 
     * @param publicBasWord 汉字大全
     * @return 结果
     */
    @Override
    public int insertPublicBasWord(PublicBasWord publicBasWord)
    {
        return publicBasWordMapper.insertPublicBasWord(publicBasWord);
    }

    /**
     * 修改汉字大全
     * 
     * @param publicBasWord 汉字大全
     * @return 结果
     */
    @Override
    public int updatePublicBasWord(PublicBasWord publicBasWord)
    {
        return publicBasWordMapper.updatePublicBasWord(publicBasWord);
    }

    /**
     * 批量删除汉字大全
     * 
     * @param ids 需要删除的汉字大全ID
     * @return 结果
     */
    @Override
    public int deletePublicBasWordByIds(Long[] ids)
    {
        return publicBasWordMapper.deletePublicBasWordByIds(ids);
    }

    /**
     * 删除汉字大全信息
     * 
     * @param id 汉字大全ID
     * @return 结果
     */
    @Override
    public int deletePublicBasWordById(Long id)
    {
        return publicBasWordMapper.deletePublicBasWordById(id);
    }
}
