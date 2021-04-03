package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicIdcardMapper;
import com.ruoyi.system.domain.PublicIdcard;
import com.ruoyi.system.service.IPublicIdcardService;

/**
 * 身份归属Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class PublicIdcardServiceImpl implements IPublicIdcardService 
{
    @Autowired
    private PublicIdcardMapper publicIdcardMapper;

    /**
     * 查询身份归属
     * 
     * @param fCode 身份归属ID
     * @return 身份归属
     */
    @Override
    public PublicIdcard selectPublicIdcardById(Integer fCode)
    {
        return publicIdcardMapper.selectPublicIdcardById(fCode);
    }

    /**
     * 查询身份归属列表
     * 
     * @param publicIdcard 身份归属
     * @return 身份归属
     */
    @Override
    public List<PublicIdcard> selectPublicIdcardList(PublicIdcard publicIdcard)
    {
        return publicIdcardMapper.selectPublicIdcardList(publicIdcard);
    }

    /**
     * 新增身份归属
     * 
     * @param publicIdcard 身份归属
     * @return 结果
     */
    @Override
    public int insertPublicIdcard(PublicIdcard publicIdcard)
    {
        return publicIdcardMapper.insertPublicIdcard(publicIdcard);
    }

    /**
     * 修改身份归属
     * 
     * @param publicIdcard 身份归属
     * @return 结果
     */
    @Override
    public int updatePublicIdcard(PublicIdcard publicIdcard)
    {
        return publicIdcardMapper.updatePublicIdcard(publicIdcard);
    }

    /**
     * 批量删除身份归属
     * 
     * @param fCodes 需要删除的身份归属ID
     * @return 结果
     */
    @Override
    public int deletePublicIdcardByIds(Integer[] fCodes)
    {
        return publicIdcardMapper.deletePublicIdcardByIds(fCodes);
    }

    /**
     * 删除身份归属信息
     * 
     * @param fCode 身份归属ID
     * @return 结果
     */
    @Override
    public int deletePublicIdcardById(Integer fCode)
    {
        return publicIdcardMapper.deletePublicIdcardById(fCode);
    }
}
