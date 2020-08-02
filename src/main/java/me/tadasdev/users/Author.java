package me.tadasdev.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.tadasdev.App;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id_authors;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private int id_books;



}
