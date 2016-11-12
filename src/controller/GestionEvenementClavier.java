/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashSet;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import model.vueEntite.VueHeros;

/**
 *
 * @author Cedric
 */
public class GestionEvenementClavier {
    
    private HashSet currentlyActiveKeys = new HashSet<String>();
    private VueHeros IEntite = new VueHeros();

    public HashSet getCurrentlyActiveKeys() {return currentlyActiveKeys;}
    
    public void prepareActionHandlers(Scene scene)
    {
        scene.setOnKeyPressed((KeyEvent event) -> {
            currentlyActiveKeys.add(event.getCode().toString());
            System.out.println(event.getCode().toString());
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
             currentlyActiveKeys.remove(event.getCode().toString());
             System.out.println(event.getCode().toString());
        });
        
    }
    
    
}
