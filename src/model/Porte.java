/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.vueEntite.VuePorte;

/**
 *
 * @author Cedric
 */
public class Porte extends Entite{

    private final BooleanProperty ouvert = new SimpleBooleanProperty();
        public boolean isOuvert() {return ouvert.get();}
        public void setOuvert(boolean value) {ouvert.set(value);}
        public BooleanProperty ouvertProperty() {return ouvert;}
    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public void setNom(String value) {nom.set(value);}
        public StringProperty nomProperty() {return nom;}
    
    public Porte(double vitesse, int posX, int posY,String nom, Boolean ouvert) {
        super(vitesse, posX, posY, new VuePorte());

        setOuvert(ouvert);
        setNom(nom);
    }
    
    public void ouvrirPorte()
    {
        setOuvert(true);
    }
    
    
    
            
    
    
}
