package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("work_chance")
public class WorkChance {
    @TableId(type = IdType.AUTO)
    private int id;
    private String kind;
    private String img;
}
