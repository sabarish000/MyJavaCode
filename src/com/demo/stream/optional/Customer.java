package com.demo.stream.optional;

import java.util.Optional;

public record Customer(String name, Optional<Address> address) {}
