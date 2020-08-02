package me.tadasdev.users;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    @Column
    private int id_books;
    
    @Column 
    private String title;
    
    @Column
    private String descriptions;
    
    @Column
    private String author;
    
    
}
