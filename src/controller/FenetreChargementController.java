/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cedric
 */
public class FenetreChargementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    public void clicRetour(ActionEvent event) throws Exception {
        
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/view/Accueil.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
