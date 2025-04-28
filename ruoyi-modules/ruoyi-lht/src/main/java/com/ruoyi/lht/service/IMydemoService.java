package com.ruoyi.lht.service;

import java.util.List;
import com.ruoyi.lht.domain.Mydemo;

/**
 * 生成样例Service接口
 * 
 * @author ruoyi
 * @date 2025-04-28
 */
public interface IMydemoService 
{
    /**
     * 查询生成样例
     * 
     * @param id 生成样例主键
     * @return 生成样例
     */
    public Mydemo selectMydemoById(Long id);

    /**
     * 查询生成样例列表
     * 
     * @param mydemo 生成样例
     * @return 生成样例集合
     */
    public List<Mydemo> selectMydemoList(Mydemo mydemo);

    /**
     * 新增生成样例
     * 
     * @param mydemo 生成样例
     * @return 结果
     */
    public int insertMydemo(Mydemo mydemo);

    /**
     * 修改生成样例
     * 
     * @param mydemo 生成样例
     * @return 结果
     */
    public int updateMydemo(Mydemo mydemo);

    /**
     * 批量删除生成样例
     * 
     * @param ids 需要删除的生成样例主键集合
     * @return 结果
     */
    public int deleteMydemoByIds(Long[] ids);

    /**
     * 删除生成样例信息
     * 
     * @param id 生成样例主键
     * @return 结果
     */
    public int deleteMydemoById(Long id);
}
