package com.iceland.springboot.service;

import com.iceland.springboot.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getMenu();
    List getKindMenu(int id);
}
