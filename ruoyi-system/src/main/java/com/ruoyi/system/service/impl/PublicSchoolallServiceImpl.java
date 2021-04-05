package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicSchoolallMapper;
import com.ruoyi.system.domain.PublicSchoolall;
import com.ruoyi.system.service.IPublicSchoolallService;

/**
 * 高校终极版Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class PublicSchoolallServiceImpl implements IPublicSchoolallService 
{
    @Autowired
    private PublicSchoolallMapper publicSchoolallMapper;

    /**
     * 查询高校终极版
     * 
     * @param id 高校终极版ID
     * @return 高校终极版
     */
    @Override
    public PublicSchoolall selectPublicSchoolallById(String id)
    {
        return publicSchoolallMapper.selectPublicSchoolallById(id);
    }

    /**
     * 查询高校终极版列表
     * 
     * @param publicSchoolall 高校终极版
     * @return 高校终极版
     */
    @Override
    public List<PublicSchoolall> selectPublicSchoolallList(PublicSchoolall publicSchoolall)
    {
        return publicSchoolallMapper.selectPublicSchoolallList(publicSchoolall);
    }

    /**
     * 新增高校终极版
     * 
     * @param publicSchoolall 高校终极版
     * @return 结果
     */
    @Override
    public int insertPublicSchoolall(PublicSchoolall publicSchoolall)
    {
        return publicSchoolallMapper.insertPublicSchoolall(publicSchoolall);
    }

    /**
     * 修改高校终极版
     * 
     * @param publicSchoolall 高校终极版
     * @return 结果
     */
    @Override
    public int updatePublicSchoolall(PublicSchoolall publicSchoolall)
    {
        return publicSchoolallMapper.updatePublicSchoolall(publicSchoolall);
    }

    /**
     * 批量删除高校终极版
     * 
     * @param ids 需要删除的高校终极版ID
     * @return 结果
     */
    @Override
    public int deletePublicSchoolallByIds(String[] ids)
    {
        return publicSchoolallMapper.deletePublicSchoolallByIds(ids);
    }

    /**
     * 删除高校终极版信息
     * 
     * @param id 高校终极版ID
     * @return 结果
     */
    @Override
    public int deletePublicSchoolallById(String id)
    {
        return publicSchoolallMapper.deletePublicSchoolallById(id);
    }
}
