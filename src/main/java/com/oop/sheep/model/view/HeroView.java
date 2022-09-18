package com.oop.sheep.model.view;

import com.oop.sheep.model.HeroSprite;
import com.oop.sheep.model.HeroType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class HeroView extends JLabel{

    private static Image s1Img;
    private static Image s2Img;
    private static Image s3Img;
    private static Image s4Img;
    private static Image s5Img;

    private HeroSprite heroSprite;

    public HeroView(HeroSprite heroSprite) {
        this.heroSprite = heroSprite;
        initImages();
    }

    private void initImages() {
        try {
            if (Objects.isNull(s1Img) || Objects.isNull(s2Img) || Objects.isNull(s3Img) || Objects.isNull(s4Img) ) {
                s1Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/1.png"));
                s2Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/2.png"));
                s3Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/3.png"));
                s4Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/4.png"));
                s5Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/5.png"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HeroSprite getHeroSprite() {
        return heroSprite;
    }


    public Image getImage() {
        if (heroSprite.getHeroType() == HeroType.HERO_TYPE_1) {
            return s1Img;
        }
        if (heroSprite.getHeroType() == HeroType.HERO_TYPE_2) {
            return s2Img;
        }
        if (heroSprite.getHeroType() == HeroType.HERO_TYPE_3) {
            return s3Img;
        }
        if (heroSprite.getHeroType() == HeroType.HERO_TYPE_4) {
            return s4Img;
        }
        if (heroSprite.getHeroType() == HeroType.HERO_TYPE_5) {
            return s5Img;
        }
        return null;
    }
}
