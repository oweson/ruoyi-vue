package com.ruoyi.web.controller.share;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Industry;
import com.ruoyi.system.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 行业Controller
 *
 * @author oweson
 * @date 2022-11-30
 */
@RestController
@RequestMapping("/system/industry")
public class IndustryController extends BaseController
{
    @Autowired
    private IIndustryService industryService;

    /**
     * 查询行业列表
     */
    @PreAuthorize("@ss.hasPermi('system:industry:list')")
    @GetMapping("/list")
    public AjaxResult list(Industry industry)
    {
        List<Industry> list = industryService.selectIndustryList(industry);
        return success(list);
    }

    /**
     * 导出行业列表
     */
    @PreAuthorize("@ss.hasPermi('system:industry:export')")
    @Log(title = "行业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Industry industry)
    {
        List<Industry> list = industryService.selectIndustryList(industry);
        ExcelUtil<Industry> util = new ExcelUtil<Industry>(Industry.class);
        util.exportExcel(response, list, "行业数据");
    }

    /**
     * 获取行业详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:industry:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") String code)
    {
        return success(industryService.selectIndustryByCode(code));
    }

    /**
     * 新增行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:add')")
    @Log(title = "行业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Industry industry)
    {
        return toAjax(industryService.insertIndustry(industry));
    }

    /**
     * 修改行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:edit')")
    @Log(title = "行业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Industry industry)
    {
        return toAjax(industryService.updateIndustry(industry));
    }

    /**
     * 删除行业
     */
    @PreAuthorize("@ss.hasPermi('system:industry:remove')")
    @Log(title = "行业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable String[] codes)
    {
        return toAjax(industryService.deleteIndustryByCodes(codes));
    }
}
