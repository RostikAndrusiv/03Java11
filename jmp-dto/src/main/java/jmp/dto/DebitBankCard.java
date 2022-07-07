package jmp.dto;


import java.io.Serializable;

public class DebitBankCard extends BankCardDto implements Serializable {
    private static final long serialVersionUID=1L;
    public DebitBankCard(String number, UserDto userDto) {
        super(number, userDto);
    }
}
