/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author serignemor
 */
public class ListerPatient {

    private int noUser;
    private String prenom;
    private String nom;
    private String adresse;
    private String email;
    private String telephone;
    private String password;
    private int noUserp;
    private String proffession;
    private String taille;
    private String poids;
    private String age;
    private String numerosCNI;
    private String sexe;

    public ListerPatient(String sexe,int noUser, String prenom, String nom, String adresse, String email, String telephone, String password, int noUserp,  String proffession, String taille, String poids, String age, String numerosCNI) {
        this.noUser = noUser;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.noUserp = noUserp;
        this.proffession = proffession;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.numerosCNI = numerosCNI;
        this.sexe=sexe;
    }

    public ListerPatient() {
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoUserp() {
        return noUserp;
    }

    public void setNoUserp(int noUserp) {
        this.noUserp = noUserp;
    }

   

    public String getProffession() {
        return proffession;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumerosCNI() {
        return numerosCNI;
    }

    public void setNumerosCNI(String numerosCNI) {
        this.numerosCNI = numerosCNI;
    }

}
