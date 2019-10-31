package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("star_room")
public class StarClass {
    @TableId(type = IdType.AUTO)
    private int id;
    private String details;
    private String paragraph;
    private String imgurl;
    private String classify;
}
