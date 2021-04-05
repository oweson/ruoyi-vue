package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PublicSchool;

/**
 * 高校管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IPublicSchoolService 
{
    /**
     * 查询高校管理
     * 
     * @param id 高校管理ID
     * @return 高校管理
     */
    public PublicSchool selectPublicSchoolById(Long id);

    /**
     * 查询高校管理列表
     * 
     * @param publicSchool 高校管理
     * @return 高校管理集合
     */
    public List<PublicSchool> selectPublicSchoolList(PublicSchool publicSchool);

    /**
     * 新增高校管理
     * 
     * @param publicSchool 高校管理
     * @return 结果
     */
    public int insertPublicSchool(PublicSchool publicSchool);

    /**
     * 修改高校管理
     * 
     * @param publicSchool 高校管理
     * @return 结果
     */
    public int updatePublicSchool(PublicSchool publicSchool);

    /**
     * 批量删除高校管理
     * 
     * @param ids 需要删除的高校管理ID
     * @return 结果
     */
    public int deletePublicSchoolByIds(Long[] ids);

    /**
     * 删除高校管理信息
     * 
     * @param id 高校管理ID
     * @return 结果
     */
    public int deletePublicSchoolById(Long id);
}
