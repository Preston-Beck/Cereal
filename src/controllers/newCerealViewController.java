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
import models.Cereal;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class newCerealViewController implements Initializable {

    @FXML
    private TextField nameText;

    @FXML
    private TextField brandText;

    @FXML
    private ComboBox<String> cerealBaseComboBox;

    @FXML
    private RadioButton driedFruitNo;

    @FXML
    private ToggleGroup driedFruit;

    @FXML
    private RadioButton driedFruitYes;

    @FXML
    private RadioButton nutFreeYes;

    @FXML
    private ToggleGroup nutFree;

    @FXML
    private RadioButton nutFreeNo;

    @FXML
    private Slider caloriesSlider;

    @FXML
    private Slider servingsSlider;

    @FXML
    private Slider healthRatingSlider;

    @FXML
    private TextField ingredientsText;

    @FXML
    private Button saveCerealButton;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setText("");
        cerealBaseComboBox.getItems().addAll(
                "wheat",
                "maize",
                "corn",
                "oats",
                "millet",
                "barley",
                "rice",
                "rye",
                "sorghum");

    }

    @FXML
    void saveCerealButtonPushed(ActionEvent event) throws IOException {
        if(cerealBaseComboBox.getValue() != null) {
            try {
                boolean driedFruitBoolean = false;
                if (driedFruitYes.isSelected())
                    driedFruitBoolean = true;

                boolean nutFreeBoolean = false;
                if (nutFreeYes.isSelected())
                    nutFreeBoolean = true;

                String ingredientString = ingredientsText.getText();
                List<String> ingredients = Arrays.asList(ingredientString.split(", "));

                Cereal newCereal = new Cereal(nameText.getText(),
                        brandText.getText(),
                        cerealBaseComboBox.getValue(),
                        driedFruitBoolean,
                        nutFreeBoolean,
                        (int) caloriesSlider.getValue(),
                        (int) servingsSlider.getValue(),
                        (int) healthRatingSlider.getValue(),
                        ingredients);

                Parent root = FXMLLoader.load(getClass().getResource("../views/cerealView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setUserData(newCereal);
                stage.setScene(scene);
                stage.setTitle("Cereal Centre");
                stage.show();

            } catch (IllegalArgumentException e) {
                msgLabel.setText(e.getMessage());
            }
        }
        else{
            msgLabel.setText("Please select a valid Cereal Base.");
        }
    }
}
