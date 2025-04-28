package com.ruoyi.lht.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lht.mapper.MydemoMapper;
import com.ruoyi.lht.domain.Mydemo;
import com.ruoyi.lht.service.IMydemoService;

/**
 * 生成样例Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-28
 */
@Service
public class MydemoServiceImpl implements IMydemoService 
{
    @Autowired
    private MydemoMapper mydemoMapper;

    /**
     * 查询生成样例
     * 
     * @param id 生成样例主键
     * @return 生成样例
     */
    @Override
    public Mydemo selectMydemoById(Long id)
    {
        return mydemoMapper.selectMydemoById(id);
    }

    /**
     * 查询生成样例列表
     * 
     * @param mydemo 生成样例
     * @return 生成样例
     */
    @Override
    public List<Mydemo> selectMydemoList(Mydemo mydemo)
    {
        return mydemoMapper.selectMydemoList(mydemo);
    }

    /**
     * 新增生成样例
     * 
     * @param mydemo 生成样例
     * @return 结果
     */
    @Override
    public int insertMydemo(Mydemo mydemo)
    {
        return mydemoMapper.insertMydemo(mydemo);
    }

    /**
     * 修改生成样例
     * 
     * @param mydemo 生成样例
     * @return 结果
     */
    @Override
    public int updateMydemo(Mydemo mydemo)
    {
        return mydemoMapper.updateMydemo(mydemo);
    }

    /**
     * 批量删除生成样例
     * 
     * @param ids 需要删除的生成样例主键
     * @return 结果
     */
    @Override
    public int deleteMydemoByIds(Long[] ids)
    {
        return mydemoMapper.deleteMydemoByIds(ids);
    }

    /**
     * 删除生成样例信息
     * 
     * @param id 生成样例主键
     * @return 结果
     */
    @Override
    public int deleteMydemoById(Long id)
    {
        return mydemoMapper.deleteMydemoById(id);
    }
}
