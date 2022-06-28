package jmp.application;

import jmp.bank.api.Bank;
import jmp.cloud.bank.impl.BankImpl;
import jmp.cloud.service.impl.SubscriptionService;
import jmp.cloud.service.impl.UserService;
import jmp.dto.BankCardDto;
import jmp.dto.BankCardType;
import jmp.dto.SubscriptionDto;
import jmp.dto.UserDto;
import jmp.service.api.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

//TODO rename repository jmp-dao , aplication jmp-app, separate entity/dto... DONE ALL
public class Main {
    private static final UserService userService = new UserService();
    private static final SubscriptionService subscriptionService = new SubscriptionService();
    // 25. ServiceLoader.load()
    private static final Service service = Service.getImplementation();

    public static void main(String[] args) {

        var user = new UserDto("qwe", "qwe", LocalDate.parse("1990-05-01"));
        var user1 = new UserDto("zxc", "zxc", LocalDate.parse("2000-05-01"));
        userService.saveUser(user);
        userService.saveUser(user1);

        List<UserDto> list1 = service.getAllUsers();
        System.out.println(list1);

        Bank bank = new BankImpl();
        var card = bank.createBankCard(user, BankCardType.CREDIT);
        var card1 = bank.createBankCard(user1, BankCardType.DEBIT);
        List<BankCardDto> cards = Arrays.asList(card, card1);

        cards.forEach(service::subscribe);
        subscriptionService.save(new SubscriptionDto("77777"));

        //Uncomment this block to get custom exception
//        SubscriptionDto subscription = service.getSubscriptionByBankCardNumber("123456729")
//                .orElseThrow(SubscriptionNotFoundException::new);
//        System.out.println(subscription);

        System.out.println(subscriptionService.getAllSubscriptions());

        // 18. Default interface method
        OptionalDouble avgUserAge = service.getAverageUsersAge();
        System.out.println("avg users age:" + avgUserAge);

        // 19. static interface method
        System.out.println("is payable:" + Service.isPayable(user));
        System.out.println("is payable:" + Service.isPayable(user1));

        //22. Predicate
        Predicate<SubscriptionDto> cardNumberEqualsPredicate = c -> c.getBankCard().equals("77777");
        System.out.println(service.getAllSubscriptionsByCondition(cardNumberEqualsPredicate));

    }
}
