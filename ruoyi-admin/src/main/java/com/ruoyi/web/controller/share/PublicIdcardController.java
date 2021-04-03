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
import com.ruoyi.system.domain.PublicIdcard;
import com.ruoyi.system.service.IPublicIdcardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 身份归属Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/idcard")
public class PublicIdcardController extends BaseController
{
    @Autowired
    private IPublicIdcardService publicIdcardService;

    /**
     * 查询身份归属列表
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicIdcard publicIdcard)
    {
        startPage();
        List<PublicIdcard> list = publicIdcardService.selectPublicIdcardList(publicIdcard);
        return getDataTable(list);
    }

    /**
     * 导出身份归属列表
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:export')")
    @Log(title = "身份归属", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicIdcard publicIdcard)
    {
        List<PublicIdcard> list = publicIdcardService.selectPublicIdcardList(publicIdcard);
        ExcelUtil<PublicIdcard> util = new ExcelUtil<PublicIdcard>(PublicIdcard.class);
        return util.exportExcel(list, "idcard");
    }

    /**
     * 获取身份归属详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:query')")
    @GetMapping(value = "/{fCode}")
    public AjaxResult getInfo(@PathVariable("fCode") Integer fCode)
    {
        return AjaxResult.success(publicIdcardService.selectPublicIdcardById(fCode));
    }

    /**
     * 新增身份归属
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:add')")
    @Log(title = "身份归属", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicIdcard publicIdcard)
    {
        return toAjax(publicIdcardService.insertPublicIdcard(publicIdcard));
    }

    /**
     * 修改身份归属
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:edit')")
    @Log(title = "身份归属", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicIdcard publicIdcard)
    {
        return toAjax(publicIdcardService.updatePublicIdcard(publicIdcard));
    }

    /**
     * 删除身份归属
     */
    @PreAuthorize("@ss.hasPermi('system:idcard:remove')")
    @Log(title = "身份归属", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fCodes}")
    public AjaxResult remove(@PathVariable Integer[] fCodes)
    {
        return toAjax(publicIdcardService.deletePublicIdcardByIds(fCodes));
    }
}
