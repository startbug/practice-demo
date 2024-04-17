package com.ggs.event.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author lhh
 * @since 2024-04-17
 */
@Data
@TableName("s_file")
public class File implements Serializable {

    @TableId
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    private String name;

    private String type;

    private Long size;

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
