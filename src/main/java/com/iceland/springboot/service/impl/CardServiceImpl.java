package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.CardMapper;
import com.iceland.springboot.pojo.Card;

import com.iceland.springboot.pojo.Consume;
import com.iceland.springboot.service.CardService;
import com.iceland.springboot.utils.JsonUtils;
import com.iceland.springboot.utils.Md5Utils;
import com.iceland.springboot.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  19:43
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {
    @Override
    public boolean selectCard(Card card) {
        if (card.getCardNumber()!=null&&card.getCardPassword()!=null){
            card.setCardPassword(Md5Utils.getMd5Str(card.getCardPassword()));

           Card card1=getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number",card.getCardNumber()));
           if (Objects.equals(card.getCardPassword(),card1.getCardPassword())){

               Subject subject= SecurityUtils.getSubject();
               subject.getSession().setAttribute("CARD",card1);
               System.out.println(card1);
               return true;

           }

        }
        return false;
    }

    @Override
    public Result selectConsume(Card card) {
        if (card !=null){
            Card card1=getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number",card.getCardNumber()));
            if (Objects.equals(card1.getCardPassword(),card.getCardPassword())){
                Consume consume=getBaseMapper().selectConsume(card.getId());
                return Result.setOK(consume);

            }

        }
        return Result.setERROR();
    }
}
