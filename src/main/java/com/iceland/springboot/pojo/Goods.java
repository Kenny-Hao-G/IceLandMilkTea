package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("goods")
public class Goods {
    @TableId(type = IdType.AUTO)
    private int id;
    private String goodName;
    private String imgUrl;
    private String info;
    private int level;
    private int parentId;
    private List<Goods> submenu;

    public Goods() {
    }
}
