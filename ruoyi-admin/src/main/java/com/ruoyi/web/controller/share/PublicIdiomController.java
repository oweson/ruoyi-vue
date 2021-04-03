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
import com.ruoyi.system.domain.PublicIdiom;
import com.ruoyi.system.service.IPublicIdiomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成语管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/idiom")
public class PublicIdiomController extends BaseController
{
    @Autowired
    private IPublicIdiomService publicIdiomService;

    /**
     * 查询成语管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicIdiom publicIdiom)
    {
        startPage();
        List<PublicIdiom> list = publicIdiomService.selectPublicIdiomList(publicIdiom);
        return getDataTable(list);
    }

    /**
     * 导出成语管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:export')")
    @Log(title = "成语管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicIdiom publicIdiom)
    {
        List<PublicIdiom> list = publicIdiomService.selectPublicIdiomList(publicIdiom);
        ExcelUtil<PublicIdiom> util = new ExcelUtil<PublicIdiom>(PublicIdiom.class);
        return util.exportExcel(list, "idiom");
    }

    /**
     * 获取成语管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(publicIdiomService.selectPublicIdiomById(id));
    }

    /**
     * 新增成语管理
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:add')")
    @Log(title = "成语管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicIdiom publicIdiom)
    {
        return toAjax(publicIdiomService.insertPublicIdiom(publicIdiom));
    }

    /**
     * 修改成语管理
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:edit')")
    @Log(title = "成语管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicIdiom publicIdiom)
    {
        return toAjax(publicIdiomService.updatePublicIdiom(publicIdiom));
    }

    /**
     * 删除成语管理
     */
    @PreAuthorize("@ss.hasPermi('system:idiom:remove')")
    @Log(title = "成语管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(publicIdiomService.deletePublicIdiomByIds(ids));
    }
}
