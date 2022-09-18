package com.oop.sheep.window;

import com.oop.sheep.model.HeroSelectContextHolder;
import com.oop.sheep.model.HeroSprite;
import com.oop.sheep.model.HeroType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DesignSpriteGroupPanel extends JPanel {

     public DesignSpriteGroupPanel() throws IOException {

          JPanel jPanel = new JPanel();
          jPanel.setPreferredSize(new Dimension(240, 1100));
          JScrollPane jScrollPane= new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          jScrollPane.setPreferredSize(new Dimension(240, 1100));

          this.add(jScrollPane);
          this.setLayout(new GridLayout(1,1));
          ImageIcon imageIcon1= new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/1.png")));
          imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label1 = new JLabel(imageIcon1);
          Border blackline = BorderFactory.createLineBorder(Color.BLACK);
          label1.setBorder(blackline);
          jPanel.add(label1);
          label1.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    HeroSelectContextHolder.selectHeroType(HeroType.HERO_TYPE_1);
               }
          });

          ImageIcon imageIcon2= new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/2.png")));
          imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label2 = new JLabel(imageIcon2);
          label2.setBorder(blackline);
          jPanel.add(label2);
          label2.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    HeroSelectContextHolder.selectHeroType(HeroType.HERO_TYPE_2);
               }
          });
          InputStream inputStream = this.getClass().getResourceAsStream("/images/sprites/3.png");
          ImageIcon imageIcon3= new ImageIcon(ImageIO.read(inputStream));
          imageIcon3.setImage(imageIcon3.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label3 = new JLabel(imageIcon3);
          label3.setBorder(blackline);
          jPanel.add(label3);
          label3.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    HeroSelectContextHolder.selectHeroType(HeroType.HERO_TYPE_3);
               }
          });
          ImageIcon imageIcon4= new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/4.png")));
          imageIcon4.setImage(imageIcon4.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label4 = new JLabel(imageIcon4);
          label4.setBorder(blackline);
          jPanel.add(label4);
          label4.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    HeroSelectContextHolder.selectHeroType(HeroType.HERO_TYPE_4);
               }
          });
          ImageIcon imageIcon5= new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/5.png")));
          imageIcon5.setImage(imageIcon5.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label5 = new JLabel(imageIcon5);
          label5.setBorder(blackline);
          jPanel.add(label5);
          label5.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    HeroSelectContextHolder.selectHeroType(HeroType.HERO_TYPE_5);
               }
          });
     }
}
