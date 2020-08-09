package me.tadasdev.screens.usersScreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import me.tadasdev.repositories.AuthorRepository;
import me.tadasdev.screens.MenuScreen;
import me.tadasdev.screens.refactorScreens.UpdateLibrary;
import me.tadasdev.users.Author;

import javax.persistence.Table;
import javax.persistence.criteria.Selection;


public class AuthorScreen {
    ObservableList<Author> authorsList = FXCollections.observableArrayList(AuthorRepository.getAllList());


    TableView<Author> authorTable = new TableView<>();
    TableView<Author> authorTableView = authorTable;
    public String stackName = "First Name";

    public void authorsScreen(Stage stage, boolean deleteButtonBool, boolean updateButtonBool){

        TableView tableView = this.tableView(deleteButtonBool, updateButtonBool);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            if(deleteButtonBool || updateButtonBool){
                UpdateLibrary updateLibrary = new UpdateLibrary();
                updateLibrary.updateLibrary(stage);
            }else{
                MenuScreen.menuScreen(stage);
            }
        });
        Button addButton = new Button("add");
        TextField firstNamee = new TextField();
        TextField lastNamee = new TextField();

        addButton.setOnAction(event -> {
            AuthorRepository.addAuthor(firstNamee.getText(), lastNamee.getText());
            firstNamee.setText("");
            lastNamee.setText("");
            ObservableList<Author> authorList = FXCollections.observableArrayList(AuthorRepository.getAllList());
            authorTable.setItems(authorList);
        });
        HBox hBox = new HBox();
        hBox.getChildren().addAll(firstNamee, lastNamee, addButton);

        VBox root = new VBox();
        root.getChildren().addAll(backButton);
        root.getChildren().add(addSearchBar(stage, deleteButtonBool, updateButtonBool));
        root.getChildren().add(tableView);
        root.getChildren().add(hBox);
        root.setMinSize(500,500);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();

    }

    public TableView tableView(boolean deleteButtonBool, boolean updateButtonBool){
        ObservableList<Author> authorsList = this.authorsList;

        TableColumn<Author, Integer> id = new TableColumn<>("Id");
        TableColumn<Author, String> firstName = new TableColumn<>("First_Name");
        TableColumn<Author, String> lastName = new TableColumn<>("Last_Name");

        id.setCellValueFactory(new PropertyValueFactory<>("id_authors"));
        id.setMinWidth(30);

        firstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setMinWidth(80);
        firstName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Author, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Author, String> t) {
                        ((Author) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirst_name(t.getNewValue());
                    }
                }
        );

        lastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setMinWidth(80);
        lastName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Author, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Author, String> event) {
                        ((Author) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setLast_name(event.getNewValue());
                    }
                }
        );

        authorTable.getColumns().setAll(id, firstName, lastName);
        //authorTable.prefWidth(20);
        authorTable.setItems(authorsList);
        if(deleteButtonBool){
            deleteButton();
        }
        if(updateButtonBool){
            authorTable.setEditable(true);
            updateButton();

        }else{
            authorTable.setEditable(false);
        }

        return authorTable;
    }

    public void deleteButton(){
        TableColumn<Author, Void> buttons = new TableColumn("Delete");
        buttons.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Author, Void>, TableCell<Author, Void>> cellFactory
                = //
                new Callback<TableColumn<Author, Void>, TableCell<Author, Void>>() {
                    @Override
                    public TableCell call(final TableColumn<Author, Void> param) {
                        final TableCell<Author, Void> cell = new TableCell<Author, Void>() {

                            final Button button123 = new Button("Delete");

                            {
                                button123.setOnAction((ActionEvent event) -> {
                                    Author author = getTableView().getItems().get(getIndex());
                                    AuthorRepository.deleteByObject(author);
                                    ObservableList<Author> authorList = FXCollections.observableArrayList(AuthorRepository.getAllList());
                                    authorTable.setItems(authorList);
                                });

                            }

                            @Override
                            public void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);

                                } else {

                                    setGraphic(button123);

                                }
                            }
                        };
                        return cell;
                    }
                };
        buttons.setCellFactory(cellFactory);
        authorTable.getColumns().add(buttons);

    }

    public void updateButton(){
        TableColumn<Author, Void> buttons = new TableColumn("Update");
        buttons.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Author, Void>, TableCell<Author, Void>> cellFactory
                = //
                new Callback<TableColumn<Author, Void>, TableCell<Author, Void>>() {
                    @Override
                    public TableCell call(final TableColumn<Author, Void> param) {
                        final TableCell<Author, Void> cell = new TableCell<Author, Void>() {

                            final Button button123 = new Button("Update");

                            {
                                button123.setOnAction((ActionEvent event) -> {
                                    Author author = authorTable.getSelectionModel().getSelectedItem();
                                    AuthorRepository.updateByObject(author);
                                });


                            }

                            @Override
                            public void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);

                                } else {

                                    setGraphic(button123);

                                }
                            }
                        };
                        return cell;
                    }
                };
        buttons.setCellFactory(cellFactory);
        authorTable.getColumns().add(buttons);
    }

    public HBox addSearchBar(Stage stage, boolean deleteButtonBool, boolean updateButtonBool){

        HBox root = new HBox();
        HBox choiseHBox = new HBox();
        HBox hSearchBox = new HBox();

        TextField searchField = new TextField("");

        Button button = new Button("Search");

        ChoiceBox<String> searchChoiceBox = new ChoiceBox();

        Label searchBy = new Label("SearchBy");
        searchBy.setAlignment(Pos.CENTER);

        searchChoiceBox.getItems().addAll("Id", "First Name", "Last Name");
        searchChoiceBox.setValue(stackName);

        choiseHBox.getChildren().addAll(searchBy, searchChoiceBox);
        choiseHBox.setSpacing(5);

        hSearchBox.getChildren().addAll(searchField, button);
        hSearchBox.setFillHeight(true);

        button.setOnAction(event -> {
            ObservableList<Author> findByName;
            if(searchChoiceBox.getValue().equals("Id")){

                authorsList = FXCollections.observableArrayList(AuthorRepository.getListById(searchField.getText()));
            }else if(searchChoiceBox.getValue().equals("Last Name")){
                authorsList = FXCollections.observableArrayList(AuthorRepository.getListByLastName(searchField.getText()));
            }else{
                authorsList = FXCollections.observableArrayList(AuthorRepository.getListByFirstName(searchField.getText()));
            }
            stackName = searchChoiceBox.getValue();
            authorsScreen(stage, deleteButtonBool, updateButtonBool);
        });


        root.getChildren().addAll(choiseHBox, hSearchBox);
        root.setSpacing(5);
        root.setPadding(new Insets(5,0,0,0));

        return root;
    }
}
