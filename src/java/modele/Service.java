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
public class Service {
   private int idService;
    private int idHop;
    private String nomService;
   private String domaine;

    public Service(int idHop,int idService,String nomService,String domaine) {
        this.idHop=idHop;
        this.idService= idService;
        this.nomService = nomService;
        this.domaine=domaine;
        
        
    }

    public Service() {
    }

    public int getIdHop() {
        return idHop;
    }

    public void setIdHop(int idHop) {
        this.idHop = idHop;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    

   
   
    
    
}
