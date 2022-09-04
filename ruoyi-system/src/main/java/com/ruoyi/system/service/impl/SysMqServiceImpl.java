package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysMq;
import com.ruoyi.system.mapper.SysMqMapper;
import com.ruoyi.system.service.ISysMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mq消息记录Service业务层处理
 *
 * @author oweson
 * @date 2022-09-04
 */
@Service
public class SysMqServiceImpl implements ISysMqService
{
    @Autowired
    private SysMqMapper sysMqMapper;

    /**
     * 查询mq消息记录
     *
     * @param id mq消息记录主键
     * @return mq消息记录
     */
    @Override
    public SysMq selectSysMqById(Integer id)
    {
        return sysMqMapper.selectSysMqById(id);
    }

    /**
     * 查询mq消息记录列表
     *
     * @param sysMq mq消息记录
     * @return mq消息记录
     */
    @Override
    public List<SysMq> selectSysMqList(SysMq sysMq)
    {
        return sysMqMapper.selectSysMqList(sysMq);
    }

    /**
     * 新增mq消息记录
     *
     * @param sysMq mq消息记录
     * @return 结果
     */
    @Override
    public int insertSysMq(SysMq sysMq)
    {
        sysMq.setCreateTime(DateUtils.getNowDate());
        return sysMqMapper.insertSysMq(sysMq);
    }

    /**
     * 修改mq消息记录
     *
     * @param sysMq mq消息记录
     * @return 结果
     */
    @Override
    public int updateSysMq(SysMq sysMq)
    {
        sysMq.setUpdateTime(DateUtils.getNowDate());
        return sysMqMapper.updateSysMq(sysMq);
    }

    /**
     * 批量删除mq消息记录
     *
     * @param ids 需要删除的mq消息记录主键
     * @return 结果
     */
    @Override
    public int deleteSysMqByIds(String ids)
    {
        return sysMqMapper.deleteSysMqByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除mq消息记录信息
     *
     * @param id mq消息记录主键
     * @return 结果
     */
    @Override
    public int deleteSysMqById(Integer id)
    {
        return sysMqMapper.deleteSysMqById(id);
    }
}
