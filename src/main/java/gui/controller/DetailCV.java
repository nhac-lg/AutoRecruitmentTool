/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.Icon;

/**
 * FXML Controller class
 *
 * @author Eagle
 */
public class DetailCV implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label txt_name;

    @FXML
    private TextField txt_pos;

    @FXML
    private TextField txt_company;

    @FXML
    private TextField txt_year;

    @FXML
    private TextField txt_salary;

    @FXML
    private TextField txt_srcCV;

    @FXML
    private TextField txt_job;

    @FXML
    private TextField txt_location;

    @FXML
    private TextField txt_gender;

    @FXML
    private Label text_pos;
    
     @FXML
    private Icon btnClose;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource()==btnClose){
            System.exit(0);
        }
        
    }
    
}
