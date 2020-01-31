package com.example.millet.gestionbiblix.modele;

import android.util.Log;

import com.example.millet.gestionbiblix.outil.AccesHTTP;
import com.example.millet.gestionbiblix.outil.AsyncResponse;

import org.json.JSONArray;

public class AccesDistant implements AsyncResponse {

   private static final String SERVERADDR = "http://192.168.43.163/biblix/serveurbiblix.php";

   public AccesDistant() {
       super();
   }


    @Override
    public void processFinish(String output) {
        Log.d("serveur", "**************"+output);
        String[] message = output.split("%");

        if(message.length>1){
            if(message[0].equals("enreg")) {
                Log.d("enreg","********************************************"+message[1]);
            }
        }else {
            if (message[0].equals("recup")) {
                Log.d("recup","***********************************************"+message[1]);


            } else {
                if (message[0].equals("RecupLivre")) {
                    Log.d("RecupLivre","*************************************************"+message[1]);
                }

                 else {
                     if (message[0].equals("Erreur !")) {
                          Log.d("Erreur !","***********************************************"+message[1]);
                }
            }
            }


        }
   }
   public void envoi (String operation, JSONArray lesDonneeJSON){
       AccesHTTP accesDonnees = new AccesHTTP();
       accesDonnees.delegate = this;
       accesDonnees.addParam("operation",operation);
       accesDonnees.addParam("lesdonnees",lesDonneeJSON.toString());
       accesDonnees.execute(SERVERADDR);
   }
}
