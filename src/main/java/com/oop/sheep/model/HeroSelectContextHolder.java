package com.oop.sheep.model;

public class HeroSelectContextHolder {

    private static HeroType heroType = HeroType.HERO_TYPE_1;

    public static void selectHeroType(HeroType heroType){
        HeroSelectContextHolder.heroType = heroType;
    }

    public static HeroType currentHeroType(){
        return heroType;
    }
}
