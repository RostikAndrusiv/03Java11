package jmp.service.api;

import jmp.dto.BankCardDto;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.ServiceLoader;
import java.util.function.Predicate;

public interface Service {

    static Service getImplementation(){
        return ServiceLoader
                .load(Service.class)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    void subscribe(BankCardDto bankCardDto);

    Optional<SubscriptionDto> getSubscriptionByBankCardNumber(String cardNumber);

    List<UserDto> getAllUsers();

    List<SubscriptionDto> getAllSubscriptionsByCondition(Predicate<SubscriptionDto> predicate);

    default OptionalDouble getAverageUsersAge() {
        var users = getAllUsers();
        return users
                .stream()
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getDob(), LocalDate.now()))
                .average();
    }

    static boolean isPayable(UserDto userDto) {
        return 18 < ChronoUnit.YEARS.between(userDto.getDob(), LocalDate.now());
    }
}
