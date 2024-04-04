package com.demo.stream.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Optional<Customer> cust1 = Optional.of(
//                new Customer("John",
//                Optional.of(new Address("abc", "street A",
//                        Optional.of(
//                                new City("Hyderabad", Optional.of("TS"), "India")),
//                        "500001"))));
//        Optional<Customer> cust1 = Optional.of(
//                new Customer("John",
//                        Optional.of(new Address("abc", "street A",
//                                new City("Hyderabad", Optional.of("TS"), "India"),
//                                "500001"))));
        Optional<Customer> cust1 = Optional.of(
                new Customer("John",
                        Optional.of(new Address("abc", "street A",null,"500001"))));
        cust1.flatMap(Customer::address)
                .map(Address::city)
                .map(City::country)
                .ifPresent(System.out::println);
    }
}
