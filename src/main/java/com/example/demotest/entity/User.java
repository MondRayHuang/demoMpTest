package com.example.demotest.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//create_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//update_time

    //乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    private Integer deleted;
}
