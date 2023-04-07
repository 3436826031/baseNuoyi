package com.ruoyi.web.gameController;

import com.alonecore.domain.RandPlayer;
import com.alonecore.service.RandListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kapian")
@Api(value = "用户的增删改查")
public class KapianController {

   //  @Autowired
    // private RandListService randListService;

    @ResponseBody
    @GetMapping("/getrand")
    @ApiOperation(value = "获取用户列表，目前没有分页")
    public List<RandPlayer> querList()
    {
        System.out.println("执行了");
      //  List<RandPlayer> RandPlayer =randListService.QueryAllList();
        return null;
    }

}
