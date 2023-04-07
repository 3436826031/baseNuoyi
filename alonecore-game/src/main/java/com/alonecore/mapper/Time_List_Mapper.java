package com.alonecore.mapper;

import com.alonecore.domain.time_list;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Time_List_Mapper {

    //获取全部排行榜信息
    @Select("select name,time from time_list ORDER BY time DESC LIMIT 0,30;")
    List<time_list> QueryAllList();

    //获取自己排行榜位置
    @Select("select rowno,time from (select *,(@rowno := @rowno+1) as rowno  from time_list,(select (@rowno:=0)) b ORDER BY time DESC) as rank where name=#{Getname};")
    Integer Get_Mysele_Rank(String Getname);


    //上传自己的分数
    @Insert("insert into time_list values (null,#{name},#{time})")
    void Updata_Mysele_Rank(time_list list);

    //上传自己的时间
    @Update("update list set time=#{time} where name=#{name}")
    void Update_Mysele_Time(time_list list);

    //上传自己是否领取完毕奖励   （每日排行榜前30   榜一金币200  2  100  3 100   剩下的50金币）


}
