package com.ggs.es.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Product {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "`name`")
    private String name;
    @TableField(value = "`desc`")
    private String desc;
    private double price;
    private String tags;
    private Timestamp createtime;
}
