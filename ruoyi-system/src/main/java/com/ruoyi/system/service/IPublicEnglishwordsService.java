package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicEnglishwords;

/**
 * 单词管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IPublicEnglishwordsService 
{
    /**
     * 查询单词管理
     * 
     * @param id 单词管理ID
     * @return 单词管理
     */
    public PublicEnglishwords selectPublicEnglishwordsById(Integer id);

    /**
     * 查询单词管理列表
     * 
     * @param publicEnglishwords 单词管理
     * @return 单词管理集合
     */
    public List<PublicEnglishwords> selectPublicEnglishwordsList(PublicEnglishwords publicEnglishwords);

    /**
     * 新增单词管理
     * 
     * @param publicEnglishwords 单词管理
     * @return 结果
     */
    public int insertPublicEnglishwords(PublicEnglishwords publicEnglishwords);

    /**
     * 修改单词管理
     * 
     * @param publicEnglishwords 单词管理
     * @return 结果
     */
    public int updatePublicEnglishwords(PublicEnglishwords publicEnglishwords);

    /**
     * 批量删除单词管理
     * 
     * @param ids 需要删除的单词管理ID
     * @return 结果
     */
    public int deletePublicEnglishwordsByIds(Integer[] ids);

    /**
     * 删除单词管理信息
     * 
     * @param id 单词管理ID
     * @return 结果
     */
    public int deletePublicEnglishwordsById(Integer id);
}
