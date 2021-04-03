package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicIdiom;

/**
 * 成语管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IPublicIdiomService 
{
    /**
     * 查询成语管理
     * 
     * @param id 成语管理ID
     * @return 成语管理
     */
    public PublicIdiom selectPublicIdiomById(Long id);

    /**
     * 查询成语管理列表
     * 
     * @param publicIdiom 成语管理
     * @return 成语管理集合
     */
    public List<PublicIdiom> selectPublicIdiomList(PublicIdiom publicIdiom);

    /**
     * 新增成语管理
     * 
     * @param publicIdiom 成语管理
     * @return 结果
     */
    public int insertPublicIdiom(PublicIdiom publicIdiom);

    /**
     * 修改成语管理
     * 
     * @param publicIdiom 成语管理
     * @return 结果
     */
    public int updatePublicIdiom(PublicIdiom publicIdiom);

    /**
     * 批量删除成语管理
     * 
     * @param ids 需要删除的成语管理ID
     * @return 结果
     */
    public int deletePublicIdiomByIds(Long[] ids);

    /**
     * 删除成语管理信息
     * 
     * @param id 成语管理ID
     * @return 结果
     */
    public int deletePublicIdiomById(Long id);
}
