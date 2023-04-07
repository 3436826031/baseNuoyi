package com.alonecore.mapper;

import com.alonecore.domain.One_Gamer_Mess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Get_Gamer_Mess {
    //获取个人信息
    @Select("select l.name,l.score,t.time from list as l  left join time_list as t on l.name=t.name where l.name=#{name}")
    One_Gamer_Mess Query_One_Gamer(String name);

}
