package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("help_center_menu")
public class HelpCenterMenu {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private String imgUrl;

}
