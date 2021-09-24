/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import datacenter.Data;
import filter.Recruitment_Online;
import filter.Recruitment_VietNamWork;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import objmodels.CandiidateModel;

/**
 * FXML Controller class
 *
 * @author Eagle
 */
public class MainUI implements Initializable {

    //Declare top filter Controls---------------------------
    @FXML
    private ComboBox<String> cbTitlesTop;
    @FXML
    private ComboBox<String> cbExpTop;
    @FXML
    private ComboBox<String> cbStatusTop;
    @FXML
    private ComboBox<String> cbLabelTop;
    @FXML
    private ComboBox<String> cbCVDateTop;
    @FXML
    private ComboBox<String> cbReferralTop;
    @FXML
    private ComboBox<String> cbLocationTop;
    @FXML
    private TextField txtSearchTop;

    //Declare left filter controls
    @FXML
    private ComboBox<String> cbEmployerOnlineSearch;
    public static String txt_cbEmloyerOnlinesearch;
    @FXML
    private TextField txtSearchKeywordOnlineSearch;
    public static String txt_search;
    @FXML
    private TextField txtExperienceFromOnlineSearch;
    public static String txt_ExpFrom;
    @FXML
    private TextField txtExperienceToOnlineSearch;
    public static String txt_ExpTo;
    @FXML
    private ComboBox<String> cbLastResumeUpdateOnlineSearch;
    public static String txt_cbLastResumeUpdateOnlineSearch;
    //private ComboBox<UpdateList> cbLastResumeUpdateOnlineSearch;
    @FXML
    private ComboBox<String> cbWorkingLocationOnlineSearch;
    public static String txt_cbWorkingLocationOnlineSearch;
    
    @FXML
    private CheckBox check_viewed;
    
    @FXML
    private ComboBox<String> cbLatestResumeUpdateOnlineSearch;
    @FXML
    private ComboBox<String> cbStatusLocalSearch;
    @FXML
    private ComboBox<String> cbLastStatusUpdateLocalSearch;
    @FXML
    private ComboBox<String> cbExpectedLocationLocalSearch;
    @FXML
    private TextField txtFolderSearch;
    @FXML
    private CheckBox checkIncludeSubFolderFolderSearch;

    //Declare Table View ------------------------
    @FXML
    private TableView<CandiidateModel> tbData;
    @FXML
    public TableColumn<CandiidateModel, Integer> id;
    @FXML
    public TableColumn<CandiidateModel, String> name;
    @FXML
    public TableColumn<CandiidateModel, String> job;
    @FXML
    public TableColumn<CandiidateModel, Integer> experience;
    @FXML
    public TableColumn<CandiidateModel, String> cv_link;
    @FXML
    public TableColumn<CandiidateModel, String> skills;
    @FXML
    public TableColumn<CandiidateModel, String> status;
    @FXML
    public TableColumn<CandiidateModel, String> comment;
    @FXML
    public TableColumn<CandiidateModel, String> user;
    @FXML
    public TableColumn<CandiidateModel, String> label;
    @FXML
    public TableColumn<CandiidateModel, String> cv_date;
    @FXML
    public TableColumn<CandiidateModel, String> can_location;
    @FXML
    public TableColumn<CandiidateModel, String> referral;
    @FXML
    public TableColumn<CandiidateModel, Integer> phone;

    // Variable ------------------------------------------------------------
    private ObservableList<CandiidateModel> lstCandidates = null;
   //-----------------------------------------------------------------------
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableView();
        InitFilterControls();
        
    }

    private void initTableView() {
   
        //Init columns------------------------------------------    
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
        });
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        job.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setJob(t.getNewValue());
        });
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        experience.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
   
        cv_link.setCellValueFactory(new PropertyValueFactory<>("cv_link"));
        cv_link.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_link.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setCv_link(t.getNewValue());
        });
        skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        skills.setCellFactory(TextFieldTableCell.forTableColumn());
        skills.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setSkills(t.getNewValue());
        });
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setStatus(t.getNewValue());
        });
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        comment.setCellFactory(TextFieldTableCell.forTableColumn());
        comment.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setComment(t.getNewValue());
        });
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        user.setCellFactory(TextFieldTableCell.forTableColumn());
        user.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setUser(t.getNewValue());
        });
        label.setCellValueFactory(new PropertyValueFactory<>("label"));
        label.setCellFactory(TextFieldTableCell.forTableColumn());
        label.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setLabel(t.getNewValue());
        });
        cv_date.setCellValueFactory(new PropertyValueFactory<>("cv_date"));
        cv_date.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_date.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setCv_date(t.getNewValue());
        });
        can_location.setCellValueFactory(new PropertyValueFactory<>("can_location"));
        can_location.setCellFactory(TextFieldTableCell.forTableColumn());
        can_location.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setLocation(t.getNewValue());
        });
        referral.setCellValueFactory(new PropertyValueFactory<>("referral"));
        referral.setCellFactory(TextFieldTableCell.forTableColumn());
        referral.setOnEditCommit((TableColumn.CellEditEvent<CandiidateModel, String> t) -> {
            ((CandiidateModel) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())
                    ).setReferral(t.getNewValue());
        });
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        //Init table data --------------------------------------------------
        lstCandidates = FXCollections.observableArrayList(Data.lstCandidateModel);
        tbData.setItems(lstCandidates); 

    }
    
    private void InitFilterControls(){
        // Defined controls
        cbStatusTop.setItems(FXCollections.observableList(Data.lstStatus));
        cbLastResumeUpdateOnlineSearch.setItems(FXCollections.observableList(new ArrayList<>(Data.lstResumeUpd.keySet())));
        cbLocationTop.setItems(FXCollections.observableList(Data.lstLocators));
        cbEmployerOnlineSearch.setItems(FXCollections.observableList(Data.lstRecruiterNames));
        cbWorkingLocationOnlineSearch.setItems(FXCollections.observableList(Data.lstLocators));
        //------------------------------------------
        cbCVDateTop.setItems(FXCollections.observableList(Arrays.asList("None")));
        cbTitlesTop.setItems(FXCollections.observableList(Arrays.asList("None")));
        cbExpTop.setItems(FXCollections.observableList(Arrays.asList("None")));
        cbLabelTop.setItems(FXCollections.observableList(Arrays.asList("None")));
        cbReferralTop.setItems(FXCollections.observableList(Arrays.asList("None")));
    } 
    
    //Update data to controls after searching
    private void refreshData(){
        cbCVDateTop.setItems(FXCollections.observableList(Data.lstCVDate));
        cbTitlesTop.setItems(FXCollections.observableList(Data.lstTitles));
        cbExpTop.setItems(FXCollections.observableList(Data.lstExperiences));
        cbLabelTop.setItems(FXCollections.observableList(Data.lstLabels));
        cbReferralTop.setItems(FXCollections.observableList(Data.lstReferrals));
        lstCandidates = FXCollections.observableArrayList(Data.lstCandidateModel);
        tbData.setItems(lstCandidates); 
        tbData.refresh();
    }
 //Action control --------------------------------------------------
    @FXML
    void HandleSearchDB(MouseEvent event) {
        System.out.println("HandleSearchDB!");
    }

    @FXML
    void HandleSearchFolder(MouseEvent event) {
        System.out.println("HandleSearchFolder!");
    
    }

    @FXML
    void HandleSearchOnline(MouseEvent event) {
        System.out.println("HandleSearchOnline!");
        txt_cbEmloyerOnlinesearch = cbEmployerOnlineSearch.getSelectionModel().getSelectedItem();
        txt_search = txtSearchKeywordOnlineSearch.getText();
        txt_cbLastResumeUpdateOnlineSearch = cbLastResumeUpdateOnlineSearch.getSelectionModel().getSelectedItem();
        txt_ExpFrom = txtExperienceFromOnlineSearch.getText();
        txt_ExpTo = txtExperienceToOnlineSearch.getText();
        txt_cbWorkingLocationOnlineSearch = cbWorkingLocationOnlineSearch.getSelectionModel().getSelectedItem();
        Recruitment_Online orecruiter_onl;
        if (txt_cbEmloyerOnlinesearch.equalsIgnoreCase("VietNamWork")) {
            orecruiter_onl = new Recruitment_VietNamWork();
            orecruiter_onl.Filter();
        }
        Data.Update();
        refreshData();
    }

}
