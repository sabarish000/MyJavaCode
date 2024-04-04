package com.demo.stream.optional;

import java.util.Optional;

public record City(String name, Optional<String> state, String country) {}
