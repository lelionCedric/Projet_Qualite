/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cedric
 */
public class Monde {
    
    private List<Entite> entitesMonde;

    public List<Entite> getEntitesMonde() {return entitesMonde;}
    public void setEntitesMonde(List<Entite> entitesMonde) {this.entitesMonde = entitesMonde;}
    
    
    public Monde(){
        if(getEntitesMonde()==null){
            setEntitesMonde(new ArrayList<>());
        }
        getEntitesMonde().add(new Personnage(0, 300, 100, "Michel", Type.Joueur));
        getEntitesMonde().add(new Porte(0, 225, 300, "door", Boolean.TRUE));
    }
    
    
}
