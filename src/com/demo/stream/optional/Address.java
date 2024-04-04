package com.demo.stream.optional;

import java.util.Optional;

// public record Address(String line, String street, Optional<City> city, String pinCode) {}
public record Address(String line, String street, City city, String pinCode) {}
