package jmp.dto;


import java.time.LocalDate;
import java.util.Objects;


public class SubscriptionDto {

    int id;
    String bankCard;
    LocalDate startDate;

    public SubscriptionDto() {
    }

    public SubscriptionDto(String bankCardNum) {
        this.bankCard = bankCardNum;
        this.startDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionDto that = (SubscriptionDto) o;
        return id == that.id && Objects.equals(bankCard, that.bankCard) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankCard, startDate);
    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "id=" + id +
                ", bankCard='" + bankCard + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
