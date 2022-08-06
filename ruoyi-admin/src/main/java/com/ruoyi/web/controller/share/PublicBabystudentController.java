package com.ruoyi.web.controller.share;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.PublicBabystudent;
import com.ruoyi.system.service.IPublicBabystudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * baby名字Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/system/babystudent")
public class PublicBabystudentController extends BaseController
{
    @Autowired
    private IPublicBabystudentService publicBabystudentService;

    /**
     * 查询baby名字列表
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:list')")
    @GetMapping("/list")
    public TableDataInfo list(PublicBabystudent publicBabystudent)
    {
        HttpServletRequest request = ServletUtils.getRequest();
        String appDevice = request.getHeader("app_device");
        startPage();
        List<PublicBabystudent> list = publicBabystudentService.selectPublicBabystudentList(publicBabystudent);
        return getDataTable(list);
    }

    /**
     * 导出baby名字列表
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:export')")
    @Log(title = "baby名字", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PublicBabystudent publicBabystudent)
    {
        List<PublicBabystudent> list = publicBabystudentService.selectPublicBabystudentList(publicBabystudent);
        ExcelUtil<PublicBabystudent> util = new ExcelUtil<PublicBabystudent>(PublicBabystudent.class);
        return util.exportExcel(list, "babystudent");
    }

    /**
     * 获取baby名字详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(publicBabystudentService.selectPublicBabystudentById(id));
    }

    /**
     * 新增baby名字
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:add')")
    @Log(title = "baby名字", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PublicBabystudent publicBabystudent)
    {
        return toAjax(publicBabystudentService.insertPublicBabystudent(publicBabystudent));
    }

    /**
     * 修改baby名字
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:edit')")
    @Log(title = "baby名字", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PublicBabystudent publicBabystudent)
    {
        return toAjax(publicBabystudentService.updatePublicBabystudent(publicBabystudent));
    }

    /**
     * 删除baby名字
     */
    @PreAuthorize("@ss.hasPermi('system:babystudent:remove')")
    @Log(title = "baby名字", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(publicBabystudentService.deletePublicBabystudentByIds(ids));
    }
}
