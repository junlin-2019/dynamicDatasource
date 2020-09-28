package com.example.service.impl;

import com.example.dao.TAddrDao;
import com.example.entity.TAddr;
import com.example.service.TAddrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAddr)表服务实现类
 *
 * @author makejava
 * @since 2020-09-28 18:29:12
 */
@Service("tAddrService")
public class TAddrServiceImpl implements TAddrService {
    @Resource
    private TAddrDao tAddrDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TAddr queryById(Integer id) {
        return this.tAddrDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TAddr> queryAllByLimit(int offset, int limit) {
        return this.tAddrDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tAddr 实例对象
     * @return 实例对象
     */
    @Override
    public TAddr insert(TAddr tAddr) {
        this.tAddrDao.insert(tAddr);
        return tAddr;
    }

    /**
     * 修改数据
     *
     * @param tAddr 实例对象
     * @return 实例对象
     */
    @Override
    public TAddr update(TAddr tAddr) {
        this.tAddrDao.update(tAddr);
        return this.queryById(tAddr.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tAddrDao.deleteById(id) > 0;
    }
}