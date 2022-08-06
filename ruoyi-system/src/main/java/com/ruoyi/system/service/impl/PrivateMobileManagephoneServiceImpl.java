package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.PrivateMobileManagephone;
import com.ruoyi.system.mapper.PrivateMobileManagephoneMapper;
import com.ruoyi.system.service.IPrivateMobileManagephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手机号码Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-05
 */
@Service
public class PrivateMobileManagephoneServiceImpl implements IPrivateMobileManagephoneService {
    @Resource
    private PrivateMobileManagephoneMapper privateMobileManagephoneMapper;

    @Autowired
    RedisCache redisUtil;

    /**
     * 查询手机号码
     *
     * @param id 手机号码ID
     * @return 手机号码
     */
    @Override
    public PrivateMobileManagephone selectPrivateMobileManagephoneById(Integer id) {
        PrivateMobileManagephone managephone = null;
        String phone = (String)redisUtil.getCacheObject(id + "");
        if (phone == null) {
            managephone = privateMobileManagephoneMapper.selectPrivateMobileManagephoneById(id);
            redisUtil.setCacheObject(id+"", managephone);
        } else {
         managephone=  JSON.parseObject(phone,PrivateMobileManagephone.class);
        }
        return managephone;
    }

    /**
     * 查询手机号码列表
     *
     * @param privateMobileManagephone 手机号码
     * @return 手机号码
     */
    @Override
    public List<PrivateMobileManagephone> selectPrivateMobileManagephoneList(PrivateMobileManagephone privateMobileManagephone) {

        return privateMobileManagephoneMapper.selectPrivateMobileManagephoneList(privateMobileManagephone);
    }

    /**
     * 新增手机号码
     *
     * @param privateMobileManagephone 手机号码
     * @return 结果
     */
    @Override
    public int insertPrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone) {
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
    public int updatePrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone) {
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
    public int deletePrivateMobileManagephoneByIds(Integer[] ids) {
        return privateMobileManagephoneMapper.deletePrivateMobileManagephoneByIds(ids);
    }

    /**
     * 删除手机号码信息
     *
     * @param id 手机号码ID
     * @return 结果
     */
    @Override
    public int deletePrivateMobileManagephoneById(Integer id) {
        return privateMobileManagephoneMapper.deletePrivateMobileManagephoneById(id);
    }
}
