package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  20:00
 */
@Data
@TableName("consume")
public class Consume {
    @TableId(type = IdType.AUTO)
    private int id;
    private int payMoney;
    private String goodsName;
    private  int cardBalance;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
}
