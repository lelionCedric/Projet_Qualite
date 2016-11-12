/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attaques;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Personnage;

/**
 *
 * @author Kotin
 */
public abstract class AttaqueAbstraite {

    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public void setNom(String value){ nom.set(value);}
        public StringProperty nomProperty() {return nom;}
      
    private final FloatProperty puissance = new SimpleFloatProperty();
        public float getPuissance() {return puissance.get();}
        public void setPuissance(float value) {puissance.set(value);}
        public FloatProperty puissanceProperty() {return puissance;}

             
    // Pour l'instant, on utilise un string, le but est peut être d'en faire
    // un enum si on veut prendre en compte des faiblesses/resistances de type
    private final StringProperty type = new SimpleStringProperty();
        public String getType() {return type.get();}
        public void setType(String value) {type.set(value);}
        public StringProperty typeProperty() {return type;}
    
   public abstract void attaquerPersonnage(Personnage p1, Personnage p2);


}
