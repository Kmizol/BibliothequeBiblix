package com.example.millet.gestionbiblix.MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.millet.gestionbiblix.modele.Livre;
import com.example.millet.gestionbiblix.outil.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Year;
import java.util.ArrayList;

public class DataParser extends AsyncTask<Void,Void,Integer>
{

    Context c;
    ListView lv;
    String jsonData;

    ProgressDialog pd;
    ArrayList<Livre> livres=new ArrayList<>();

    public DataParser(Context c, ListView lv, String jsonData) {
        this.c = c;
        this.lv = lv;
        this.jsonData = jsonData;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Analyse");
        pd.setMessage("Analyse en cours...Veuillez patienter");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {

        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer resulte) {
        super.onPostExecute(resulte);

        pd.dismiss();
        if(resulte==0)
        {
            Toast.makeText(c,"Echec, Analyse Impossible",Toast.LENGTH_SHORT).show();
        }else{
            CustomAdapter adapter = new CustomAdapter(c,livres);
            lv.setAdapter(adapter);
        }
    }
    private int parseData()
    {
        try {
            JSONArray ja= new JSONArray(jsonData);
            JSONObject jo=null;

            livres.clear();
            Livre s=null;

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
// `id`, `Titre`, `Auteur`, `Editeur`, `Prix`, `Genre`, `Annee`, `Description`, `Dispo`
                int id=jo.getInt("id");
                String Titre=jo.getString("Titre");
                String Auteur=jo.getString("Auteur");
                String Editeur=jo.getString("Editeur");
                int Prix=jo.getInt("Prix");
                String Genre=jo.getString("Genre");
                Year Annee= Year.of(jo.getInt("Année"));
                String Description=jo.getString("Description");
                Boolean Dispo=jo.getBoolean("Dispo");

                s=new Livre();
                s.setId(id);
                s.setTitre(Titre);
                s.setAuteur(Auteur);
                s.setEditeur(Editeur);
                s.setPrix(Prix);
                s.setGenre(Genre);
                s.setAnnee(Annee);
                s.setDescription(Description);
                s.setDispo(Dispo);

                livres.add(s);



            }
                return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
