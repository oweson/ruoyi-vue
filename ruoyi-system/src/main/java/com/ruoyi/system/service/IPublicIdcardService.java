package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicIdcard;

/**
 * 身份归属Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IPublicIdcardService 
{
    /**
     * 查询身份归属
     * 
     * @param fCode 身份归属ID
     * @return 身份归属
     */
    public PublicIdcard selectPublicIdcardById(Integer fCode);

    /**
     * 查询身份归属列表
     * 
     * @param publicIdcard 身份归属
     * @return 身份归属集合
     */
    public List<PublicIdcard> selectPublicIdcardList(PublicIdcard publicIdcard);

    /**
     * 新增身份归属
     * 
     * @param publicIdcard 身份归属
     * @return 结果
     */
    public int insertPublicIdcard(PublicIdcard publicIdcard);

    /**
     * 修改身份归属
     * 
     * @param publicIdcard 身份归属
     * @return 结果
     */
    public int updatePublicIdcard(PublicIdcard publicIdcard);

    /**
     * 批量删除身份归属
     * 
     * @param fCodes 需要删除的身份归属ID
     * @return 结果
     */
    public int deletePublicIdcardByIds(Integer[] fCodes);

    /**
     * 删除身份归属信息
     * 
     * @param fCode 身份归属ID
     * @return 结果
     */
    public int deletePublicIdcardById(Integer fCode);
}
