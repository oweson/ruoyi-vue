package com.ruoyi.web.controller.tool;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
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
import com.ruoyi.system.domain.SysTomcat;
import com.ruoyi.system.service.ISysTomcatService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 测试Controller
 * 
 * @author ruoyi
 * @date 2021-01-27
 */
@RestController
@RequestMapping("/system/tomcat")
public class SysTomcatController extends BaseController
{
    @Autowired
    private ISysTomcatService sysTomcatService;
    @Autowired
    private TokenService tokenService;
    @Log(title = "测试导入", businessType = BusinessType.IMPORT)
    //@PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysTomcat> util = new ExcelUtil<SysTomcat>(SysTomcat.class);
        List<SysTomcat> userList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        //String message = userService.importUser(userList, updateSupport, operName);
//        return AjaxResult.success(message);
        return AjaxResult.success(null);


    }
    /**
     * 导出模版
     * @return
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysTomcat> util = new ExcelUtil<SysTomcat>(SysTomcat.class);
        return util.importTemplateExcel("用户数据");
    }


    /**
     * 查询测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTomcat sysTomcat)
    {
        startPage();
        List<SysTomcat> list = sysTomcatService.selectSysTomcatList(sysTomcat);
        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:export')")
    @Log(title = "测试", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysTomcat sysTomcat)
    {
        List<SysTomcat> list = sysTomcatService.selectSysTomcatList(sysTomcat);
        ExcelUtil<SysTomcat> util = new ExcelUtil<SysTomcat>(SysTomcat.class);
        return util.exportExcel(list, "tomcat");
    }

    /**
     * 获取测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(sysTomcatService.selectSysTomcatById(id));
    }

    /**
     * 新增测试
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:add')")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTomcat sysTomcat)
    {
        return toAjax(sysTomcatService.insertSysTomcat(sysTomcat));
    }

    /**
     * 修改测试
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:edit')")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTomcat sysTomcat)
    {
        return toAjax(sysTomcatService.updateSysTomcat(sysTomcat));
    }

    /**
     * 删除测试
     */
    @PreAuthorize("@ss.hasPermi('system:tomcat:remove')")
    @Log(title = "测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(sysTomcatService.deleteSysTomcatByIds(ids));
    }
}
