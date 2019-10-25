package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.Address;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.pojo.HelpCenterProblem;
import com.iceland.springboot.pojo.StoresInformation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HelpCenterMapper extends BaseMapper<HelpCenterMenu> {
    @Select("select p.problemName,p.info,m.title from help_center_menu m inner join help_center_problem p on p.parentId=m.id and m.id=#{id}")
    List<HelpCenterProblem> getDetailedInformation(int id);
    @Select("select id,name from address where levelId=1")
    List<Address> getProvince();

    @Select("select id,name from address where parentId=#{id}")
    List<Address> getCity(int id);
    @Select("select s.*,a.name as cityName from stores_information s inner join address a on s.cityId=a.id and a.id=#{id}")
    List<StoresInformation> getStoresInformation(int id);
}
