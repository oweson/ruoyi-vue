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
import com.ruoyi.system.domain.PublicEnglishwords;
import com.ruoyi.system.service.IPublicEnglishwordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单词管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/englishwords")
public class PublicEnglishwordsController extends BaseController
{
    @Autowired
    private IPublicEnglishwordsService publicEnglishwordsService;

    /**
     * 查询单词管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicEnglishwords publicEnglishwords)
    {
        startPage();
        List<PublicEnglishwords> list = publicEnglishwordsService.selectPublicEnglishwordsList(publicEnglishwords);
        return getDataTable(list);
    }

    /**
     * 导出单词管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:export')")
    @Log(title = "单词管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicEnglishwords publicEnglishwords)
    {
        List<PublicEnglishwords> list = publicEnglishwordsService.selectPublicEnglishwordsList(publicEnglishwords);
        ExcelUtil<PublicEnglishwords> util = new ExcelUtil<PublicEnglishwords>(PublicEnglishwords.class);
        return util.exportExcel(list, "englishwords");
    }

    /**
     * 获取单词管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(publicEnglishwordsService.selectPublicEnglishwordsById(id));
    }

    /**
     * 新增单词管理
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:add')")
    @Log(title = "单词管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicEnglishwords publicEnglishwords)
    {
        return toAjax(publicEnglishwordsService.insertPublicEnglishwords(publicEnglishwords));
    }

    /**
     * 修改单词管理
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:edit')")
    @Log(title = "单词管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicEnglishwords publicEnglishwords)
    {
        return toAjax(publicEnglishwordsService.updatePublicEnglishwords(publicEnglishwords));
    }

    /**
     * 删除单词管理
     */
    @PreAuthorize("@ss.hasPermi('system:englishwords:remove')")
    @Log(title = "单词管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(publicEnglishwordsService.deletePublicEnglishwordsByIds(ids));
    }
}
