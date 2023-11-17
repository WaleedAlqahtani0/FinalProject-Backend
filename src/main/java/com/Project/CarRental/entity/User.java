package com.Project.CarRental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
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
    // ----------------------------------------
    @NotEmpty(message = "Provide a name.")
    private String username;

    //----------- attribute
    // ----------------------------------------
    @Email (message = "Provide a valid email address.")
    private String email;

    //-----------  attribute
    // -----------------------------------------
    // should uppercase and letter and at least 6 characters
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}",
            message = "Password must have at least 6 characters and contain at least one number, one lowercase and one uppercase letter.")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> book;

    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
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
