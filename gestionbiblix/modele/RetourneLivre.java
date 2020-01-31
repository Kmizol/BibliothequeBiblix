package com.example.millet.gestionbiblix.modele;

import com.example.millet.gestionbiblix.outil.InputStreamOperations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;

public class RetourneLivre {

    private static ArrayList<Livre> livre;

    public static ArrayList<Livre> getLivre() {

        ArrayList<Livre> livres = new ArrayList<Livre>();

        try {
            String myurl= "http://localhost/biblix/ConnBDD.php";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString("livres"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Livre - Objet JSON
                Livre livre = new Livre();
                // `id`, `Titre`, `Auteur`, `Editeur`, `Prix`, `Genre`, `Annee`, `Description`, `Dispo`
                livre.setId(obj.getInt("id"));
                livre.setTitre(obj.getString("Titre"));
                livre.setAuteur(obj.getString("Auteur"));
                livre.setEditeur(obj.getString("Editeur"));
                livre.setPrix(obj.getInt("Prix"));
                livre.setGenre(obj.getString("Genre"));
                livre.setAnnee(Year.of(obj.getInt("Année")));
                livre.setDescription(obj.getString("Description"));
                livre.setDispo(obj.getBoolean("Dispo"));
                // On ajoute le livre à la liste
                livres.add(livre);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des livres
        return livre;
    }


}
