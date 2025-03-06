package org.example;

import org.example.services.NewsService;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new NewsService().setVisible(true);
            }
        });





    }
}