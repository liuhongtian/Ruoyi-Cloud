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
import com.ruoyi.lht.domain.Mydemo;
import com.ruoyi.lht.service.IMydemoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 生成样例Controller
 * 
 * @author ruoyi
 * @date 2025-04-28
 */
@RestController
@RequestMapping("/mydemo")
public class MydemoController extends BaseController
{
    @Autowired
    private IMydemoService mydemoService;

    /**
     * 查询生成样例列表
     */
    @RequiresPermissions("lht:mydemo:list")
    @GetMapping("/list")
    public TableDataInfo list(Mydemo mydemo)
    {
        startPage();
        List<Mydemo> list = mydemoService.selectMydemoList(mydemo);
        return getDataTable(list);
    }

    /**
     * 导出生成样例列表
     */
    @RequiresPermissions("lht:mydemo:export")
    @Log(title = "生成样例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Mydemo mydemo)
    {
        List<Mydemo> list = mydemoService.selectMydemoList(mydemo);
        ExcelUtil<Mydemo> util = new ExcelUtil<Mydemo>(Mydemo.class);
        util.exportExcel(response, list, "生成样例数据");
    }

    /**
     * 获取生成样例详细信息
     */
    @RequiresPermissions("lht:mydemo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mydemoService.selectMydemoById(id));
    }

    /**
     * 新增生成样例
     */
    @RequiresPermissions("lht:mydemo:add")
    @Log(title = "生成样例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Mydemo mydemo)
    {
        return toAjax(mydemoService.insertMydemo(mydemo));
    }

    /**
     * 修改生成样例
     */
    @RequiresPermissions("lht:mydemo:edit")
    @Log(title = "生成样例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Mydemo mydemo)
    {
        return toAjax(mydemoService.updateMydemo(mydemo));
    }

    /**
     * 删除生成样例
     */
    @RequiresPermissions("lht:mydemo:remove")
    @Log(title = "生成样例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mydemoService.deleteMydemoByIds(ids));
    }
}
