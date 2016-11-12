/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import model.outils.Outil;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Kotin
 */
public abstract class OutilConsommable extends Outil {

    private final DoubleProperty valeurBonus = new SimpleDoubleProperty();
    public double getValeurBonus() {return valeurBonus.get();}
    public void setValeurBonus(double value) {valeurBonus.set(value);}
    public DoubleProperty valeurBonusProperty() {return valeurBonus;}
  
    
    
}
