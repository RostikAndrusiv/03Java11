package jmp.cloud.service.impl;

import jmp.dto.BankCardDto;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;
import jmp.service.api.Service;
import jmp.repository.dao.SubscriptionDao;
import jmp.repository.dao.UserDao;
import jmp.util.mapper.SubscriptionMapper;
import jmp.util.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    private static final SubscriptionMapper subscriptionMapper = SubscriptionMapper.INSTANCE;

    private static final UserDao userDao = new UserDao();

    private static final SubscriptionDao subscriptionDao = new SubscriptionDao();

    @Override
    public void subscribe(BankCardDto bankCardDto) {
        var cardNumber = bankCardDto.getNumber();
        var subscription = new SubscriptionDto(cardNumber);
        subscriptionDao.save(subscriptionMapper.dtoToSubscription(subscription));
    }

    @Override
    public Optional<SubscriptionDto> getSubscriptionByBankCardNumber(String cardNumber) {
        var sub = subscriptionDao.getSubscriptionByCardNumber(cardNumber);
        return Optional.ofNullable(subscriptionMapper.subscriptionToDto(sub));
    }

    @Override
    public List<UserDto> getAllUsers() {
        var users = userDao.getAllUsers();
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptionsByCondition(Predicate<SubscriptionDto> predicate) {
        var subscriptions = subscriptionDao.getAllSubscriptions();
        return subscriptions.stream()
                .map(subscriptionMapper::subscriptionToDto)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
