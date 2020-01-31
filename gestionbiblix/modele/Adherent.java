package com.example.millet.gestionbiblix.modele;

import org.json.JSONArray;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adherent {


    private Integer Id;
    private String Nom;
    private String Prenom;
    private String Email;
    private String Mdp;
    private String Confirme;
    private Integer Tel;
    private String Adulte;
    private String Adr;
    private Integer CP;
    private String Ville;
    private Date Naissance;
    private Timestamp Inscription;
    private Integer cotisation;

    public Adherent(Integer Id, String Nom,String Prenom, String Email,
                    String Mdp, String Confirme, Integer Tel, String Adulte,
                    String Adr, Integer CP, String Ville, Date Naissance,
                    Timestamp Inscription,  Integer cotisation){

        this.Id = Id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.Mdp =Mdp;
        this.Confirme = Confirme;
        this.Tel = Tel;
        this.Adulte = Adulte;
        this.Adr = Adr;
        this.CP = CP;
        this.Ville = Ville;
        this.Naissance = Naissance;
        this.Inscription = Inscription;
        this.cotisation = cotisation;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public String getConfirme() {
        return Confirme;
    }

    public void setConfirme(String confirme) {
        Confirme = confirme;
    }

    public Integer getTel() {
        return Tel;
    }

    public void setTel(Integer tel) {
        Tel = tel;
    }

    public String getAdulte() {
        return Adulte;
    }

    public void setAdulte(String adulte) {
        Adulte = adulte;
    }

    public String getAdr() {
        return Adr;
    }

    public void setAdr(String adr) {
        Adr = adr;
    }

    public Integer getCP() {
        return CP;
    }

    public void setCP(Integer CP) {
        this.CP = CP;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Date getNaissance() {
        return Naissance;
    }

    public void setNaissance(Date naissance) {
        Naissance = naissance;
    }

    public Timestamp getInscription() {
        return Inscription;
    }

    public void setInscription(Timestamp inscription) {
        Inscription = inscription;
    }

    public Integer getCotisation() {
        return cotisation;
    }

    public void setCotisation(Integer cotisation) {
        this.cotisation = cotisation;
    }

    //Id`, `Nom`, `Prenom`, `Email`, `Mdp`, `Confirme`, `Tel`, `Adulte`, `Adr`, `CP`,
    // `Ville`, `Naissance`, `Inscription`, `cotisation

    public JSONArray convertToJSONArray() {
        List LaListe = new ArrayList();
        LaListe.add(Id);
        LaListe.add(Nom);
        LaListe.add(Prenom);
        LaListe.add(Email);
        LaListe.add(Mdp);
        LaListe.add(Confirme);
        LaListe.add(Tel);
        LaListe.add(Adulte);
        LaListe.add(Adr);
        LaListe.add(CP);
        LaListe.add(Ville);
        LaListe.add(Naissance);
        LaListe.add(cotisation);
        return new JSONArray(LaListe);
    }

}
