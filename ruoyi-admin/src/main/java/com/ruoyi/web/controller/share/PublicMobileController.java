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
import com.ruoyi.system.domain.PublicMobile;
import com.ruoyi.system.service.IPublicMobileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 码段归属Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/mobile")
public class PublicMobileController extends BaseController
{
    @Autowired
    private IPublicMobileService publicMobileService;

    /**
     * 查询码段归属列表
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicMobile publicMobile)
    {
        startPage();
        List<PublicMobile> list = publicMobileService.selectPublicMobileList(publicMobile);
        return getDataTable(list);
    }

    /**
     * 导出码段归属列表
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:export')")
    @Log(title = "码段归属", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicMobile publicMobile)
    {
        List<PublicMobile> list = publicMobileService.selectPublicMobileList(publicMobile);
        ExcelUtil<PublicMobile> util = new ExcelUtil<PublicMobile>(PublicMobile.class);
        return util.exportExcel(list, "mobile");
    }

    /**
     * 获取码段归属详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(publicMobileService.selectPublicMobileById(id));
    }

    /**
     * 新增码段归属
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:add')")
    @Log(title = "码段归属", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicMobile publicMobile)
    {
        return toAjax(publicMobileService.insertPublicMobile(publicMobile));
    }

    /**
     * 修改码段归属
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:edit')")
    @Log(title = "码段归属", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicMobile publicMobile)
    {
        return toAjax(publicMobileService.updatePublicMobile(publicMobile));
    }

    /**
     * 删除码段归属
     */
    @PreAuthorize("@ss.hasPermi('system:mobile:remove')")
    @Log(title = "码段归属", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(publicMobileService.deletePublicMobileByIds(ids));
    }
}
