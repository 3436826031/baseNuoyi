package com.alonecore.mapper;

import com.alonecore.domain.RandPlayer;
import com.alonecore.domain.quer_Myself;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RandListMapper  {


    //获取全部排行榜信息
    //@Select("select * from list ORDER BY score DESC LIMIT 0,30;")
   // List<RandPlayer> QueryAllList();

    /*
    * 先查询排序表   并且为表写好内容
    *    select *,(@rowno := @rowno+1) as rowno
    *    from list,(select (@rowno:=0)) b
    *   ORDER BY score DESC
    *
    * select rowno form(
    * select *,(@rowno := @rowno+1) as rowno
     *    from list,(select (@rowno:=0)) b
     *   ORDER BY score DESC
     * ) where name={name};
    * */
    //获取自己排行榜位置
  //  @Select("select rowno,score from (select *,(@rowno := @rowno+1) as rowno  from list,(select (@rowno:=0)) b ORDER BY score DESC) as rank where name=#{Getname};")
   // quer_Myself Get_Mysele_Rank(String Getname);


    //上传自己的分数
  //  @Insert("insert into list values (null,#{name},#{score})")
  //  void Updata_Mysele_Rank(RandPlayer RandPlayer);

    //上传自己的分数
 //   @Update("update list set score=#{score} where name=#{name}")
  //  void Update_Mysele_Score(RandPlayer RandPlayer);



}
