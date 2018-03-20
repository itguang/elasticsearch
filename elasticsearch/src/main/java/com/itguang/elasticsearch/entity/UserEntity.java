package com.itguang.elasticsearch.entity;

import java.io.Serializable;

/**
 * @author itguang
 * @create 2018-03-20 10:21
 **/



public class UserEntity implements Serializable{

    /**
     * 相当于sql的数据库
     */
    public static final String INDEX_NAME = "index_shop";

    /**
     * 相当于sql的表
     */
    public static final String TYPE = "user";

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    public UserEntity() {
        super();
    }

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
