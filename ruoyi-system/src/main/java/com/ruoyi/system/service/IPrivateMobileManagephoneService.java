package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PrivateMobileManagephone;

/**
 * 手机号码Service接口
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
public interface IPrivateMobileManagephoneService 
{
    /**
     * 查询手机号码
     * 
     * @param id 手机号码ID
     * @return 手机号码
     */
    public PrivateMobileManagephone selectPrivateMobileManagephoneById(Integer id);

    /**
     * 查询手机号码列表
     * 
     * @param privateMobileManagephone 手机号码
     * @return 手机号码集合
     */
    public List<PrivateMobileManagephone> selectPrivateMobileManagephoneList(PrivateMobileManagephone privateMobileManagephone);

    /**
     * 新增手机号码
     * 
     * @param privateMobileManagephone 手机号码
     * @return 结果
     */
    public int insertPrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone);

    /**
     * 修改手机号码
     * 
     * @param privateMobileManagephone 手机号码
     * @return 结果
     */
    public int updatePrivateMobileManagephone(PrivateMobileManagephone privateMobileManagephone);

    /**
     * 批量删除手机号码
     * 
     * @param ids 需要删除的手机号码ID
     * @return 结果
     */
    public int deletePrivateMobileManagephoneByIds(Integer[] ids);

    /**
     * 删除手机号码信息
     * 
     * @param id 手机号码ID
     * @return 结果
     */
    public int deletePrivateMobileManagephoneById(Integer id);
}
