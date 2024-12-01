package com.simulator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.io.IOException;
import java.io.File;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();

        scene = new Scene(root, 1440, 810);
        stage.setScene(scene);
        displayBackground(root);
        displaySidebar(root);
    
        stage.show();
    }

    private void displayBackground(Group root) {
        Stop[] stops = new Stop[] {new Stop(0, Color.web("474959")), new Stop(1, Color.web("3b3142"))};
        LinearGradient myGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        scene.setFill(myGradient);

        Image logo = new Image(new File("survivorsimulator/src/main/resources/images/JungleSilhouette.png").toURI().toString());
        ImageView view = new ImageView(logo);
        view.setY(655);
        view.setOpacity(0.5);

        root.getChildren().add(view);

    }

    private void displaySidebar(Group root) {
        Image menu = new Image(new File("survivorsimulator/src/main/resources/images/Menu.png").toURI().toString());
        ImageView view = new ImageView(menu);
        view.setX(-85);
        view.setY(-75);
        view.setScaleX(0.15);
        view.setScaleY(0.15);
        view.setOpacity(0.8);

        Rectangle select = new Rectangle(45, 45);
        select.setX(15);
        select.setY(15);
        select.setOpacity(0);

        select.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
            root.getChildren().remove(view);
            displayEpisodes(root);
        });

        root.getChildren().add(view);
        root.getChildren().add(select);
    }

    private void displayEpisodes(Group root) {
        Rectangle sidebar = new Rectangle(250, 1000);
        sidebar.setFill(Color.BLACK);
        sidebar.setOpacity(0.75);

        Image menu = new Image(new File("survivorsimulator/src/main/resources/images/Menu.png").toURI().toString());
        ImageView view = new ImageView(menu);
        view.setX(85);
        view.setY(-75);
        view.setScaleX(0.15);
        view.setScaleY(0.15);
        view.setOpacity(0.8);

        Rectangle select = new Rectangle(45, 45);
        select.setX(185);
        select.setY(15);
        select.setOpacity(0);

        select.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
            root.getChildren().remove(view);
            root.getChildren().remove(sidebar);
            root.getChildren().remove(select);
            displaySidebar(root);
        });

        root.getChildren().addAll(sidebar, view, select);
    }


}