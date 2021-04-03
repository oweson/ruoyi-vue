package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PublicIdcard;

/**
 * 身份归属Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface PublicIdcardMapper 
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
     * 删除身份归属
     * 
     * @param fCode 身份归属ID
     * @return 结果
     */
    public int deletePublicIdcardById(Integer fCode);

    /**
     * 批量删除身份归属
     * 
     * @param fCodes 需要删除的数据ID
     * @return 结果
     */
    public int deletePublicIdcardByIds(Integer[] fCodes);
}
