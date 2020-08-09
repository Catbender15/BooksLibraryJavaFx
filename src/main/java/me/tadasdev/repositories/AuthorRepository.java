package me.tadasdev.repositories;


import me.tadasdev.db.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import me.tadasdev.users.Author;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AuthorRepository {

    public static List<Author> getAllList(){
        String getAllAuthorsHQLQuery = "FROM Author";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllAuthorsQuery = session.createQuery(getAllAuthorsHQLQuery);
        List<Author> authorList = selectAllAuthorsQuery.getResultList();
        session.close();

        return authorList;
    }

    public static List<Author> getListByFirstName(String word){
        String getAllAuthorsHQLQuery = "FROM Author where first_name like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllAuthorsQuery = session.createQuery(getAllAuthorsHQLQuery);
        List<Author> authorList = selectAllAuthorsQuery.getResultList();
        session.close();

        return authorList;

    }
    public static List<Author> getListById(String word){
        String getAllAuthorsHQLQuery = "FROM Author where id_authors like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllAuthorsQuery = session.createQuery(getAllAuthorsHQLQuery);
        List<Author> authorList = selectAllAuthorsQuery.getResultList();
        session.close();

        return authorList;

    }
    public static List<Author> getListByLastName(String word){
        String getAllAuthorsHQLQuery = "FROM Author where last_name like ('%" + word + "%')";
        Session session = SessionManager.getSessionFactory().openSession();
        Query selectAllAuthorsQuery = session.createQuery(getAllAuthorsHQLQuery);
        List<Author> authorList = selectAllAuthorsQuery.getResultList();
        session.close();

        return authorList;

    }

    public static void deleteByObject(Author author){
        Transaction transaction = null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }else{
                System.out.println("Id " +  " didnt deleted");
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public  static  void updateByObject(Author author){
        Transaction transaction = null;
        try{
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public static void addAuthor(String first_name, String last_Name){
        Transaction transaction= null;
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Author author = new Author();
            author.setFirst_name(first_name);
            author.setLast_name(last_Name);
            session.save(author);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                System.out.println("Klaida: " + e.getMessage());
            }
        }
    }

    /*public static Author foundAuthroByNameAndSurname(String name, String lastName){
        Session session = SessionManager.getSessionFactory().openSession();
        Author author = null;
        String query = "SELECT id_authors from Author where first_name like " + name + " and last_name like " + lastName;
        ResultSet rs = session.createQuery(query);

        return  author;
    }*/




}
