package com.training;

public record User(String username, String password, String firstName, String lastName, UserType type) {
}
