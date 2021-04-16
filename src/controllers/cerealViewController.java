package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.BowlOfCereal;
import models.Cereal;
import utilities.startingCereals;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cerealViewController implements Initializable {

    @FXML
    private ListView<Cereal> cerealsListView;

    @FXML
    private ListView<BowlOfCereal> bowlsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cerealsListView.getItems().addAll(startingCereals.getStartingCereals());
    }

    @FXML
    private void addCerealButtonPushed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/newCerealView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add a new Cereal");
        stage.show();
    }

    @FXML
    private void addBowlButtonPushed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/newBowlOfCerealView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Add a new Bowl");
        stage.show();
    }

    @FXML
    private void refreshCerealButtonPushed(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Cereal newCereal = (Cereal) stage.getUserData();
        if(newCereal != null) {
            cerealsListView.getItems().add(newCereal);
            stage.setUserData(null);
        }
    }

    @FXML
    private void refreshBowlButtonPushed(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        BowlOfCereal newBowl = (BowlOfCereal) stage.getUserData();
        if(newBowl != null) {
            bowlsListView.getItems().add(newBowl);
            stage.setUserData(null);
        }
    }
}
