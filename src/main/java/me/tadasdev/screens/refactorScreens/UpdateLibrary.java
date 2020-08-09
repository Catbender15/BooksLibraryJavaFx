package me.tadasdev.screens.refactorScreens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import me.tadasdev.screens.MenuScreen;
import me.tadasdev.screens.usersScreen.AuthorScreen;
import me.tadasdev.screens.usersScreen.BookScreen;

public class UpdateLibrary {

    public void updateLibrary(Stage stage){
        VBox root = new VBox();
        Label whatYouWantUpdate = new Label("What do you want update?");
        whatYouWantUpdate.setFont(new Font(15));

        Button updateAuthor = new Button("Author");
        updateAuthor.setOnAction(event -> {
            AuthorScreen authorScreen = new AuthorScreen();
            authorScreen.authorsScreen(stage, true, true);
        });
        updateAuthor.setMinWidth(200);
        updateAuthor.setMinHeight(50);

        Button updateBook = new Button("Book");
        updateBook.setOnAction(event -> {
            BookScreen bookScreen = new BookScreen();
            bookScreen.booksScreen(stage, true);
        });
        updateBook.setMinWidth(200);
        updateBook.setMinHeight(50);

        Button menuButton = new Button("Menu");
        menuButton.setMinWidth(200);
        menuButton.setMinHeight(50);
        menuButton.setOnAction(event -> {
            MenuScreen.menuScreen(stage);
        });

        root.getChildren().addAll(whatYouWantUpdate, updateAuthor, updateBook, menuButton);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.setMinSize(500,500);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.show();
    }


}
