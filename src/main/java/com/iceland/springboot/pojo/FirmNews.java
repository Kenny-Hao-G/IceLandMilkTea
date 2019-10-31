package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("firm_news")
public class FirmNews {
    @TableId(type = IdType.AUTO)
    private int id;
    private String news;
    private String details;
    private String imgurl;
}
