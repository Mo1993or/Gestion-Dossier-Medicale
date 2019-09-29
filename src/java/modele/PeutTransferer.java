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
public class PeutTransferer {
    private int idDossier;
    
    private int idService;

    public PeutTransferer(int idDossier, int idService) {
        this.idDossier = idDossier;
        this.idService = idService;
    }

    public PeutTransferer() {
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
    
    
}
