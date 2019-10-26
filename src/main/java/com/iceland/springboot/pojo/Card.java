package com.iceland.springboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  19:34
 */
@Data
@TableName("card_select")
public class Card {
    @TableId(type = IdType.AUTO)
    private int id;
    private String cardNumber;
    private String cardPassword;
    private  String saleNo;
}
