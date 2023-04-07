package com.alonecore.domain;

import lombok.Data;

import java.util.Date;


/**
 * @author Lenovo
 */
@Data

public class RandPlayer {
    private int id;
    private  String name;
    private  int score;
    private Date time;
}
