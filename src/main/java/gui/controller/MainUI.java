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
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import objmodels.GUIModel;

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
//    private ObservableList<GUIModel> GUIModels = FXCollections.observableArrayList(
//            new GUIModel(1, "Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
//            new GUIModel(2, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
//            new GUIModel(3, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
//            new GUIModel(4, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890)
//    );
    private ObservableList<GUIModel> GUIModels=null;
    private List<GUIModel> getData() {
        List<GUIModel> listGuiModels = new ArrayList<>();
        GUIModel guimodels;
        for(int i=0;i< Data.lstCandidates.size();i++){
            String name=Data.lstCandidates.get(i).getName();
            String job=Data.lstCandidates.get(i).getJob_title();
            int experience= Integer.parseInt(Data.lstCandidates.get(i).getExp_year());
            String CV_link=Data.lstCandidates.get(i).getSrc_link();
            String skills=Data.lstCandidates.get(i).getSkill();
            String status=Data.lstCandidates.get(i).getStatus();
            String comment=Data.lstCandidates.get(i).getComment();
            String user=Data.lstCandidates.get(i).getUser();
            String label=Data.lstCandidates.get(i).getLabel();
            String cv_date=Data.lstCandidates.get(i).getLatest_upd();
            String location=Data.lstCandidates.get(i).getLocation();
            String referral=Data.lstCandidates.get(i).getReferral();
            String phone=Data.lstCandidates.get(i).getPhone();
            guimodels= new GUIModel(2,name, job, experience, CV_link, skills, status, comment, user,label, cv_date, location, referral, 1234567890);
            listGuiModels.add(guimodels);
        }
        return listGuiModels; 
    }
    
    //private ObservableList<String> lstAlls = FXCollections.observableArrayList("ConDien", "conkhung", "conMad");
    private FilteredList<String> lstAlls = null;
    private FilteredList<String> lstTitles = null;
    private FilteredList<String> lstStatus = null;
    private FilteredList<String> lstCVDates = null;
    private FilteredList<String> lstExperience = null;
    private FilteredList<String> lstLocations = null;
    private FilteredList<String> lstLabels = null;
    private FilteredList<String> lstReferrals = null;
    private FilteredList<String> listRecruiters = null;
    private FilteredList<String> lstResumeUpd = null;
    private FilteredList<String> listRecruiterNames = null;
    //private ObservableList<String> FilteredList;

    //----------------------------------------------------------------------- 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
        initFilterComboxes();
        initTableView();

    }

    private void initTableView() {
//        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setName(t.getNewValue());
            }
        }
        );
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        job.setCellFactory(TextFieldTableCell.forTableColumn());
        job.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setJob(t.getNewValue());
            }
        }
        );
        experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        experience.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        // TODO
//        experience.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
//                        ((GUIModel) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setExperience(Integer.parseInt(t.getNewValue()));
//                    }
//                }
//        );
        cv_link.setCellValueFactory(new PropertyValueFactory<>("cv_link"));
        cv_link.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_link.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setCv_link(t.getNewValue());
            }
        }
        );
        skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        skills.setCellFactory(TextFieldTableCell.forTableColumn());
        skills.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setSkills(t.getNewValue());
            }
        }
        );
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setStatus(t.getNewValue());
            }
        }
        );
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        comment.setCellFactory(TextFieldTableCell.forTableColumn());
        comment.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setComment(t.getNewValue());
            }
        }
        );
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        user.setCellFactory(TextFieldTableCell.forTableColumn());
        user.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setUser(t.getNewValue());
            }
        }
        );
        label.setCellValueFactory(new PropertyValueFactory<>("label"));
        label.setCellFactory(TextFieldTableCell.forTableColumn());
        label.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setLabel(t.getNewValue());
            }
        }
        );
        cv_date.setCellValueFactory(new PropertyValueFactory<>("cv_date"));
        cv_date.setCellFactory(TextFieldTableCell.forTableColumn());
        cv_date.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setCv_date(t.getNewValue());
            }
        }
        );
        can_location.setCellValueFactory(new PropertyValueFactory<>("can_location"));
        can_location.setCellFactory(TextFieldTableCell.forTableColumn());
        can_location.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setLocation(t.getNewValue());
            }
        }
        );
        referral.setCellValueFactory(new PropertyValueFactory<>("referral"));
        referral.setCellFactory(TextFieldTableCell.forTableColumn());
        referral.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
                ((GUIModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setReferral(t.getNewValue());
            }
        }
        );
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phone.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //TODO
//        phone.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<GUIModel, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<GUIModel, String> t) {
//                        ((GUIModel) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setName(t.getNewValue());
//                    }
//                }
//        );
        tbData.setItems(GUIModels);
    }

    private void LoadData() {
        // Test
        lstTitles = new FilteredList<String>(FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten"));
//        lstTitles = new FilteredList<String>(FXCollections.observableList(Data.lstTitles));
        lstStatus = new FilteredList<String>(FXCollections.observableList(Data.lstStatus));
        lstCVDates = new FilteredList<String>(FXCollections.observableList(Data.lstCVDate));
        lstExperience = new FilteredList<String>(FXCollections.observableList(Data.lstExperiences));
        lstLocations = new FilteredList<String>(FXCollections.observableList(Data.lstLocators));
        lstLabels = new FilteredList<String>(FXCollections.observableList(Data.lstLabels));
        lstReferrals = new FilteredList<String>(FXCollections.observableList(Data.lstReferrals));
        listRecruiterNames = new FilteredList<String>(FXCollections.observableList(Data.lstRecruiterNames));
        lstResumeUpd = new FilteredList<String>(FXCollections.observableList(Data.lstResumeUpdNames));
        GUIModels= FXCollections.observableArrayList(getData());
        tbData.setItems(GUIModels);
    }

    private void initFilterComboxes() {
        cbTitlesTop.setItems(lstTitles);
        cbEmployerOnlineSearch.setItems(listRecruiterNames);
        cbWorkingLocationOnlineSearch.setItems(lstLocations);
    }

    private void RefreshUI() {
        lstTitles = new FilteredList<String>(FXCollections.observableArrayList("One", "Two", "Three"));
        cbTitlesTop.setItems(lstTitles);
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
    }

}
