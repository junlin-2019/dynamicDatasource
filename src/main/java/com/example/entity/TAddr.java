package com.example.entity;

import java.io.Serializable;

/**
 * (TAddr)实体类
 *
 * @author makejava
 * @since 2020-09-28 18:29:11
 */
public class TAddr implements Serializable {
    private static final long serialVersionUID = -56133674977544345L;

    private Integer id;

    private String addr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}