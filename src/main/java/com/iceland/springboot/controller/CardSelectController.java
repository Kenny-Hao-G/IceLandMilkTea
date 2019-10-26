package com.iceland.springboot.controller;

import com.iceland.springboot.pojo.Card;
import com.iceland.springboot.service.CardService;
import com.iceland.springboot.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  19:33
 */
@RestController
@Api(tags = "星礼卡余额，消费记录等查询")
public class CardSelectController {

    @Autowired
    private CardService cardService;

    @PostMapping("/card/cardSelect")
    @ApiOperation("验证星礼卡的存在")
    public Result cardSelect(Card card) {
        return Result.setResult(cardService.selectCard(card), "查询");
    }

    @PostMapping("/card/consume")
    @ApiOperation("查询星礼卡的余额，消费记录")
    public Result consume(HttpSession session) {
        Card card = (Card) session.getAttribute("CARD");

        return cardService.selectConsume(card);

    }
}
