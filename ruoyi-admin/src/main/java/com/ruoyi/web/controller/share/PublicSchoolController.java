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
import com.ruoyi.system.domain.PublicSchool;
import com.ruoyi.system.service.IPublicSchoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 高校管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-05
 */
@RestController
@RequestMapping("/system/school")
public class PublicSchoolController extends BaseController
{
    @Autowired
    private IPublicSchoolService publicSchoolService;

    /**
     * 查询高校管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicSchool publicSchool)
    {
        startPage();
        List<PublicSchool> list = publicSchoolService.selectPublicSchoolList(publicSchool);
        return getDataTable(list);
    }

    /**
     * 导出高校管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:school:export')")
    @Log(title = "高校管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicSchool publicSchool)
    {
        List<PublicSchool> list = publicSchoolService.selectPublicSchoolList(publicSchool);
        ExcelUtil<PublicSchool> util = new ExcelUtil<PublicSchool>(PublicSchool.class);
        return util.exportExcel(list, "school");
    }

    /**
     * 获取高校管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(publicSchoolService.selectPublicSchoolById(id));
    }

    /**
     * 新增高校管理
     */
    @PreAuthorize("@ss.hasPermi('system:school:add')")
    @Log(title = "高校管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicSchool publicSchool)
    {
        return toAjax(publicSchoolService.insertPublicSchool(publicSchool));
    }

    /**
     * 修改高校管理
     */
    @PreAuthorize("@ss.hasPermi('system:school:edit')")
    @Log(title = "高校管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicSchool publicSchool)
    {
        return toAjax(publicSchoolService.updatePublicSchool(publicSchool));
    }

    /**
     * 删除高校管理
     */
    @PreAuthorize("@ss.hasPermi('system:school:remove')")
    @Log(title = "高校管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(publicSchoolService.deletePublicSchoolByIds(ids));
    }
}
