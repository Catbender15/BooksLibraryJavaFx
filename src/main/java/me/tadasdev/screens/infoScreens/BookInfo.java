package me.tadasdev.screens.infoScreens;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import me.tadasdev.users.Book;



public class BookInfo {

    public void bookInfo(Stage stage, Book book){
        VBox root = new VBox();

        Label title = new Label(book.getTitle());
        title.setFont(new Font(20));
        title.setStyle("-fx-font-weight: bold");

        Label authors = new Label("Authors:");
        authors.setFont(new Font(14));
        authors.setStyle("-fx-font-weight: bold");
        authors.setStyle("-fx-border-style: solid");
        authors.setStyle("-fx-background-color: white");

        Label author = new Label(book.getAuthor());
        author.setStyle("-fx-border-style: solid");
        author.setStyle("-fx-background-color: white");

        Label description = new Label(book.getDescriptions());
        //description.setStyle("-fx-border-style: solid;");


        description.setStyle("-fx-background-color: white;-fx-border-style: solid;-fx-border-color: black;");
        /*description.setStyle("-fx-border-color: black;");
        description.setStyle("-fx-border-width: 3;");*/

        Label id = new Label(String.valueOf(book.getId_books()));

        root.getChildren().addAll(title, authors, author, description, id);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();
    }
}
