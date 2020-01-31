package com.example.millet.gestionbiblix.Controller;

import android.content.Context;

import com.example.millet.gestionbiblix.modele.AccesDistant;
import com.example.millet.gestionbiblix.modele.Adherent;

import org.json.JSONArray;

import java.sql.Timestamp;
import java.util.Date;

public final class Controle {

    private static Controle instance = null;
    private static Adherent adherent;
    private static AccesDistant accesDistant;
    private static String nomFic = "saveAdherent";

    private Controle(){ super(); }

    public static final Controle getInstance(Context context){
        if(Controle.instance == null){
            Controle.instance = new Controle();
            accesDistant = new AccesDistant();
            accesDistant.envoi("recup", new JSONArray());

        }
        return Controle.instance;
    }

    public void NouvAdherent (Integer Id,String Nom, String Prenom, String Email,
                              String Mdp, String Confirme, Integer Tel, String Adulte,
                              String Adr, Integer CP, String Ville, Date Naissance,
                              Timestamp Inscription, Integer cotisation, Context context){
        adherent = new Adherent(Id, Nom, Prenom, Email, Mdp, Confirme, Tel, Adulte, Adr, CP, Ville, Naissance, Inscription, cotisation);
        accesDistant.envoi("Enreg",adherent.convertToJSONArray());

    }
}
