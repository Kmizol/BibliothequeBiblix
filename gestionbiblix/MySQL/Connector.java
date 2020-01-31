package com.example.millet.gestionbiblix.MySQL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {

    public static HttpURLConnection connect(String urlAddress)
    {
        try {
            URL url=new URL(urlAddress);
            try {
                HttpURLConnection con=(HttpURLConnection) url.openConnection();


                con.setRequestMethod("GET");
                con.setConnectTimeout(20000);
                con.setReadTimeout(20000);
                con.setDoInput(true);


                return con;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    return null;
    }
}
