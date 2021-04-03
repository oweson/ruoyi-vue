package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PublicBabystudent;

/**
 * baby名字Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface PublicBabystudentMapper 
{
    /**
     * 查询baby名字
     * 
     * @param id baby名字ID
     * @return baby名字
     */
    public PublicBabystudent selectPublicBabystudentById(String id);

    /**
     * 查询baby名字列表
     * 
     * @param publicBabystudent baby名字
     * @return baby名字集合
     */
    public List<PublicBabystudent> selectPublicBabystudentList(PublicBabystudent publicBabystudent);

    /**
     * 新增baby名字
     * 
     * @param publicBabystudent baby名字
     * @return 结果
     */
    public int insertPublicBabystudent(PublicBabystudent publicBabystudent);

    /**
     * 修改baby名字
     * 
     * @param publicBabystudent baby名字
     * @return 结果
     */
    public int updatePublicBabystudent(PublicBabystudent publicBabystudent);

    /**
     * 删除baby名字
     * 
     * @param id baby名字ID
     * @return 结果
     */
    public int deletePublicBabystudentById(String id);

    /**
     * 批量删除baby名字
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePublicBabystudentByIds(String[] ids);
}
