package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select id,goodName from goods where parentId=0")
    List<Goods> getMenu();

    @Select("select id,goodName,level from goods where parentId=#{id}")
    List<Goods> getKindMenu(int id);
    @Select("select id,goodName,imgUrl,parentId from goods where level=#{id}")
    List<Goods> selectKindMenu(int id);
}
