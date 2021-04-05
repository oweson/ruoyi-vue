package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicSchoolall;

/**
 * 高校终极版Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IPublicSchoolallService 
{
    /**
     * 查询高校终极版
     * 
     * @param id 高校终极版ID
     * @return 高校终极版
     */
    public PublicSchoolall selectPublicSchoolallById(String id);

    /**
     * 查询高校终极版列表
     * 
     * @param publicSchoolall 高校终极版
     * @return 高校终极版集合
     */
    public List<PublicSchoolall> selectPublicSchoolallList(PublicSchoolall publicSchoolall);

    /**
     * 新增高校终极版
     * 
     * @param publicSchoolall 高校终极版
     * @return 结果
     */
    public int insertPublicSchoolall(PublicSchoolall publicSchoolall);

    /**
     * 修改高校终极版
     * 
     * @param publicSchoolall 高校终极版
     * @return 结果
     */
    public int updatePublicSchoolall(PublicSchoolall publicSchoolall);

    /**
     * 批量删除高校终极版
     * 
     * @param ids 需要删除的高校终极版ID
     * @return 结果
     */
    public int deletePublicSchoolallByIds(String[] ids);

    /**
     * 删除高校终极版信息
     * 
     * @param id 高校终极版ID
     * @return 结果
     */
    public int deletePublicSchoolallById(String id);
}
