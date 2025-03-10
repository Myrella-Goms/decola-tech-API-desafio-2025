package me.dio.service.impl;

import me.dio.dto.*;
import me.dio.entity.*;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO findById(Long id) {
        return toDTO(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public UserDTO create(UserDTO userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        User user = toEntity(userToCreate);
        return toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, UserDTO userToUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.delete(existingUser);
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setCpf(user.getCpf());
        userDTO.setPhone(user.getPhone());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAccount(toDTO(user.getAccount()));
        userDTO.setCard(toDTO(user.getCard()));
        userDTO.setAddress(toDTO(user.getAddress()));
        return userDTO;
    }

    private User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setPhone(userDTO.getPhone());
        user.setBirthdate(userDTO.getBirthdate());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAccount(toEntity(userDTO.getAccount()));
        user.setCard(toEntity(userDTO.getCard()));
        user.setAddress(toEntity(userDTO.getAddress()));
        return user;
    }

    private AccountDTO toDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setNumber(account.getNumber());
        accountDTO.setAgency(account.getAgency());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setLimit(account.getLimit());
        accountDTO.setTransactions(account.getTransactions().stream().map(this::toDTO).collect(Collectors.toList()));
        return accountDTO;
    }

    private Account toEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setNumber(accountDTO.getNumber());
        account.setAgency(accountDTO.getAgency());
        account.setBalance(accountDTO.getBalance());
        account.setLimit(accountDTO.getLimit());
        account.setTransactions(accountDTO.getTransactions().stream().map(this::toEntity).collect(Collectors.toList()));
        return account;
    }

    private CardDTO toDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setNumber(card.getNumber());
        cardDTO.setLimit(card.getLimit());
        cardDTO.setCurrentBill(card.getCurrentBill());
        cardDTO.setDueDate(card.getDueDate());
        cardDTO.setBestPurchaseDay(card.getBestPurchaseDay());
        cardDTO.setPurchases(card.getPurchases().stream().map(this::toDTO).collect(Collectors.toList()));
        return cardDTO;
    }

    private Card toEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setNumber(cardDTO.getNumber());
        card.setLimit(cardDTO.getLimit());
        card.setCurrentBill(cardDTO.getCurrentBill());
        card.setDueDate(cardDTO.getDueDate());
        card.setBestPurchaseDay(cardDTO.getBestPurchaseDay());
        card.setPurchases(cardDTO.getPurchases().stream().map(this::toEntity).collect(Collectors.toList()));
        return card;
    }

    private AddressDTO toDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setZipcode(address.getZipcode());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        return addressDTO;
    }

    private Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setZipcode(addressDTO.getZipcode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        return address;
    }

    private TransactionsDTO toDTO(Transactions transactions){
        TransactionsDTO transactionsDTO = new TransactionsDTO();
        transactionsDTO.setId(transactions.getId());
        transactionsDTO.setDate(transactions.getDate());
        transactionsDTO.setDescription(transactions.getDescription());
        transactionsDTO.setAmount(transactions.getAmount());
        return transactionsDTO;
    }

    private Transactions toEntity(TransactionsDTO transactionsDTO){
        Transactions transactions = new Transactions();
        transactions.setId(transactionsDTO.getId());
        transactions.setDate(transactionsDTO.getDate());
        transactions.setDescription(transactionsDTO.getDescription());
        transactions.setAmount(transactionsDTO.getAmount());
        return transactions;
    }

    private PurchasesDTO toDTO (Purchases purchases){
        PurchasesDTO purchasesDTO = new PurchasesDTO();
        purchasesDTO.setId(purchases.getId());
        purchasesDTO.setDate(purchases.getDate());
        purchasesDTO.setDescription(purchases.getDescription());
        purchasesDTO.setAmount(purchases.getAmount());
        return purchasesDTO;
    }

    private Purchases toEntity (PurchasesDTO purchasesDTO) {
        Purchases purchases = new Purchases();
        purchases.setId(purchasesDTO.getId());
        purchases.setDate(purchasesDTO.getDate());
        purchases.setDescription(purchasesDTO.getDescription());
        purchases.setAmount(purchasesDTO.getAmount());
        return purchases;
    }
}
