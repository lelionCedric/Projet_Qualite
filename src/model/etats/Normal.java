/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.etats;

import model.Personnage;

/**
 *
 * @author Cedric
 */
public class Normal extends Etat{
    
    private double malusForce = 0;
    
    @Override
    public void action(Personnage p){
       p.setForce(p.getForce()-malusForce);
    }

}
