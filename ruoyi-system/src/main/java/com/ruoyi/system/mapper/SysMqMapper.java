package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.SysMq;

import java.util.List;

/**
 * mq消息记录Mapper接口
 *
 * @author oweson
 * @date 2022-09-04
 */
public interface SysMqMapper
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
     * 删除mq消息记录
     *
     * @param id mq消息记录主键
     * @return 结果
     */
    public int deleteSysMqById(Integer id);

    /**
     * 批量删除mq消息记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMqByIds(String[] ids);
}
