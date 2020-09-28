package com.example.dao;

import com.example.annotation.DataSource;
import com.example.entity.TAddr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TAddr)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-28 18:29:11
 */
public interface TAddrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @DataSource("dataSource02")
    TAddr queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TAddr> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAddr 实例对象
     * @return 对象列表
     */
    List<TAddr> queryAll(TAddr tAddr);

    /**
     * 新增数据
     *
     * @param tAddr 实例对象
     * @return 影响行数
     */
    int insert(TAddr tAddr);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAddr> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAddr> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAddr> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TAddr> entities);

    /**
     * 修改数据
     *
     * @param tAddr 实例对象
     * @return 影响行数
     */
    int update(TAddr tAddr);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}