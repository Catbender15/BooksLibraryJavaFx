package me.tadasdev;

import javafx.application.Application;
import javafx.stage.Stage;
import me.tadasdev.db.SessionManager;
import me.tadasdev.repositories.AuthorRepository;
import me.tadasdev.screens.infoScreens.BookInfo;
import me.tadasdev.screens.usersScreen.AuthorScreen;
import me.tadasdev.screens.usersScreen.BookScreen;
import me.tadasdev.screens.ErrorScreen;
import me.tadasdev.screens.MenuScreen;


public class App extends Application {

    /*ObservableList<Author> authorsList = FXCollections.observableArrayList(AuthorRepository.getAllList());
    */ AuthorRepository authorRepository = new AuthorRepository();
    //String screen = "Menu";
//    public String stackName = "First Name";

    MenuScreen menuScreen = new MenuScreen();
    AuthorScreen authorScreen = new AuthorScreen();
    BookScreen bookScreen = new BookScreen();
    ErrorScreen errorScreen = new ErrorScreen();
    BookInfo bookInfo = new BookInfo();



    public static void main(String[] args) {
        App.launch();
    }

    @Override
    public void start(Stage stage){
        menuScreen.menuScreen(stage);

        //authorScreen.authorsScreen(stage, true, true);
        //authorRepository.deleteById(1);
        //bookScreen.booksScreen(stage);
    }

    /*public void loadScreen(Stage stage){
        if(screen.equals("Menu")){
            menuScreen.menuScreen(stage);
        }else if (screen.equals("authorsScreen")){
            authorScreen.authorsScreen(stage);
        }else if (screen.equals("bookssScreen")){
            booksScreen.booksScreen(stage);
        }else{
            errorScreen.errorScreen(stage);
        }
    }*/

    @Override
    public void stop() throws  Exception{
        System.out.print("Program stop work");
        SessionManager.shutdown();
    }

    /*public void changeScreen(String name){
        screen = name;
    }*/
}
