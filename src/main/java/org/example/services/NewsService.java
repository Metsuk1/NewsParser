package org.example.services;
import org.example.clients.NewsClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsService  extends JFrame {

    public NewsService() {
        super ("News");
        createAndShowGUI();
        NewsClient newsClient = new NewsClient();
    }

    private void createAndShowGUI() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel hashtag = new JLabel("Enter Hashtag:");
        hashtag.setForeground(Color.WHITE);
        hashtag.setBounds(195, 140, 100, 30);
        add(hashtag);

        JTextField searchField = new JTextField();
        searchField.setBounds(195,170,100,30);
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(195, 220, 100, 30);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String hashtagText = searchField.getText().trim();
               if(!hashtagText.isEmpty()){
 //                  String response = newsClient.getNewsByHashtag(hashtagText);



               }

            }
        });

    }


}
