package org.example.services;
import netscape.javascript.JSObject;
import org.example.clients.NewsClient;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsService  extends JFrame {

    private JTextArea resultArea;

    public NewsService() {
        super ("News-Parser");
        createAndShowGUI();
//        NewsClient newsClient = new NewsClient();
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

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBounds(50, 260, 400, 180);
        resultArea.setBackground(Color.WHITE);
        resultArea.setForeground(Color.BLACK);
        add(resultArea);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(50,260,400,180);
        add(scrollPane);


        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String hashtagText = searchField.getText().trim();
               if(!hashtagText.isEmpty()){
                   String jsonResponse = NewsClient.getNewsByHashtag(hashtagText);
                   if(jsonResponse != null){
                       String formattedJson = formatJson(jsonResponse);
                       resultArea.setText(formattedJson);
                   }else {
                       resultArea.setText("No information found");
                   }
               }
            }
        });
    }

    private String formatJson(String jsonResponse){
        try{
            // Преобразуем строку в JSONObject
            JSONObject jsonObject = new JSONObject(jsonResponse);
            // Форматируем JSON с отступами (4 пробела)

            return jsonObject.toString(4);
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResponse;
        }
    }

}
