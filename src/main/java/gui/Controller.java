/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author nyak
 */
public class Controller implements Initializable {

    @FXML
    private TableView<Model> tbData;
    @FXML
    public TableColumn<Model, Integer> id;
    @FXML
    public TableColumn<Model, String> name;
    @FXML
    public TableColumn<Model, String> job;
    @FXML
    public TableColumn<Model, Integer> experience;
    @FXML
    public TableColumn<Model, String> cv_link;
    @FXML
    public TableColumn<Model, String> skills;
    @FXML
    public TableColumn<Model, String> status;
    @FXML
    public TableColumn<Model, String> comment;
    @FXML
    public TableColumn<Model, String> user;
    @FXML
    public TableColumn<Model, String> label;
    @FXML
    public TableColumn<Model, String> cv_date;
    @FXML
    public TableColumn<Model, String> can_location;
    @FXML
    public TableColumn<Model, String> referral;
    @FXML
    public TableColumn<Model, Integer> phone;


    public Controller()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        tbData.setItems(models);
    }

    private ObservableList<Model> models = FXCollections.observableArrayList(
            new Model(1,"Nhac", "Developer", 3, "google", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890 ),
            new Model(2,"Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890 ),
            new Model(3,"Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890 ),
            new Model(4,"Nhac", "Developer", 3, "google.com", "abc", "In progress", "none", "somebody", "test", "2021-09-09", "HCMC", "VNWork", 1234567890 )
    );

    public void HandleSearchOnline(MouseEvent mouseEvent) {
    }

    public void HandleSearchFolder(MouseEvent mouseEvent) {
    }

    public void HandleSearchDB(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown()){

        }
    }
}