package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysMq;

import java.util.List;

/**
 * mq消息记录Service接口
 *
 * @author oweson
 * @date 2022-09-04
 */
public interface ISysMqService
{
    /**
     * 查询mq消息记录
     *
     * @param id mq消息记录主键
     * @return mq消息记录
     */
    public SysMq selectSysMqById(Integer id);

    /**
     * 查询mq消息记录列表
     *
     * @param sysMq mq消息记录
     * @return mq消息记录集合
     */
    public List<SysMq> selectSysMqList(SysMq sysMq);

    /**
     * 新增mq消息记录
     *
     * @param sysMq mq消息记录
     * @return 结果
     */
    public int insertSysMq(SysMq sysMq);

    /**
     * 修改mq消息记录
     *
     * @param sysMq mq消息记录
     * @return 结果
     */
    public int updateSysMq(SysMq sysMq);

    /**
     * 批量删除mq消息记录
     *
     * @param ids 需要删除的mq消息记录主键集合
     * @return 结果
     */
    public int deleteSysMqByIds(String ids);

    /**
     * 删除mq消息记录信息
     *
     * @param id mq消息记录主键
     * @return 结果
     */
    public int deleteSysMqById(Integer id);
}
