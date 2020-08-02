package me.tadasdev.screens.usersScreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import me.tadasdev.repositories.AuthorRepository;
import me.tadasdev.repositories.BookRepository;
import me.tadasdev.screens.MenuScreen;
import me.tadasdev.users.Author;
import me.tadasdev.users.Book;


public class BookScreen {
    ObservableList<Book> booksList = FXCollections.observableArrayList(BookRepository.getAllBooksList());
    TableView<Book> booksTable = new TableView<>();
    private String stackName = "Title";

    public void booksScreen(Stage stage){

        TableView bookTableView = this.bookTableView();

        Button backButton =  new Button("back");
        backButton.setOnAction(event -> {
            MenuScreen.menuScreen(stage);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(backButton);
        vBox.getChildren().add(addSearchBar(stage));
        vBox.getChildren().add(bookTableView);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    public TableView bookTableView(){
        //TableView<Book> booksTable = this.booksTable;
        ObservableList<Book> booksList = this.booksList;

        TableColumn<Book, Integer> id = new TableColumn<>("Id");
        //TableColumn<Book, String> title = new TableColumn<>("Title");
        TableColumn<Book, String> descriptions = new TableColumn<>("Description");
        TableColumn<Book, String> author = new TableColumn<>("Author");

        id.setCellValueFactory(new PropertyValueFactory<>("id_books"));
        id.setMinWidth(30);

        descriptions.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
        descriptions.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptions.setMinWidth(80);

        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        author.setCellFactory(TextFieldTableCell.forTableColumn());
        author.setMinWidth(80);

        //booksTable.getColumns().setAll(id, deleteButton(), descriptions, book);
        booksTable.getColumns().setAll(id, titleLink(), descriptions, author);
        booksTable.prefWidth(20);
        booksTable.setItems(booksList);


        return booksTable;
    }

    public TableColumn<Book, String> titleLink(){
        TableColumn<Book, String> title = new TableColumn<>("Title");
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        title.setMinWidth(80);

        Callback<TableColumn<Book, String>, TableCell<Book, String>> cellFactory
                = //
                new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Book, String> param) {
                        final TableCell<Book, String> cell = new TableCell<Book, String>() {

                            private Hyperlink link = new Hyperlink("Error");


                            {
                                //link.setText();
                                link.setOnAction(event -> {
                                    Book book = getTableView().getItems().get(getIndex());
                                    System.out.println(book.getTitle());
                                });

                            }




                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);

                                } else {
                                    Book book = getTableView().getItems().get(getIndex());
                                    link.setText(book.getTitle());
                                    setGraphic(link);

                                }
                            }
                        };
                        return cell;
                    }
                };
        title.setCellFactory(cellFactory);
       // booksTable.getColumns().add(title);
        return title;

    }

    public HBox addSearchBar(Stage stage){

        HBox root = new HBox();
        HBox choiseHBox = new HBox();
        HBox hSearchBox = new HBox();

        TextField searchField = new TextField("");
        Button button = new Button("Search");




        ChoiceBox<String> searchChoiceBox = new ChoiceBox();

        Label searchBy = new Label("SearchBy");


        searchChoiceBox.getItems().addAll("Id", "Title", "Author");
        searchChoiceBox.setValue(stackName);

        choiseHBox.getChildren().addAll(searchBy, searchChoiceBox);
        choiseHBox.setSpacing(5);

        hSearchBox.getChildren().addAll(searchField, button);
        hSearchBox.setFillHeight(true);

        button.setOnAction(event -> {
            if(searchChoiceBox.getValue().equals("Id")){
                booksList = FXCollections.observableArrayList(BookRepository.getListById(searchField.getText()));
            }else if(searchChoiceBox.getValue().equals("Author")){
                booksList = FXCollections.observableArrayList(BookRepository.getListByAuthors(searchField.getText()));
            }else{
                booksList = FXCollections.observableArrayList(BookRepository.getListByTitle(searchField.getText()));
            }
            stackName = searchChoiceBox.getValue();
            booksScreen(stage);
        });

        searchField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                button.fire();
            }
        });


        root.getChildren().addAll(choiseHBox, hSearchBox);
        root.setSpacing(5);
        root.setPadding(new Insets(5,0,0,0));

        return root;
    }

}
