package com.example.temperature_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");                                            // Application start running

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();                                          // Currently Vbox is our main stage

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature App");
        primaryStage.show();

    }
    private MenuBar createMenu()
    {
        Menu fileMenu = new Menu("File");                                        // File Menu
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu icon click"));

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();               // separator line

        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> {                                   // lambda notation of on click listner
            System.out.println("Quitting");
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem, quitMenuItem);

        Menu helpMenu = new Menu("Help");                                         // Help Menu
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {                  // on click listner
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutApp();
            }
        });
        helpMenu.getItems().addAll(aboutMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);                         // alert Dialog
        alertDialog.setTitle("My first Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just beginner but soon i will be pro");

    }
}
