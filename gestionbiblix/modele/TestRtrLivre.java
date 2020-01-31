package com.example.millet.gestionbiblix.modele;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.AdapterView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TestRtrLivre extends AsyncTask<String, Void, String> {
        Context context;
        AlertDialog alertDialog;
public TestRtrLivre(AdapterView.OnItemClickListener ctx) {
        context = (Context) ctx;
        }
@Override
protected String doInBackground(String... params) {
        String type = params[0];
        String RechLivre_url = "https://BiblixBDD.000webhostapp.com/biblix/FindLivreByNom.php";
        if(type.equals("RechLivre")) {            try {
        String titre = params[1];
        URL url = new URL(RechLivre_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        String post_data = URLEncoder.encode("titre","UTF-8")+"="+URLEncoder.encode(titre,"UTF-8");
        bufferedWriter.write(post_data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
        String result="";
        String line="";
        while((line = bufferedReader.readLine())!= null) {
        result += line;
        }
        bufferedReader.close();
        inputStream.close();
        httpURLConnection.disconnect();
        return result;
        } catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        return null;
        }

@Override
protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Info Livre");
        }

@Override
protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        }

@Override
protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        }
        }

