package com.ggs.event.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhh
 * @since 2024-07-08
 */
@Data
@TableName("s_car_complain")
public class CarComplain implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long code;

    private LocalDate date;

    private String pinpai;

    private String chexi;

    private String problemClass;

    /**
     * 删除标记, 1:已删除 0:未删除
     */
    private boolean deleteFlag;

    @Version
    private int version;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

}
