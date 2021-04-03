package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PublicBabystudentMapper;
import com.ruoyi.system.domain.PublicBabystudent;
import com.ruoyi.system.service.IPublicBabystudentService;

/**
 * baby名字Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class PublicBabystudentServiceImpl implements IPublicBabystudentService 
{
    @Autowired
    private PublicBabystudentMapper publicBabystudentMapper;

    /**
     * 查询baby名字
     * 
     * @param id baby名字ID
     * @return baby名字
     */
    @Override
    public PublicBabystudent selectPublicBabystudentById(String id)
    {
        return publicBabystudentMapper.selectPublicBabystudentById(id);
    }

    /**
     * 查询baby名字列表
     * 
     * @param publicBabystudent baby名字
     * @return baby名字
     */
    @Override
    public List<PublicBabystudent> selectPublicBabystudentList(PublicBabystudent publicBabystudent)
    {
        return publicBabystudentMapper.selectPublicBabystudentList(publicBabystudent);
    }

    /**
     * 新增baby名字
     * 
     * @param publicBabystudent baby名字
     * @return 结果
     */
    @Override
    public int insertPublicBabystudent(PublicBabystudent publicBabystudent)
    {
        return publicBabystudentMapper.insertPublicBabystudent(publicBabystudent);
    }

    /**
     * 修改baby名字
     * 
     * @param publicBabystudent baby名字
     * @return 结果
     */
    @Override
    public int updatePublicBabystudent(PublicBabystudent publicBabystudent)
    {
        return publicBabystudentMapper.updatePublicBabystudent(publicBabystudent);
    }

    /**
     * 批量删除baby名字
     * 
     * @param ids 需要删除的baby名字ID
     * @return 结果
     */
    @Override
    public int deletePublicBabystudentByIds(String[] ids)
    {
        return publicBabystudentMapper.deletePublicBabystudentByIds(ids);
    }

    /**
     * 删除baby名字信息
     * 
     * @param id baby名字ID
     * @return 结果
     */
    @Override
    public int deletePublicBabystudentById(String id)
    {
        return publicBabystudentMapper.deletePublicBabystudentById(id);
    }
}
