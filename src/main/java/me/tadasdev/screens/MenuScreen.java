package me.tadasdev.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import me.tadasdev.screens.refactorScreens.AddToLibrary;
import me.tadasdev.screens.usersScreen.AuthorScreen;
import me.tadasdev.screens.usersScreen.BookScreen;


public class MenuScreen{

    //App app = new App();



    public static void menuScreen(Stage stage){
        AuthorScreen authorScreen = new AuthorScreen();
        BookScreen bookScreen = new BookScreen();
        AddToLibrary addToLibrary = new AddToLibrary();
        VBox root = new VBox();

        
        //TextField welcomeToLibrary = new TextField("Welcome To Books Library");

        Label welcomeToLibrary = new Label("Welcome To Books Library");
        //welcomeToLibrary.setMinHeight(50);
        welcomeToLibrary.setFont(new Font(15));

        root.getChildren().add(welcomeToLibrary);
        //root.setAlignment(Pos.TOP_CENTER);

        Label menu = new Label("Menu");
        menu.setFont(new Font(20));

        Button authorsButton = new Button("Author");
        authorsButton.setMinWidth(200);
        authorsButton.setMinHeight(50);
        authorsButton.setOnAction(action -> {
            authorScreen.authorsScreen(stage);
            //System.out.println(stage.isMaximized());
        });

        Button booksButton = new Button("Books");
        booksButton.setMinWidth(200);
        booksButton.setMinHeight(50);
        booksButton.setOnAction(event -> {
            bookScreen.booksScreen(stage);
        });

        Button addToLibraryButton = new Button("Add to Library");
        addToLibraryButton.setMinWidth(200);
        addToLibraryButton.setMinHeight(50);
        addToLibraryButton.setOnAction(event -> {
            addToLibrary.addToLibrary(stage);
        });

        Button updateLibraryButton = new Button("Update Library");
        updateLibraryButton.setMinWidth(200);
        updateLibraryButton.setMinHeight(50);
        updateLibraryButton.setOnAction(event -> {

        });

        Button deleteLibraryButton = new Button("Delete from Library");
        deleteLibraryButton.setMinHeight(50);
        deleteLibraryButton.setMinWidth(200);
        deleteLibraryButton.setOnAction(event -> {

        });

        root.getChildren().addAll(menu, authorsButton, booksButton,
                addToLibraryButton, updateLibraryButton, deleteLibraryButton);
        root.setSpacing(10);

        root.setAlignment(Pos.CENTER);

        //body.setCenterShape(true);

        /*root.getChildren().addAll(head, body);
        root.setAlignment(Pos.CENTER);*/

        root.setMinSize(500,500);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();


    }

}
