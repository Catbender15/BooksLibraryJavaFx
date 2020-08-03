package me.tadasdev.repositories;

import me.tadasdev.db.SessionManager;
import me.tadasdev.users.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.List;

public class BookRepository {

    public static List<Book> getAllBooksList(){
        String getAllBooksHQLQuery = "FROM Book";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllBooksQuery = session.createQuery(getAllBooksHQLQuery);
        List<Book> bookList = selectAllBooksQuery.getResultList();
        session.close();

        return bookList;
    }

    public static List<Book> getListById(String word){
        String getAllBookHQLQuery = "FROM Book where id_books like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllBookQuery = session.createQuery(getAllBookHQLQuery);
        List<Book> bookList = selectAllBookQuery.getResultList();
        session.close();

        return bookList;

    }
    public static List<Book> getListByTitle(String word){
        String getAllBookHQLQuery = "FROM Book where title like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllBookQuery = session.createQuery(getAllBookHQLQuery);
        List<Book> bookList = selectAllBookQuery.getResultList();
        session.close();

        return bookList;

    }
    public static List<Book> getListByAuthors(String word){
        String getAllBookHQLQuery = "FROM Book where author like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllBookQuery = session.createQuery(getAllBookHQLQuery);
        List<Book> bookList = selectAllBookQuery.getResultList();
        session.close();

        return bookList;

    }

    public static  void addToBookLibrary(String title, String authorName, String authorSurname, String description){
        Transaction transaction = null;
        try{
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(authorName + " " + authorSurname);
            book.setDescriptions(description);
            session.save(book);
            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println("Error in add Book: " + e.getMessage());
        }
    }

}
