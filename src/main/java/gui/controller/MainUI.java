/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import datacenter.Data;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import objmodels.GUIModel;

/**
 * FXML Controller class
 *
 * @author Eagle
 */
public class MainUI implements Initializable {

    //Declare comboboc Controls---------------------------
    @FXML
    private ComboBox<String> cbTitles;
   
    
    //TDeclare able view ------------------------
    @FXML
    private TableView<GUIModel> tbData;
    @FXML
    public TableColumn<GUIModel, Integer> id;
    @FXML
    public TableColumn<GUIModel, String> name;
    @FXML
    public TableColumn<GUIModel, String> job;
    @FXML
    public TableColumn<GUIModel, Integer> experience;
    @FXML
    public TableColumn<GUIModel, String> cv_link;
    @FXML
    public TableColumn<GUIModel, String> skills;
    @FXML
    public TableColumn<GUIModel, String> status;
    @FXML
    public TableColumn<GUIModel, String> comment;
    @FXML
    public TableColumn<GUIModel, String> user;
    @FXML
    public TableColumn<GUIModel, String> label;
    @FXML
    public TableColumn<GUIModel, String> cv_date;
    @FXML
    public TableColumn<GUIModel, String> can_location;
    @FXML
    public TableColumn<GUIModel, String> referral;
    @FXML
    public TableColumn<GUIModel, Integer> phone;
    /**
     * Initializes the controller class.
     */
    // Data --------------------------------------------------------------
     private ObservableList<GUIModel> GUIModels = FXCollections.observableArrayList(
            new GUIModel(1, "Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
            new GUIModel(2, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
            new GUIModel(3, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
            new GUIModel(4, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890)
    );
    //private ObservableList<String> lstAlls = FXCollections.observableArrayList("ConDien", "conkhung", "conMad");
     private ObservableList<String> lstTitles = null;
     private ObservableList<String> lstStatus = null;
     private ObservableList<String> lstCVDates = null;
     private ObservableList<String> lstExperience = null;
     private ObservableList<String> lstLocations = null;
     private ObservableList<String> lstLabels = null;
     private ObservableList<String> lstReferrals = null;
     private ObservableList<String> listRecruiters = null;
     private ObservableList<String> lstResumeUpd = null;
     private ObservableList<String> listRecruiterNames = null;
    
    //----------------------------------------------------------------------- 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFilterComboxes();
        initTableView();
        
    }    

    private void initTableView(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        cv_link.setCellValueFactory(new PropertyValueFactory<>("cv_link"));
        skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        label.setCellValueFactory(new PropertyValueFactory<>("label"));
        cv_date.setCellValueFactory(new PropertyValueFactory<>("cv_date"));
        can_location.setCellValueFactory(new PropertyValueFactory<>("can_location"));
        referral.setCellValueFactory(new PropertyValueFactory<>("referral"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tbData.setItems(GUIModels);
    }
    
    private void LoadData(){
        lstTitles = FXCollections.observableList(Data.lstTitles);
        lstStatus = FXCollections.observableList(Data.lstStatus);
        lstCVDates = FXCollections.observableList(Data.lstCVDate); //////
        lstExperience = FXCollections.observableList(Data.lstExperiences);
        lstLocations = FXCollections.observableList(Data.lstLocators);
        lstLabels = FXCollections.observableList(Data.lstLabels);
        lstReferrals = FXCollections.observableList(Data.lstReferrals);
        listRecruiterNames = null;
        lstResumeUpd = FXCollections.observableList(Data.lstResumeUpdNames);
        
        tbData.setItems(GUIModels);
    }
    private void initFilterComboxes(){
        cbTitles.setItems(lstTitles);
          
    }
    private void RefreshUI(){
         tbData.refresh();
    }
    //Action control -------------------------------------------------- 
  
    @FXML
    void HandleSearchDB(MouseEvent event) {
          System.out.println("HandleSearchDB!");
          RefreshUI();
    }

    @FXML
    void HandleSearchFolder(MouseEvent event) {
          System.out.println("HandleSearchFolder!");
    }

    @FXML
    void HandleSearchOnline(MouseEvent event) {
         System.out.println("HandleSearchOnline!");
         
        
         
         
      
    }
   

     

    
}
