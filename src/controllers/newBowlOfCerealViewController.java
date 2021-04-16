package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.BowlOfCereal;
import models.Cereal;
import utilities.startingCereals;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newBowlOfCerealViewController implements Initializable {

    @FXML
    private ComboBox<String> milkTypeComboBox;

    @FXML
    private ComboBox<Cereal> cerealComboBox;

    @FXML
    private Slider bowlSizeSlider;

    @FXML
    private RadioButton freshFruitYes;

    @FXML
    private ToggleGroup freshFruit;

    @FXML
    private RadioButton freshFruitNo;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setText("");
        milkTypeComboBox.getItems().addAll(
                "whole milk",
                "skim milk",
                "low-fat milk",
                "oat milk",
                "almond milk");
        cerealComboBox.getItems().addAll(startingCereals.getStartingCereals());
    }

    @FXML
    void saveBowlButtonPushed(ActionEvent event) throws IOException {
        if(milkTypeComboBox.getValue() == null){
            msgLabel.setText("Please choose a milk type.");
        }
        else if(cerealComboBox.getValue() == null){
            msgLabel.setText("Please choose a cereal.");
        }
        else {
            try {
                boolean freshFruitBoolean = false;
                if (freshFruitYes.isSelected())
                    freshFruitBoolean = true;

                ArrayList<Cereal> cereal = new ArrayList<>();
                cereal.add(cerealComboBox.getValue());

                BowlOfCereal newBowl = new BowlOfCereal(
                        milkTypeComboBox.getValue(),
                        (int) bowlSizeSlider.getValue(),
                        freshFruitBoolean,
                        cereal
                );

                Parent root = FXMLLoader.load(getClass().getResource("../views/cerealView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(newBowl);
                stage.setScene(scene);
                stage.setTitle("Cereal Centre");
                stage.show();

            } catch (IllegalArgumentException e) {
                msgLabel.setText(e.getMessage());
            }
        }
    }
}
