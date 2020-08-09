package me.tadasdev.screens.infoScreens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import me.tadasdev.screens.MenuScreen;
import me.tadasdev.screens.usersScreen.BookScreen;
import me.tadasdev.users.Book;



public class BookInfo {

    public void bookInfo(Stage stage, Book book){
        BookScreen bookScreen = new BookScreen();
        Button backButton = new Button("back");
        backButton.setOnAction(event -> {
            bookScreen.booksScreen(stage, false);
        });
        Button menuButton = new Button("Menu");
        menuButton.setOnAction(event -> {
            MenuScreen.menuScreen(stage);
        });
        //backButton.setAlignment(Pos.TOP_LEFT);
        HBox buttonHBox = new HBox();
        buttonHBox.getChildren().addAll(menuButton, backButton);
        buttonHBox.setSpacing(5);

        VBox root = new VBox();
        VBox descriptionVBox = new VBox();


        Label title = new Label("Title: " + book.getTitle());
        title.setFont(new Font(20));
        title.setStyle("-fx-font-weight: bold");

        Label authorsLabel = new Label("Author:");
        authorsLabel.setFont(new Font(14));
        authorsLabel.setStyle("-fx-font-weight: bold; -fx-border-style: solid; -fx-background-color: white;");
        /*authors.setStyle("-fx-border-style: solid");
        authors.setStyle("-fx-background-color: white");*/

        Label authorLabel = new Label(book.getAuthor());
        authorLabel.setStyle("-fx-border-style: solid");
        authorLabel.setStyle("-fx-background-color: white");

        Label description = new Label(book.getDescriptions());
        description.setWrapText(true);
        //description.setStyle("-fx-border-style: solid;");
        descriptionVBox.getChildren().add(description);
        descriptionVBox.setAlignment(Pos.CENTER);
        //descriptionVBox.setMinWidth(100);
        descriptionVBox.setMaxWidth(300);
        descriptionVBox.setMinSize(100, 100);
        descriptionVBox.setStyle("-fx-background-color: white;");


        //description.setStyle("-fx-background-color: white;-fx-border-style: solid;-fx-border-color: black;");
        /*description.setStyle("-fx-border-color: black;");
        description.setStyle("-fx-border-width: 3;");*/

        Label id = new Label(String.valueOf("Id: " + book.getId_books()));
        root.getChildren().add(buttonHBox);
        root.getChildren().addAll(id, title, authorsLabel, authorLabel, descriptionVBox);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        /*root.setMinHeight(500);
        root.setMinWidth(500);*/
        //root.setMaxHeight(500);

        root.setStyle("-fx-background-color: green;");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);

        stage.show();
    }
}
