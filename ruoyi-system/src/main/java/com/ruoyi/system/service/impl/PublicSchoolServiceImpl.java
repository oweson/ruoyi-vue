package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicSchoolMapper;
import com.ruoyi.system.domain.PublicSchool;
import com.ruoyi.system.service.IPublicSchoolService;

/**
 * 高校管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class PublicSchoolServiceImpl implements IPublicSchoolService 
{
    @Autowired
    private PublicSchoolMapper publicSchoolMapper;

    /**
     * 查询高校管理
     * 
     * @param id 高校管理ID
     * @return 高校管理
     */
    @Override
    public PublicSchool selectPublicSchoolById(Long id)
    {
        return publicSchoolMapper.selectPublicSchoolById(id);
    }

    /**
     * 查询高校管理列表
     * 
     * @param publicSchool 高校管理
     * @return 高校管理
     */
    @Override
    public List<PublicSchool> selectPublicSchoolList(PublicSchool publicSchool)
    {
        return publicSchoolMapper.selectPublicSchoolList(publicSchool);
    }

    /**
     * 新增高校管理
     * 
     * @param publicSchool 高校管理
     * @return 结果
     */
    @Override
    public int insertPublicSchool(PublicSchool publicSchool)
    {
        return publicSchoolMapper.insertPublicSchool(publicSchool);
    }

    /**
     * 修改高校管理
     * 
     * @param publicSchool 高校管理
     * @return 结果
     */
    @Override
    public int updatePublicSchool(PublicSchool publicSchool)
    {
        return publicSchoolMapper.updatePublicSchool(publicSchool);
    }

    /**
     * 批量删除高校管理
     * 
     * @param ids 需要删除的高校管理ID
     * @return 结果
     */
    @Override
    public int deletePublicSchoolByIds(Long[] ids)
    {
        return publicSchoolMapper.deletePublicSchoolByIds(ids);
    }

    /**
     * 删除高校管理信息
     * 
     * @param id 高校管理ID
     * @return 结果
     */
    @Override
    public int deletePublicSchoolById(Long id)
    {
        return publicSchoolMapper.deletePublicSchoolById(id);
    }
}
