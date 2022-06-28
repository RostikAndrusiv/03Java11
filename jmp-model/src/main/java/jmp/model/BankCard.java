package jmp.model;

import javax.persistence.*;

@Entity
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    @OneToOne(cascade= CascadeType.ALL)
    User user;

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public BankCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
