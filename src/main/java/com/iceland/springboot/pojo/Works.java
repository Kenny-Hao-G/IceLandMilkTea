package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("works")
public class Works {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("kid")
    private Integer kId;
    @TableField("companywith")
    private String companyWith;
    @TableField("details")
    private String details;
    private String post;
}
