package com.ruoyi.web.controller.share;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysCustomer;
import com.ruoyi.system.service.ISysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户Controller
 *
 * @author oweson
 * @date 2022-11-24
 */
@RestController
@RequestMapping("/system/customer")
public class SysCustomerController extends BaseController
{
    @Autowired
    private ISysCustomerService sysCustomerService;

    /**
     * 查询客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCustomer sysCustomer)
    {
        startPage();
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCustomer sysCustomer)
    {
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        ExcelUtil<SysCustomer> util = new ExcelUtil<SysCustomer>(SysCustomer.class);
        util.exportExcel(response, list, "客户数据");
    }

    /**
     * 获取客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Long customerId)
    {
        return success(sysCustomerService.selectSysCustomerByCustomerId(customerId));
    }

    /**
     * 新增客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCustomer sysCustomer)
    {
        return toAjax(sysCustomerService.insertSysCustomer(sysCustomer));
    }

    /**
     * 修改客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCustomer sysCustomer)
    {
        return toAjax(sysCustomerService.updateSysCustomer(sysCustomer));
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Long[] customerIds)
    {
        return toAjax(sysCustomerService.deleteSysCustomerByCustomerIds(customerIds));
    }
}
