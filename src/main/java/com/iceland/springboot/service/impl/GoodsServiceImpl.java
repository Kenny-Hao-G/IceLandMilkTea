package com.iceland.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iceland.springboot.dao.GoodsMapper;
import com.iceland.springboot.pojo.Goods;
import com.iceland.springboot.service.GoodsService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper,Goods> implements GoodsService {

    @Override
    public List getMenu() {
        return getBaseMapper().getMenu();
        //return goodsMapper.getMenu();
    }

    @Override
    public List<Goods> getKindMenu(int id) {

        List<Goods> kindMenu = getBaseMapper().getKindMenu(id);
        List<Goods> goods = getBaseMapper().selectKindMenu(kindMenu.get(0).getLevel() + 1);
        for (Goods menu : kindMenu) {
            ArrayList<Goods> list = new ArrayList<>();
            for (Goods good : goods) {
                if (good.getParentId()==menu.getId()) {
                    list.add(good);
                }
            }
            menu.setSubmenu(list);
        }
        return kindMenu;
    }
}
