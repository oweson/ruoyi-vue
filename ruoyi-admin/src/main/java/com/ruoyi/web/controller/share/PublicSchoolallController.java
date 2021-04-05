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
import com.ruoyi.system.domain.PublicSchoolall;
import com.ruoyi.system.service.IPublicSchoolallService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 高校终极版Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@RestController
@RequestMapping("/system/schoolall")
public class PublicSchoolallController extends BaseController
{
    @Autowired
    private IPublicSchoolallService publicSchoolallService;

    /**
     * 查询高校终极版列表
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicSchoolall publicSchoolall)
    {
        startPage();
        List<PublicSchoolall> list = publicSchoolallService.selectPublicSchoolallList(publicSchoolall);
        return getDataTable(list);
    }

    /**
     * 导出高校终极版列表
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:export')")
    @Log(title = "高校终极版", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicSchoolall publicSchoolall)
    {
        List<PublicSchoolall> list = publicSchoolallService.selectPublicSchoolallList(publicSchoolall);
        ExcelUtil<PublicSchoolall> util = new ExcelUtil<PublicSchoolall>(PublicSchoolall.class);
        return util.exportExcel(list, "schoolall");
    }

    /**
     * 获取高校终极版详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(publicSchoolallService.selectPublicSchoolallById(id));
    }

    /**
     * 新增高校终极版
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:add')")
    @Log(title = "高校终极版", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicSchoolall publicSchoolall)
    {
        return toAjax(publicSchoolallService.insertPublicSchoolall(publicSchoolall));
    }

    /**
     * 修改高校终极版
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:edit')")
    @Log(title = "高校终极版", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicSchoolall publicSchoolall)
    {
        return toAjax(publicSchoolallService.updatePublicSchoolall(publicSchoolall));
    }

    /**
     * 删除高校终极版
     */
    @PreAuthorize("@ss.hasPermi('system:schoolall:remove')")
    @Log(title = "高校终极版", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(publicSchoolallService.deletePublicSchoolallByIds(ids));
    }
}
