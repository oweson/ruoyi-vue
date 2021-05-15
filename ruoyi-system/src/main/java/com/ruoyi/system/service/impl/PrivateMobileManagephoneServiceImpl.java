package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PrivateMobileManagephoneMapper;
import com.ruoyi.system.domain.PrivateMobileManagephone;
import com.ruoyi.system.service.IPrivateMobileManagephoneService;

/**
 * 手机号码Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class PrivateMobileManagephoneServiceImpl implements IPrivateMobileManagephoneService 
{
    @Autowired
    private PrivateMobileManagephoneMapper privateMobileManagephoneMapper;

    /**
     * 查询手机号码
     * 
     * @param id 手机号码ID
     * @return 手机号码
     */
    @Override
    public PrivateMobileManagephone selectPrivateMobileManagephoneById(Integer id)
    {
        return privateMobileManagephoneMapper.selectPrivateMobileManagephoneById(id);
    }

    /**
     * 查询手机号码列表
     * 
     * @param privateMobileManagephone 手机号码
     * @return 手机号码
     */
    @Override
    public List<PrivateMobileManagephone> selectPrivateMobileManagephoneList(PrivateMobileManagephone privateMobileManagephone)
    {
        return privateMobileManagephoneMapper.selectPrivateMobileManagephoneList(privateMobileManagephone);
    }

    /**
     * 新增手机号码
     * 
     * @param privateMobileManagephone 手机号码
     * @return 结果
     */
    @Override
    public int insertPrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone)
    {
        privateMobileManagephone.setCreateTime(DateUtils.getNowDate());
        return privateMobileManagephoneMapper.insertPrivateMobileManagephone(privateMobileManagephone);
    }

    /**
     * 修改手机号码
     * 
     * @param privateMobileManagephone 手机号码
     * @return 结果
     */
    @Override
    public int updatePrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone)
    {
        privateMobileManagephone.setUpdateTime(DateUtils.getNowDate());
        return privateMobileManagephoneMapper.updatePrivateMobileManagephone(privateMobileManagephone);
    }

    /**
     * 批量删除手机号码
     * 
     * @param ids 需要删除的手机号码ID
     * @return 结果
     */
    @Override
    public int deletePrivateMobileManagephoneByIds(Integer[] ids)
    {
        return privateMobileManagephoneMapper.deletePrivateMobileManagephoneByIds(ids);
    }

    /**
     * 删除手机号码信息
     * 
     * @param id 手机号码ID
     * @return 结果
     */
    @Override
    public int deletePrivateMobileManagephoneById(Integer id)
    {
        return privateMobileManagephoneMapper.deletePrivateMobileManagephoneById(id);
    }
}