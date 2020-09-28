package com.example.service;

import com.example.entity.TAddr;

import java.util.List;

/**
 * (TAddr)表服务接口
 *
 * @author makejava
 * @since 2020-09-28 18:29:12
 */
public interface TAddrService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAddr queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TAddr> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tAddr 实例对象
     * @return 实例对象
     */
    TAddr insert(TAddr tAddr);

    /**
     * 修改数据
     *
     * @param tAddr 实例对象
     * @return 实例对象
     */
    TAddr update(TAddr tAddr);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}