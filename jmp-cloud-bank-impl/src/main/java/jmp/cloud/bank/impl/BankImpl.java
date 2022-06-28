package jmp.cloud.bank.impl;

import jmp.bank.api.Bank;
import jmp.dto.*;

import java.util.concurrent.ThreadLocalRandom;

public class BankImpl implements Bank {

    @Override
    public BankCardDto createBankCard(UserDto userDto, BankCardType bankCardType) {
        int num = ThreadLocalRandom.current().nextInt(1000000, 9999999);
        String number = String.valueOf(num);
        return BankCardType.CREDIT.equals(bankCardType) ? new CreditBankCard(number, userDto) : new DebitBankCard(number, userDto);
    }
}
