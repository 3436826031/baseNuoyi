package com.alonecore.mapper;

import com.alonecore.domain.Chat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Chat_List_Mapper {

    //获取全部l聊天信息
    @Select("select * from chat ORDER BY time ASC LIMIT 0,100;")
    List<Chat> QueryAllChat();

    //上传自己的聊天记录
    @Insert("insert into chat values (null,#{name},#{speak},CURRENT_TIMESTAMP)")
    void Updata_Chat(Chat list);
}
