package jmp.dto;

import java.io.Serializable;

public class CreditBankCard extends BankCardDto implements Serializable {
    private static final long serialVersionUID=1L;

    public CreditBankCard(String number, UserDto userDto) {
        super(number, userDto);
    }
}
