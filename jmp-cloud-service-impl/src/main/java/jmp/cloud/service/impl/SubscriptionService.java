package jmp.cloud.service.impl;

import jmp.dto.SubscriptionDto;
import jmp.repository.dao.SubscriptionDao;
import jmp.util.mapper.SubscriptionMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionService {

    private final SubscriptionDao subscriptionDao = new SubscriptionDao();

    private static final SubscriptionMapper subscriptionMapper = SubscriptionMapper.INSTANCE;

    public void save(SubscriptionDto subscriptionDto) {
        subscriptionDao.save(subscriptionMapper.dtoToSubscription(subscriptionDto));
    }

    public List<SubscriptionDto> getAllSubscriptions() {
        var subscriptions = subscriptionDao.getAllSubscriptions();
        return subscriptions.stream()
                .map(subscriptionMapper::subscriptionToDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
