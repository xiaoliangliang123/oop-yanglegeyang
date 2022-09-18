package com.oop.sheep.model;

public enum HeroType {

    HERO_TYPE_1(1),
    HERO_TYPE_2(2),
    HERO_TYPE_3(3),
    HERO_TYPE_4(4),
    HERO_TYPE_5(5);

    private int type ;
    HeroType(int type ){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
