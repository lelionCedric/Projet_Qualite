/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Porte;

/**
 *
 * @author Kotin
 */
public class Clef extends OutilDeQuete{

    private final StringProperty nomPorteAssocie = new SimpleStringProperty();
        public String getNomPorteAssocie() {return nomPorteAssocie.get();}
        public void setNomPorteAssocie(String value) {nomPorteAssocie.set(value);}
        public StringProperty nomPorteAssocieProperty() {return nomPorteAssocie;}
    
    /**
     * construt permettant d'instancier une nouvelle clef
     * @param nomClef
     * @param IdPorteAssociee 
     */
    public Clef(String nomClef, String IdPorteAssociee){
        this.setNomOutil(nomClef);
        this.setNomObjetLie(IdPorteAssociee);
    }
    /**
     * compare la clef à la porte et permet d'ouvrir la porte si c'est la bonne clef
     * @param prt 
     */
    
    public void essayerOuverturePorte(Porte prt){
        if(prt.getNom().equals(getNomPorteAssocie())){
          //  afficherMessageMauvaiseClef();          // afficher dans le TextBlock que ça ne marche pas.
        }else{
            prt.ouvrirPorte();
        }
    }
    
    
}
