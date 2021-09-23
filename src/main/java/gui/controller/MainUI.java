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
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Filter;

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
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import objmodels.GUIModel;
import objmodels.UpdateList;

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
    @FXML
    private TextField txtSearchKeywordOnlineSearch;
    public static String textsearch;
    @FXML
    private TextField txtExperienceFromOnlineSearch;
    public static String txtExpFrom;
    @FXML
    private TextField txtExperienceToOnlineSearch;
    public static String txtExpTo;
    @FXML
    private ComboBox<UpdateList> cbLastResumeUpdateOnlineSearch;
    @FXML
    private ComboBox<String> cbWorkingLocationOnlineSearch;
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
    // Variable --------------------------------------------------------------
    private FilteredList<GUIModel> GUIModels = null;
    private FilteredList<String> lstTitles = null;
    private FilteredList<String> lstCVDates = null;
    private FilteredList<String> lstExperience = null;
    private FilteredList<String> lstLabels = null;
    private FilteredList<String> lstReferrals = null;

    // Constant --------------------------------------------------------------
    private ObservableList<String> lstLocations = null;
    private ObservableList<String> lstRecruiters = null;
    private ObservableList<String> lstRecruiterNames = null;
    private ObservableList<String> lstStatus = null;
    private ObservableList<UpdateList> lstResumeUpd = null;

    //-----------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createDataModel();
        initConstantFilter();
        initTableView();
        refresh();
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
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setJob(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setCv_link(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setSkills(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setStatus(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setComment(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setUser(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setLabel(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setCv_date(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setLocation(t.getNewValue());
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
                                t.getTablePosition().getRow())
                        ).setReferral(t.getNewValue());
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
    }

    private void initConstantFilter() {
        cbEmployerOnlineSearch.setItems(lstRecruiterNames);
        cbLastResumeUpdateOnlineSearch.setConverter(new StringConverter<UpdateList>() {

            @Override
            public String toString(UpdateList object) {
                return object.getDay();
            }

            @Override
            public UpdateList fromString(String string) {
                return cbLastResumeUpdateOnlineSearch.getItems().stream().filter(ap ->
                        ap.getDay().equals(string)).findFirst().orElse(null);
            }
        });
        cbLastResumeUpdateOnlineSearch.setItems(lstResumeUpd);
        cbLocationTop.setItems(lstLocations);
    }

    private void createDataModel() {
        // Test
        Data.loadDefinitionData();
        GUIModels = new FilteredList<GUIModel>(FXCollections.observableArrayList(
                new GUIModel(1, "Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new GUIModel(2, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new GUIModel(3, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890),
                new GUIModel(4, "Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890)
        ));
        lstTitles = new FilteredList<String>(FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten"));
//        lstTitles = new FilteredList<String>(FXCollections.observableList(Data.lstTitles));
        lstCVDates = new FilteredList<String>(FXCollections.observableList(Data.lstCVDate));
        lstExperience = new FilteredList<String>(FXCollections.observableList(Data.lstExperiences));
        lstLabels = new FilteredList<String>(FXCollections.observableList(Data.lstLabels));
        lstReferrals = new FilteredList<String>(FXCollections.observableList(Data.lstReferrals));

        lstLocations = FXCollections.observableList(Data.lstLocators);
        ObservableList <UpdateList> updateList = FXCollections.observableArrayList();
        for(Map.Entry<String, String> e : Data.lstResumeUpd.entrySet()){
            System.out.println(e.getValue() + e.getKey());
            updateList.addAll(new UpdateList(e.getValue(), e.getKey()));
        }
        lstResumeUpd = FXCollections.observableList(updateList);
        lstStatus = FXCollections.observableList(Data.lstStatus);
        lstRecruiterNames = FXCollections.observableList(Data.lstRecruiterNames);
    }

    private void refresh() {
        cbTitlesTop.setItems(lstTitles);
        cbStatusTop.setItems(lstStatus);
        cbCVDateTop.setItems(lstCVDates);
        cbExpTop.setItems(lstExperience);
        cbLabelTop.setItems(lstLabels);
        cbReferralTop.setItems(lstReferrals);
        tbData.setItems(GUIModels);
    }

    //Action control --------------------------------------------------
    @FXML
    void HandleSearchDB(MouseEvent event) {
        System.out.println("HandleSearchDB!");
        lstTitles = new FilteredList<String>(FXCollections.observableArrayList("One", "Two", "Three"));
        refresh();
    }

    @FXML
    void HandleSearchFolder(MouseEvent event) {
        System.out.println("HandleSearchFolder!");
    }

    @FXML
    void HandleSearchOnline(MouseEvent event) {
        System.out.println("HandleSearchOnline!");
        Recruitment_Online orecruiter_onl;
        if (cbEmployerOnlineSearch.getSelectionModel().getSelectedItem().equalsIgnoreCase("VietNamWork")) {
            orecruiter_onl = new Recruitment_VietNamWork();
            orecruiter_onl.Filter();
        }
    }

}
