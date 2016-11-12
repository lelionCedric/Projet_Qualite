/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kotin
 */
public abstract class Outil {

    private final StringProperty nomOutil = new SimpleStringProperty();
        public String getNomOutil() {return nomOutil.get();}
        public void setNomOutil(String value) {nomOutil.set(value);}
        public StringProperty nomOutilProperty() {return nomOutil;}


    
}
