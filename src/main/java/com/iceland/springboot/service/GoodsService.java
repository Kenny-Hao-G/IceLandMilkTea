package com.iceland.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iceland.springboot.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService extends IService<Goods> {
    List<Goods> getMenu();
    List getKindMenu(int id);
}
