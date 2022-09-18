package com.oop.sheep.listener;

import com.oop.sheep.window.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MainWindowStartRunner implements ApplicationRunner {

    @Autowired
    private MainWindow mainWindow;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mainWindow.init();
    }
}
