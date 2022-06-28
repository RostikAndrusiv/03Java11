package jmp.cloud.service.impl;

import jmp.dto.UserDto;
import jmp.repository.dao.UserDao;
import jmp.util.mapper.UserMapper;

public class UserService {
    private final UserDao userDao = new UserDao();

    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public void saveUser(UserDto userDto) {
        userDao.saveUser(userMapper.dtoToUser(userDto));
    }
}
