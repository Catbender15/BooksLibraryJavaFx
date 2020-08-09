# Books Library
Project is running on Java 8.

Need first create DB (Data base).

You can find DB Query in booksLibraryQuery.qs

Project tree structure:
````
├───src
│   ├───main
│   │   ├───java
│   │   │   └───me
│   │   │       └───tadasdev
│   │   │           ├───db
│   │   │           │   └───SessionManager.java
│   │   │           ├───repositories
│   │   │           │    ├───AuthorRepository.java
│   │   │           │    └───BookRepository
│   │   │           ├───screens
│   │   │           │   ├───infoScreens
│   │   │           │   │   ├───AuthorInfo.java
│   │   │           │   │   └───BookInfo.java
│   │   │           │   ├───refactorScreens
│   │   │           │   │   ├───AddToLibrary.java
│   │   │           │   │   └───DeleteFromLibrary.java
│   │   │           │   ├───usersScreen
│   │   │           │   │   ├───AuthorScreen.java
│   │   │           │   │   └───BookScreen.java
│   │   │           │   ├───ErrorScreen.java
│   │   │           │   └───MenuScreen.java
│   │   │           ├───users
│   │   │           │   ├───Author.java
│   │   │           │   └───Book.java
│   │   │           └───App.java
│   │   └───resources
│   └───test
│       └───java
````

#### SessionManeger.java
Create hibernate connecion to MySQL DB

#### AuthoRepository.java
This Class Refactoring and Getting Authors Table from MySQL
###### Methods:
* ```getAllList();```  Getting all Authors from MySQL Table.
* ```getListByFirstName();``` Find and return Authors by First Name from MySQL Table.
* ```getListById();``` Find and return Authors by Id from MySQL Table.
* ```getListByLastName();``` Find and return Authors by Last Name from MySQL Table.
* ```deleteByObject();``` Deleting Author Object from MySQL Table.
* ```updateById();``` Updating Authors by Id in MySQL Table.
* ```save();``` Adding Author to MySQL Table.

#### BookRepository.java
This Class Refactoring and Getting Books Table from MySQL
###### Methods:
* ```getAllBooksList();```  Getting all Books from MySQL Table.
* ```getListByTitle();``` Find and return Books by Title from MySQL Table.
* ```getListById();``` Find and return Books by Id from MySQL Table.
* ```getListByAuthors();``` Find and return Books by Authors(not Object) from MySQL Table.
* ```updateById();``` Updating Books by Id in MySQL Table.
* ```addToBookLibrary();``` Adding Books to MySQL Table.

#### AuthroInfo.java

#### BookInfo.java
This Class Printing about book info.
###### Methods:
* ```bookInfo();``` In this method creating style of Book Info and Print About book Screen.

#### AddToLibrary.java
This Class Adding Books and Authors in Mysql Tables.
###### Methods:
* ```addToLibrary();``` In this method creating style of Add To Library and Print into Screen.

#### DeleteFromLibrary.java
This Class Deleting Books and Authors from MySQL Tables.

#### AuthorScreen.java
This Class Printing Authors Table.
###### Methods:
* ```authorsScreen();``` In this method, is creating style of Author Table screen and Print into Screen.
* ```tableView();``` Formanting Author table Data.
* ```deleteButton();``` Adding to Author Table delete Button;
* ```addSearchBar();``` Creating Search Bar style and his action.

#### BooksScreen.java
This Class Printing Books Table.
###### Methods:
* ```booksScreen();``` In this method, is creating style of Books Table screen and Print into Screen.
* ```bookTableView();``` Formanting Book table Data.
* ```titleLink``` Adding and Creating to Author Table HyperLink with action;
* ```addSearchBar();``` Creating Search Bar style and his action.

#### ErrorScreen.java
This Class is printing Error if Can't found anothers screens.

#### MenuScreen.java
This Class Printing Menu screen;
###### Methods:
* ```menuScreen();``` In this method, is creating style of Menu screen, Buttons and Print into Screen.

#### Author.java
In this Class is getting and Setting all data About Authors from MySQL Table.

#### Books.java
In this Class is getting and Setting all data About Books from MySQL Table.

#### App.java
This Class is starting JavaFX methods.
###### Methods:
* ```main();``` Launch JavaFx methods.
* ```start();``` Start Menu Screen.
* ```stop();``` Stopping program and shutdown SessionManager.
