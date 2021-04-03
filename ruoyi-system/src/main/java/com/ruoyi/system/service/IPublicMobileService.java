package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicMobile;

/**
 * 码段归属Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IPublicMobileService 
{
    /**
     * 查询码段归属
     * 
     * @param id 码段归属ID
     * @return 码段归属
     */
    public PublicMobile selectPublicMobileById(Integer id);

    /**
     * 查询码段归属列表
     * 
     * @param publicMobile 码段归属
     * @return 码段归属集合
     */
    public List<PublicMobile> selectPublicMobileList(PublicMobile publicMobile);

    /**
     * 新增码段归属
     * 
     * @param publicMobile 码段归属
     * @return 结果
     */
    public int insertPublicMobile(PublicMobile publicMobile);

    /**
     * 修改码段归属
     * 
     * @param publicMobile 码段归属
     * @return 结果
     */
    public int updatePublicMobile(PublicMobile publicMobile);

    /**
     * 批量删除码段归属
     * 
     * @param ids 需要删除的码段归属ID
     * @return 结果
     */
    public int deletePublicMobileByIds(Integer[] ids);

    /**
     * 删除码段归属信息
     * 
     * @param id 码段归属ID
     * @return 结果
     */
    public int deletePublicMobileById(Integer id);
}
