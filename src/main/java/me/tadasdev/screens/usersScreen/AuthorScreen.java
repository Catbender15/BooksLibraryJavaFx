package me.tadasdev.screens.usersScreen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import me.tadasdev.users.Author;

import javax.persistence.Table;


public class AuthorScreen {
    ObservableList<Author> authorsList = FXCollections.observableArrayList(AuthorRepository.getAllList());

    TableView<Author> authorTable = new TableView<>();
    public String stackName = "First Name";

    public void authorsScreen(Stage stage){

        TableView tableView = this.tableView();

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> MenuScreen.menuScreen(stage));
        Button addButton = new Button("add");
        TextField firstNamee = new TextField();
        TextField lastNamee = new TextField();

        addButton.setOnAction(event -> {
            AuthorRepository.save(firstNamee.getText(), lastNamee.getText());
            firstNamee.setText("");
            lastNamee.setText("");
            ObservableList<Author> authorList = FXCollections.observableArrayList(AuthorRepository.getAllList());
            authorTable.setItems(authorList);
        });
        HBox hBox = new HBox();
        hBox.getChildren().addAll(firstNamee, lastNamee, addButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(backButton);
        vBox.getChildren().add(addSearchBar(stage));
        vBox.getChildren().add(tableView);
        vBox.getChildren().add(hBox);


        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

    }

    public TableView tableView(){
        ObservableList<Author> authorsList = this.authorsList;

        TableColumn<Author, Integer> id = new TableColumn<>("Id");
        TableColumn<Author, String> firstName = new TableColumn<>("First_Name");
        TableColumn<Author, String> lastName = new TableColumn<>("Last_Name");

        id.setCellValueFactory(new PropertyValueFactory<>("id_authors"));
        id.setMinWidth(30);

        firstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setMinWidth(80);

        lastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setMinWidth(80);

        authorTable.getColumns().setAll(id, firstName, lastName);
        //authorTable.prefWidth(20);
        authorTable.setItems(authorsList);
        deleteButton();

        return authorTable;
    }



    public void deleteButton(){
        TableColumn<Author, Void> buttons = new TableColumn("Action");
        buttons.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<Author, Void>, TableCell<Author, Void>> cellFactory
                = //
                new Callback<TableColumn<Author, Void>, TableCell<Author, Void>>() {
                    @Override
                    public TableCell call(final TableColumn<Author, Void> param) {
                        final TableCell<Author, Void> cell = new TableCell<Author, Void>() {

                            final Button button123 = new Button("Just Do It");

                            {
                                button123.setOnAction((ActionEvent event) -> {
                                    Author author = getTableView().getItems().get(getIndex());
                                    AuthorRepository.deleteByObject(author);
                                    ObservableList<Author> authorList = FXCollections.observableArrayList(AuthorRepository.getAllList());
                                    authorTable.setItems(authorList);
                                    authorTable.getColumns().remove(buttons);
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

    public HBox addSearchBar(Stage stage){

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
            authorsScreen(stage);
        });


        root.getChildren().addAll(choiseHBox, hSearchBox);
        root.setSpacing(5);
        root.setPadding(new Insets(5,0,0,0));

        return root;
    }
}
