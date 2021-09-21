/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    private Label lbl_name;

    @FXML
    private Label lbl_gender;

    @FXML
    private Label lbl_pos;

    @FXML
    private Label lbl_joblv;

    @FXML
    private Label lbl_year;

    @FXML
    private Label lbl_company;

    @FXML
    private Label lbl_salary;

    @FXML
    private Label lbl_location;

    @FXML
    private Label lbl_src;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_name.setText("LÊ THÙY");
    }

    
}
