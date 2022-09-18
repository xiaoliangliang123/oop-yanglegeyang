package com.oop.sheep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HeroSprite {

    private int col = 0;
    private int row = 0;
    private HeroType heroType;


    public boolean isIn(int x,int y){
        return this.col==x&& row==y;
    }





}

