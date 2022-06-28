package jmp.util.mapper;

import jmp.dto.SubscriptionDto;
import jmp.model.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    SubscriptionDto subscriptionToDto(Subscription subscription);

    Subscription dtoToSubscription(SubscriptionDto subscriptionDto);
}

