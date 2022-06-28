package jmp.util.mapper;

import jmp.dto.BankCardDto;
import jmp.model.BankCard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankCardMapper {

    BankCardMapper INSTANCE = Mappers.getMapper(BankCardMapper.class);

    BankCardDto bankCardToDto(BankCard bankCard);

    BankCard dtoToBankCard(BankCardDto bankCardDto);
}
