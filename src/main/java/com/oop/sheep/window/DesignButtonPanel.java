package com.oop.sheep.window;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.oop.sheep.model.HeroMapData;
import com.oop.sheep.model.HeroSprite;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.File;
import java.util.stream.IntStream;

@Component
public class DesignButtonPanel extends JPanel {

    private JButton saveButton = new JButton("save zhe map");
    private JComboBox<String> levels = new JComboBox<String>();

    @Autowired
    private  DesignMapPanel designMapPanel;

    public DesignButtonPanel(){
        saveButton.setSize(200,100);
        IntStream.range(1,100).forEach(level->{
            levels.addItem(level+"");
        });
        this.add(saveButton);
        this.add(levels);
        this.saveButton.addActionListener(e -> {

            //选择哪个关卡
            Integer selectLevel = Integer.parseInt(this.levels.getSelectedItem().toString());

            //获取地图数据
            HeroMapData heroMapData = HeroMapData.builder().heroSprites(designMapPanel.heroSprites())
                    .level(selectLevel).build();
            String mapJson = JSONUtil.toJsonStr(heroMapData);

            //获取当前项目目录
            String usrDir = System.getProperty("user.dir");

            //按照关卡将地图数据保存
            File mapFile = new File(usrDir+File.separator+"map"+File.separator+selectLevel+".json");
            FileUtil.writeBytes(mapJson.getBytes(),mapFile);
        });
    }
}
