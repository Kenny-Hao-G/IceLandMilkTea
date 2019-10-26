package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.Card;
import com.iceland.springboot.vo.Result;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  19:42
 */
public interface CardService extends IService<Card> {
    boolean selectCard(Card card);


   Result selectConsume(Card card);




}
