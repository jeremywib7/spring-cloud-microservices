package com.joy.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
