package com.Project.CarRental.entity;


import jakarta.persistence.*;

import java.util.Objects;

/*

   Payment Entity

 */
@Entity
@Table(name = "tbl_Payment")
public class Payment {

    // --------- Primary key (id) generated automatically by the database
    @Id
    private String codeNumber;

    //----------- attribute
    private String cardType;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Payment() {
    }

    public Payment(String cardType) {
        this.cardType = cardType;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(codeNumber, payment.codeNumber) && Objects.equals(cardType, payment.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeNumber, cardType);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "codeNumber='" + codeNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
