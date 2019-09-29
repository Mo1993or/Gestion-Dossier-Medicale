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
public class Symptome {
      private int idSym;
     private int idDossier;
    private String nomSym;

    public Symptome(int idSym, int idDossier, String nomSym) {
        this.idSym = idSym;
        this.idDossier = idDossier;
        this.nomSym = nomSym;
    }

    public Symptome() {
    }

    public int getIdSym() {
        return idSym;
    }

    public void setIdSym(int idSym) {
        this.idSym = idSym;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public String getNomSym() {
        return nomSym;
    }

    public void setNomSym(String nomSym) {
        this.nomSym = nomSym;
    }

    
}
