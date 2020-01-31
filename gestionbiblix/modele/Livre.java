package com.example.millet.gestionbiblix.modele;

import java.lang.ref.SoftReference;
import java.time.Year;

public class Livre {

   // `id`, `Titre`, `Auteur`, `Editeur`, `Prix`, `Genre`, `Annee`, `Description`, `Dispo`
     Integer id,Prix;
    String Titre;
    String Auteur;
    String Editeur;
    String Genre;
    String Description;
    Year Annee;
    Boolean Dispo;

    public String getEditeur() {
        return Editeur;
    }

    public void setEditeur(String editeur) {
        Editeur = editeur;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrix() {
        return Prix;
    }

    public void setPrix(Integer prix) {
        Prix = prix;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Year getAnnee() {
        return Annee;
    }

    public void setAnnee(Year annee) {
        Annee = annee;
    }

    public Boolean getDispo() {
        return Dispo;
    }

    public void setDispo(Boolean dispo) {
        Dispo = dispo;
    }








}
