package jmp.util.mapper;

import jmp.dto.UserDto;
import jmp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToDto(User user);

    User dtoToUser(UserDto userDot);
}
