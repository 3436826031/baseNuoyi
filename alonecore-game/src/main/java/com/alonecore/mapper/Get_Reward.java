package com.alonecore.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Get_Reward {
    //上传奖励领取
    @Insert("INSERT INTO reward VALUES (null,#{name},1);")
    void Updata_Myself_Rewardk(String name);


    //读取奖励是否被领取
    @Insert("SELECT reward FROM reward WHERE name='s';")
    Integer Select_Myselt_Reward(String name);

    //读取奖励是否被领取
    @Delete("DELETE FROM reward;")
    void Clear_Day();

}
