package com.ruoyi.web.controller.share;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PrivateMobileManagephone;
import com.ruoyi.system.service.IPrivateMobileManagephoneService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机号码Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@RestController
@RequestMapping("/system/managephone")
public class PrivateMobileManagephoneController extends BaseController
{
    @Autowired
    private IPrivateMobileManagephoneService privateMobileManagephoneService;

    /**
     * 查询手机号码列表
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:list')")
    @GetMapping("/list")
    public TableDataInfo list(PrivateMobileManagephone privateMobileManagephone)
    {
        startPage();
        List<PrivateMobileManagephone> list = privateMobileManagephoneService.selectPrivateMobileManagephoneList(privateMobileManagephone);
        return getDataTable(list);
    }

    /**
     * 导出手机号码列表
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:export')")
    @Log(title = "手机号码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PrivateMobileManagephone privateMobileManagephone)
    {
        List<PrivateMobileManagephone> list = privateMobileManagephoneService.selectPrivateMobileManagephoneList(privateMobileManagephone);
        ExcelUtil<PrivateMobileManagephone> util = new ExcelUtil<PrivateMobileManagephone>(PrivateMobileManagephone.class);
        return util.exportExcel(list, "managephone");
    }

    /**
     * 获取手机号码详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(privateMobileManagephoneService.selectPrivateMobileManagephoneById(id));
    }

    /**
     * 新增手机号码
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:add')")
    @Log(title = "手机号码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PrivateMobileManagephone privateMobileManagephone)
    {
        return toAjax(privateMobileManagephoneService.insertPrivateMobileManagephone(privateMobileManagephone));
    }

    /**
     * 修改手机号码
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:edit')")
    @Log(title = "手机号码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PrivateMobileManagephone privateMobileManagephone)
    {
        return toAjax(privateMobileManagephoneService.updatePrivateMobileManagephone(privateMobileManagephone));
    }

    /**
     * 删除手机号码
     */
    @PreAuthorize("@ss.hasPermi('system:managephone:remove')")
    @Log(title = "手机号码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(privateMobileManagephoneService.deletePrivateMobileManagephoneByIds(ids));
    }
}
