package com.oop.sheep.window;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Component
@AllArgsConstructor
public class MainWindow extends JFrame {

    private final DesignPanel designPanel;

    public void init() throws IOException {

        designPanel.init();
        this.setLayout(new BorderLayout());
        this.add(designPanel);
        this.setTitle("java oop sheep");
        getRootPane().setBorder(
                BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GRAY));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;

        setMinimumSize(new Dimension(screenWidth - 700, screenHeight - 700));
        setSize(new Dimension(screenSize.width, screenSize.height - 100));
        setResizable(true);
        setVisible(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
