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
import com.ruoyi.system.domain.PublicBasWord;
import com.ruoyi.system.service.IPublicBasWordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 汉字大全Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/word")
public class PublicBasWordController extends BaseController
{
    @Autowired
    private IPublicBasWordService publicBasWordService;

    /**
     * 查询汉字大全列表
     */
    @PreAuthorize("@ss.hasPermi('system:word:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicBasWord publicBasWord)
    {
        startPage();
        List<PublicBasWord> list = publicBasWordService.selectPublicBasWordList(publicBasWord);
        return getDataTable(list);
    }

    /**
     * 导出汉字大全列表
     */
    @PreAuthorize("@ss.hasPermi('system:word:export')")
    @Log(title = "汉字大全", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicBasWord publicBasWord)
    {
        List<PublicBasWord> list = publicBasWordService.selectPublicBasWordList(publicBasWord);
        ExcelUtil<PublicBasWord> util = new ExcelUtil<PublicBasWord>(PublicBasWord.class);
        return util.exportExcel(list, "word");
    }

    /**
     * 获取汉字大全详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:word:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(publicBasWordService.selectPublicBasWordById(id));
    }

    /**
     * 新增汉字大全
     */
    @PreAuthorize("@ss.hasPermi('system:word:add')")
    @Log(title = "汉字大全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicBasWord publicBasWord)
    {
        return toAjax(publicBasWordService.insertPublicBasWord(publicBasWord));
    }

    /**
     * 修改汉字大全
     */
    @PreAuthorize("@ss.hasPermi('system:word:edit')")
    @Log(title = "汉字大全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicBasWord publicBasWord)
    {
        return toAjax(publicBasWordService.updatePublicBasWord(publicBasWord));
    }

    /**
     * 删除汉字大全
     */
    @PreAuthorize("@ss.hasPermi('system:word:remove')")
    @Log(title = "汉字大全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(publicBasWordService.deletePublicBasWordByIds(ids));
    }
}
