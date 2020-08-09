package me.tadasdev.screens.refactorScreens;

import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.tadasdev.repositories.BookRepository;
import me.tadasdev.screens.MenuScreen;
import me.tadasdev.users.Book;

import java.util.List;


public class AddToLibrary {

    public void addToLibrary(Stage stage){
        BookRepository bookRepository = new BookRepository();

        VBox root = new VBox();
        VBox nameVBox = new VBox();
        VBox surnameVBox = new VBox();

        Label addToLibraryText = new Label("Add To Library");
        addToLibraryText.setFont(new Font(25));
        addToLibraryText.setStyle("-fx-font-weight: bold");

        Label titleText = new Label("Title");
        titleText.setFont(new Font(12));
        titleText.setStyle("-fx-font-weight: bold");

        Label authorText = new Label("Author");
        authorText.setFont(new Font(12));
        authorText.setStyle("-fx-font-weight: bold");

        HBox authorTextHBox = new HBox();

        Label authorNameText = new Label("Author Name");
        authorNameText.setFont(new Font(12));
        authorNameText.setStyle("-fx-font-weight: bold");

        Label authorSurnameText = new Label("Author Surname");
        authorSurnameText.setFont(new Font(12));
        authorSurnameText.setStyle("-fx-font-weight: bold");

        authorTextHBox.getChildren().addAll(authorNameText, authorSurnameText);
        authorTextHBox.setSpacing(15);
        authorTextHBox.setAlignment(Pos.CENTER);

        Label descriptionText = new Label("Description");
        descriptionText.setFont(new Font(12));
        descriptionText.setStyle("-fx-font-weight: bold");

        TextField titleField = new TextField();
        titleField.setMaxWidth(200);

        HBox authorHBox = new HBox();
        TextField authorNameField = new TextField();
        TextField authorSurnameField = new TextField();


        nameVBox.getChildren().addAll(authorNameText, authorNameField);
        nameVBox.setAlignment(Pos.CENTER);
        nameVBox.setSpacing(5);

        surnameVBox.getChildren().addAll(authorSurnameText, authorSurnameField);
        surnameVBox.setAlignment(Pos.CENTER);
        surnameVBox.setSpacing(5);

        authorHBox.getChildren().addAll(nameVBox, surnameVBox);
        authorHBox.setAlignment(Pos.CENTER);
        authorHBox.setSpacing(5);

        TextArea descriptionField = new TextArea();
        descriptionField.setPrefHeight(100);
        descriptionField.setMaxWidth(350);
        descriptionField.setWrapText(true);


        HBox buttonsHBox = new HBox();

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            if(!titleField.getText().isEmpty()){
                Book book = new Book();
                if(ifTitleExist(titleField.getText())){
                    bookRepository.addToBookLibrary(titleField.getText(), authorNameField.getText(), authorSurnameField.getText(), descriptionField.getText());


                }else{
                    Label titleError = new Label("The title is already existing");
                    Scene scene1 = new Scene(titleError);
                    Stage stage1 = new Stage();
                    stage1.setScene(scene1);
                    stage1.setMinHeight(100);
                    stage1.setMinWidth(100);

                    stage1.initModality(Modality.WINDOW_MODAL);
                    stage1.initOwner(stage);
                    stage1.show();
                    System.out.println("The title is already existing");
                }
            }else {
                Label titleError = new Label("Title can't be empty");
                Scene scene1 = new Scene(titleError);
                Stage stage1 = new Stage();
                stage1.setScene(scene1);
                stage1.setMinHeight(100);
                stage1.setMinWidth(100);

                stage1.initModality(Modality.WINDOW_MODAL);
                stage1.initOwner(stage);
                stage1.show();

                System.out.println("Title can't be empty");
            }

        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            MenuScreen.menuScreen(stage);
        });

        buttonsHBox.getChildren().addAll(backButton,addButton);
        buttonsHBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(addToLibraryText, titleText, titleField, authorText, authorHBox, descriptionText, descriptionField, buttonsHBox);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setMinSize(500,500);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean ifTitleExist(String title){
        BookRepository bookRepository = new BookRepository();
        List<Book> bookList = bookRepository.getListByTitle(title);

        return bookList.isEmpty();
    }
}
