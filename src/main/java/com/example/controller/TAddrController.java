package com.example.controller;

import com.example.entity.TAddr;
import com.example.service.TAddrService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TAddr)表控制层
 *
 * @author makejava
 * @since 2020-09-28 18:29:12
 */
@RestController
@RequestMapping("tAddr")
public class TAddrController {
    /**
     * 服务对象
     */
    @Resource
    private TAddrService tAddrService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TAddr selectOne(Integer id) {
        return this.tAddrService.queryById(id);
    }

}