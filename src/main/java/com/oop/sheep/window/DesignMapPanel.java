package com.oop.sheep.window;

import com.oop.sheep.model.HeroSelectContextHolder;
import com.oop.sheep.model.HeroSprite;
import com.oop.sheep.model.view.HeroView;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DesignMapPanel extends JPanel {

    private int cpix = 50;
    private int hpix = 50;
    private int columns = 20;
    private int rows = 20;
    private int windowWidth = 0;
    private int windowHeight = 0;
    private List<HeroView> heroViews = new ArrayList<>();
    private static Image bgImg;
    private JLabel bgLabel ;
    

    private JLayeredPane jLayeredPane;

    public  DesignMapPanel() throws IOException {


        //获取总窗体宽高
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rect=ge.getMaximumWindowBounds();
        int w=rect.width -230;
        int h=rect.height -104 ;
        this.setLayout(null);

        //设置滚动条
        jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0,0,w,h);
        jLayeredPane.setLayout(null);
        this.add(jLayeredPane);

        //设置初始化时的背景图片大小
        windowWidth = jLayeredPane.getBounds().width;
        windowHeight = jLayeredPane.getBounds().height;
        bgImg = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/bg.jpeg"));
        bgLabel = new JLabel(new ImageIcon(bgImg.getScaledInstance(windowWidth,windowHeight,Image.SCALE_DEFAULT)));
        bgLabel.setBounds(0,0,windowWidth,windowHeight);
        this.jLayeredPane.add(bgLabel,JLayeredPane.DEFAULT_LAYER);

        //设置鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addHeros(e.getX(), e.getY());
            }
        });

    }

    private void addHeros(int x, int y) {

        //循环宽高，找到鼠标点击点最靠近的横竖交界点
        for (int i = 1; i <= columns; i++) {
            for (int j = 1; j <= rows; j++) {

                int pointX = i * cpix;
                int pointY = j * hpix;

                //碰撞检测，判断鼠标点击点与哪行哪列最接近，并记录
                Rectangle clickPoint = new Rectangle(pointX - cpix / 2, pointY - hpix / 2, cpix, hpix);
                boolean isIn = clickPoint.contains(x, y);
                if (isIn) {

                    //找到了最近交界点行号和列号，创建对象并报存
                    HeroSprite heroSprite = new HeroSprite(i, j, HeroSelectContextHolder.currentHeroType());
                    HeroView heroView = new HeroView(heroSprite);
                    Border blackline = BorderFactory.createRaisedBevelBorder();
                    heroView.setBorder(blackline);
                    heroView.setIcon(new ImageIcon(heroView.getImage().getScaledInstance(cpix ,hpix*2,Image.SCALE_DEFAULT)));
                    heroView.setBounds(i * cpix - cpix / 2, j * hpix - hpix, cpix, hpix * 2);
                    heroViews.add(heroView);

                    //将选择的图像放到找到的中心点位置
                    jLayeredPane.add(heroView,JLayeredPane.DRAG_LAYER);
                    System.out.println("c:" + i + ",r:" + j);
                    this.updateUI();
                }

            }
        }

    }

    @SneakyThrows
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(2.0f));

        graphics2D.setColor(Color.black);

        //获取当前窗口宽高大小
        windowWidth = this.getBounds().width;
        windowHeight = this.getBounds().height;

        //计算宽高间距
        cpix = windowWidth / columns - 1;
        hpix = windowHeight / rows - 1;

        //绘制列线条
        for (int i = 0; i < columns; i++) {
            graphics2D.drawLine(i * cpix, 0, i * cpix, windowHeight);
        }

        //绘制行线条
        for (int i = 0; i < rows; i++) {
            graphics2D.drawLine(0, i * hpix, windowWidth, i * hpix);
        }


    }


    public List<HeroSprite> heroSprites(){
        return heroViews.stream().map(heroView -> heroView.getHeroSprite()).collect(Collectors.toList());
    }
}
