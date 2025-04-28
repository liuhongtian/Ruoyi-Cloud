package com.ruoyi.lht.mapper;

import java.util.List;
import com.ruoyi.lht.domain.SysDept;

/**
 * 部门Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-27
 */
public interface SysDeptMapper 
{
    /**
     * 查询部门
     * 
     * @param deptId 部门主键
     * @return 部门
     */
    public SysDept selectSysDeptByDeptId(Long deptId);

    /**
     * 查询部门列表
     * 
     * @param sysDept 部门
     * @return 部门集合
     */
    public List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 新增部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    public int insertSysDept(SysDept sysDept);

    /**
     * 修改部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    public int updateSysDept(SysDept sysDept);

    /**
     * 删除部门
     * 
     * @param deptId 部门主键
     * @return 结果
     */
    public int deleteSysDeptByDeptId(Long deptId);

    /**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDeptByDeptIds(Long[] deptIds);
}
