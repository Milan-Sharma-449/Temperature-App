package com.example.temperature_app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label wel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button btnC;

    private static final String C_To_F = "Celsius To Fahrenheit";
    private static final String F_To_C = "Fahrenheit To Celsius";
    private boolean isC_To_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_To_F);
        choiceBox.getItems().add(F_To_C);
        choiceBox.setValue(C_To_F);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->                // s belongs to old value and t1 is new value
        {
            if (t1.equals((C_To_F)))
                isC_To_F = true;
            else isC_To_F = false;
        });

        btnC.setOnAction(actionEvent -> {
            convert();
        });
    }

    private void convert() {
        String input = textField.getText();
        float enteredTemperature=0.0f;
        try {
            enteredTemperature = Float.parseFloat(input);
        } catch (Exception exception){
            warnUser();
            return;
        }


        float newTemperature = 0.0f;
        if(isC_To_F){
            newTemperature =(enteredTemperature * 9 / 5)+32;
        }else {
            newTemperature = (enteredTemperature-32) *5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Text Entered");
        alert.setContentText("Please enter the valid temperature");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit=isC_To_F?" F" : " C";

        System.out.println("The new Temperature is: " + newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText("Message");
        alert.setContentText("The new Temperature is: " + newTemperature + unit);
        alert.show();
    }
}
