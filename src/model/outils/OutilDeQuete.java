/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import model.outils.Outil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kotin
 */
public abstract class OutilDeQuete extends Outil{

    private final StringProperty nomObjetLie = new SimpleStringProperty();
        public String getNomObjetLie() {return nomObjetLie.get();}
        public void setNomObjetLie(String value) {nomObjetLie.set(value);}
        public StringProperty nomObjetLieProperty() {return nomObjetLie;}
    
    
}
