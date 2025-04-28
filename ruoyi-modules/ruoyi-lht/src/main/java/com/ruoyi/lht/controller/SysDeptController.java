package com.ruoyi.lht.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.lht.domain.SysDept;
import com.ruoyi.lht.service.ISysDeptService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 部门Controller
 * 
 * @author ruoyi
 * @date 2025-04-27
 */
@RestController
@RequestMapping("/ldept")
public class SysDeptController extends BaseController
{

    public SysDeptController(){
        super();
        System.out.println("SysDeptController inited!");
    }
    
    @Autowired
    private ISysDeptService sysDeptService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    /**
     * 查询部门列表
     */
    @RequiresPermissions("lht:dept:list")
    @GetMapping("/list")
    public TableDataInfo list(SysDept sysDept)
    {
        System.out.println("查询部门列表");
        startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @RequiresPermissions("lht:dept:export")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDept sysDept)
    {
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        util.exportExcel(response, list, "部门数据");
    }

    /**
     * 获取部门详细信息
     */
    @RequiresPermissions("lht:dept:query")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return success(sysDeptService.selectSysDeptByDeptId(deptId));
    }

    /**
     * 新增部门
     */
    @RequiresPermissions("lht:dept:add")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.insertSysDept(sysDept));
    }

    /**
     * 修改部门
     */
    @RequiresPermissions("lht:dept:edit")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.updateSysDept(sysDept));
    }

    /**
     * 删除部门
     */
    @RequiresPermissions("lht:dept:remove")
    @Log(title = "部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(sysDeptService.deleteSysDeptByDeptIds(deptIds));
    }
}
