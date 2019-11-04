package com.iceland.springboot.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.CardMapper;
import com.iceland.springboot.pojo.Card;

import com.iceland.springboot.pojo.Consume;
import com.iceland.springboot.service.CardService;

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
        if (card.getCardNumber() != null && card.getCardPassword() != null) {
            card.setCardPassword(Md5Utils.getMd5Str(card.getCardPassword()));

            Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number",card.getCardNumber()));
            if (Objects.equals(card.getCardPassword(), card1.getCardPassword())) {

                Subject subject = SecurityUtils.getSubject();
                subject.getSession().setAttribute("CARD", card1);
                subject.getSession().setTimeout(300000);

                System.out.println(card1);
                return true;

            }

        }
        if (card.getCardNumber()!=null&&card.getSaleNo()!=null) {

            Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number", card.getCardNumber()));

            if (Objects.equals(card1.getSaleNo(), card.getSaleNo())) {

                Subject subject = SecurityUtils.getSubject();
                subject.getSession().setAttribute("CARD", card1);
                subject.getSession().setTimeout(300000);
                System.out.println(card1);

                return true;
            }

        }

        return false;
    }

    @Override
    public Result selectConsume(Card card) {
        if (card.getCardNumber() != null && card.getCardPassword() != null && card.getSaleNo() == null) {
            Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number",card.getCardNumber()));
            if (Objects.equals(card1.getCardPassword(), card.getCardPassword())) {
                Consume consume = getBaseMapper().selectConsume(card.getId());
                return Result.setOK(consume);

            }
        }
            if (card.getCardNumber() != null && card.getSaleNo() != null && card.getCardPassword() != null) {
                Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("card_number", card.getCardNumber()));
                if (Objects.equals(card1.getCardPassword(), card.getCardPassword()) && Objects.equals(card1.getSaleNo(),card.getSaleNo())) {
                    Consume consume = getBaseMapper().selectConsume(card.getId());
                    return Result.setOK(consume);

                }
            }

            return Result.setERROR();
        }



      @Override
    public boolean updateBill(Card card) {
        if (card.getSaleNo() != null && card.getCode() != null) {

            Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("sale_no", card.getSaleNo()));
            if (Objects.equals(card1.getSaleNo(),card.getSaleNo())){

                int count = getBaseMapper().updateBill(card);
                return count > 0 ? true : false;
            }
        }
        return false;
    }

    @Override
    public Result selectBill(Card card) {
        if (card.getSaleNo()!=null&&card.getCode()!=null){
            Card card1 = getBaseMapper().selectOne(new QueryWrapper<Card>().eq("sale_no", card.getSaleNo()));
            if (Objects.equals(card1.getCode(),card.getCode())){
                return Result.setOK("申请发票已受理");
            }
        }
        return Result.setERROR();
    }


}
