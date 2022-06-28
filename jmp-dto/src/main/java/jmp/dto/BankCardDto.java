package jmp.dto;

public class BankCardDto {
    int id;
    String number;
    UserDto userDto;

    public BankCardDto(String number, UserDto userDto) {
        this.number = number;
        this.userDto = userDto;
    }

    public BankCardDto() {
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

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "BankCardDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}
