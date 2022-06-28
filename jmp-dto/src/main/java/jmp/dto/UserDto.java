package jmp.dto;
import java.time.LocalDate;

public class UserDto {
    int id;
    private String name;
    private String surName;
    private LocalDate dob;

    public UserDto(String name, String surName, LocalDate dob) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
    }

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
