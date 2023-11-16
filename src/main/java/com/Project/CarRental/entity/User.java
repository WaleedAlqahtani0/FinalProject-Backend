package com.Project.CarRental.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/*

   User Entity

 */
@Entity
@Table(name = "tbl_User")
public class User {

    // --------- Primary key (id) generated automatically by the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //----------- attribute
    private String username;

    //----------- attribute
    private String email;

    //-----------  attribute
    private String password;


    @OneToMany(mappedBy = "user")
    private Set<Book> book;

    @OneToOne (mappedBy = "user")
    private Payment payment;

    public User() {
    }

    //---------- constructors, getters, setters, equals, hashCode and toString;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
