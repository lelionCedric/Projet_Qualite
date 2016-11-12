/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import model.outils.Outil;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 *
 * @author Kotin
 */
public abstract class OutilEquipable extends Outil{

    private final FloatProperty bonusForce = new SimpleFloatProperty();
        public float getBonusForce() {return bonusForce.get();}
        public void setBonusForce(float value) {bonusForce.set(value);}
        public FloatProperty bonusForceProperty() {return bonusForce;}
    
    private final FloatProperty bonusDefense = new SimpleFloatProperty();
        public float getBonusDefense() {return bonusDefense.get();}
        public void setBonusDefense(float value) {bonusDefense.set(value);}
        public FloatProperty bonusDefenseProperty() {return bonusDefense;}
        
    private final FloatProperty bonusVie = new SimpleFloatProperty();
        public float getBonusVie() {return bonusVie.get();}
        public void setBonusVie(float value) {bonusVie.set(value);}
        public FloatProperty bonusVieProperty() {return bonusVie;}
    
    
    
    
}
