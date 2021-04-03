package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PublicMobile;

/**
 * 码段归属地Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-02
 */
public interface PublicMobileMapper 
{
    /**
     * 查询码段归属地
     * 
     * @param id 码段归属地ID
     * @return 码段归属地
     */
    public PublicMobile selectPublicMobileById(Integer id);

    /**
     * 查询码段归属地列表
     * 
     * @param publicMobile 码段归属地
     * @return 码段归属地集合
     */
    public List<PublicMobile> selectPublicMobileList(PublicMobile publicMobile);

    /**
     * 新增码段归属地
     * 
     * @param publicMobile 码段归属地
     * @return 结果
     */
    public int insertPublicMobile(PublicMobile publicMobile);

    /**
     * 修改码段归属地
     * 
     * @param publicMobile 码段归属地
     * @return 结果
     */
    public int updatePublicMobile(PublicMobile publicMobile);

    /**
     * 删除码段归属地
     * 
     * @param id 码段归属地ID
     * @return 结果
     */
    public int deletePublicMobileById(Integer id);

    /**
     * 批量删除码段归属地
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePublicMobileByIds(Integer[] ids);
}
