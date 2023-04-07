package com.alonecore.service.impl;

import com.alonecore.domain.RandPlayer;
import com.alonecore.mapper.RandListMapper;
import com.alonecore.service.RandListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
/**
 * @author Lenovo
 */
@Service
public class RandListServiceImpl implements RandListService {

/*
    @Autowired
    private RandListMapper randListMapper;
*/

    @Override
    public List<RandPlayer> QueryAllList() {

        return  null;
        //return randListMapper.selectList(null);
    }
}
