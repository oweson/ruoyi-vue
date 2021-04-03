package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PublicBasWord;

/**
 * 汉字大全Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface PublicBasWordMapper 
{
    /**
     * 查询汉字大全
     * 
     * @param id 汉字大全ID
     * @return 汉字大全
     */
    public PublicBasWord selectPublicBasWordById(Long id);

    /**
     * 查询汉字大全列表
     * 
     * @param publicBasWord 汉字大全
     * @return 汉字大全集合
     */
    public List<PublicBasWord> selectPublicBasWordList(PublicBasWord publicBasWord);

    /**
     * 新增汉字大全
     * 
     * @param publicBasWord 汉字大全
     * @return 结果
     */
    public int insertPublicBasWord(PublicBasWord publicBasWord);

    /**
     * 修改汉字大全
     * 
     * @param publicBasWord 汉字大全
     * @return 结果
     */
    public int updatePublicBasWord(PublicBasWord publicBasWord);

    /**
     * 删除汉字大全
     * 
     * @param id 汉字大全ID
     * @return 结果
     */
    public int deletePublicBasWordById(Long id);

    /**
     * 批量删除汉字大全
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePublicBasWordByIds(Long[] ids);
}
