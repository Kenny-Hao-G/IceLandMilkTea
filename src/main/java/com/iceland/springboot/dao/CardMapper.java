package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.Card;
import com.iceland.springboot.pojo.Consume;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/25  19:44
 */
public interface CardMapper extends BaseMapper<Card> {

    @Select("select c.*,cs.card_balance as cardBalance from iceland_milk_tea.consume c inner join iceland_milk_tea.card_select cs on c.id=cs.consume_id  where cs.id=#{id}")
    @ResultType(Consume.class)
    Consume selectConsume(int id);
    @Update("update iceland_milk_tea.card_select set code=#{code} where sale_no=#{saleNo}")
    @ResultType(Integer.class)
    int updateBill(Card card);





}
