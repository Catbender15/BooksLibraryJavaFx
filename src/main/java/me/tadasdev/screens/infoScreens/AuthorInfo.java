package me.tadasdev.screens.infoScreens;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.tadasdev.users.Author;

public class AuthorInfo {
    public static void authorInfo(Stage stage, Author author){
        VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        editingStage(stage);
        stage.show();
    }

    private static void editingStage(Stage stage){
        stage.setMinHeight(500);
        stage.setMinWidth(500);
    }
}
