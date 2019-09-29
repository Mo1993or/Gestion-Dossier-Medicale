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
public class message {
    private int idMess;
     private int noUser;
    private String textMess;
    private String titre;
    private int lu;

    public message(int idMess, int noUser, String textMess,String titre, int lu) {
        this.idMess = idMess;
        this.noUser = noUser;
        this.textMess = textMess;
        this.titre=titre;
        this.lu = lu;
    }

    public message() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getIdMess() {
        return idMess;
    }

    public void setIdMess(int idMess) {
        this.idMess = idMess;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getTextMess() {
        return textMess;
    }

    public void setTextMess(String textMess) {
        this.textMess = textMess;
    }

    public int getLu() {
        return lu;
    }

    public void setLu(int lu) {
        this.lu = lu;
    }
   
    
    
}
