package com.oop.sheep.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HeroMapData {

    private Integer level;
    private List<HeroSprite> heroSprites;



}
