package com.oop.sheep.window;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Component
@AllArgsConstructor
public class DesignPanel extends JPanel {

    private final DesignMapPanel designMapPanel;

    private final DesignSpriteGroupPanel spriteGroupPanel;

    private final DesignButtonPanel buttonPanel;

    public void init() throws IOException {
        this.setLayout(new BorderLayout());
        this.add(spriteGroupPanel,BorderLayout.WEST);
        this.add(designMapPanel,BorderLayout.CENTER);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
}
