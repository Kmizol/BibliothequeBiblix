package com.example.millet.gestionbiblix.MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;

public class Downloader extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    ListView lv;

    ProgressDialog pd;

    public Downloader(Context c, String urlAddress, ListView lv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Recherche");
        pd.setMessage("Recherche en cours....Veuillez patienter ");
        pd.show();

    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        pd.dismiss();

        if(s==null)
        {
            Toast.makeText(c,"Echec, aucune donnée trouvé.",Toast.LENGTH_SHORT).show();
        }else
        {
            DataParser parser=new DataParser(c,lv,s);
            parser.execute();

        }
        }

    private String downloadData()
    {
        HttpURLConnection con = Connector.connect(urlAddress);
        if (con==null)
        {
            return null;
        }
        InputStream is=null;
        //https://youtu.be/krLVCo58WEo?t=1039
        try {
            is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));

            String line=null;
            StringBuffer response=new StringBuffer();

            if (br != null)
            {
                while ((line=br.readLine()) !=null)
                {
                    response.append(line+"\n");
                }

                br.close();

            }else
            {
                return null;
            }
            return response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is !=null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


}
