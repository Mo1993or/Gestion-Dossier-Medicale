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
public class patient {
    private int noUser;
    private int idDossier;
    private String proffession;
    private String taille;
    private String poids;
    private String age;
    private String numerosCNI;
    private String sexe;

    public patient(int noUser, int idDossier, String proffession, String taille, String poids, String age, String numerosCNI, String sexe) {
        this.noUser = noUser;
        this.idDossier = idDossier;
       
        this.proffession = proffession;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.numerosCNI = numerosCNI;
        this.sexe = sexe;
    }

    public patient() {
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

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
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
