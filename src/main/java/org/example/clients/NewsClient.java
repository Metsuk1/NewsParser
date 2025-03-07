package org.example.clients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsClient {
    private static String API_KEY = "2bf40265cfc14bf192c91d3c076b3a5c";
    private static String base_url = "https://newsapi.org/v2/everything?q=";

    public static String getNewsByHashtag(String hashtag) {
        HttpURLConnection connection = null;
        try{
            String urlString = base_url  + hashtag + "&apiKey=" + API_KEY;
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}
