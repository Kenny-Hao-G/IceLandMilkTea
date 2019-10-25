package com.iceland.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iceland.springboot.pojo.HelpCenterMenu;
import com.iceland.springboot.pojo.HelpCenterProblem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HelpCenterMapper extends BaseMapper<HelpCenterMenu> {
    @Select("select p.problemName,p.info,m.title from help_center_menu m inner join help_center_problem p on p.parentId=m.id and m.id=#{id}")
    List<HelpCenterProblem> getDetailedInformation(int id);
}
