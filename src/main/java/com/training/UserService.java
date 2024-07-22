package com.training;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserFullName(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        var userPrefix = switch (user.type()) {
            case DOCTOR -> "Dr.";
            case PROFESSOR -> "Pr.";
            case ENGINEER -> "Eng.";
        };
        return String.format("%s %s %s", userPrefix, user.firstName(), user.lastName());
    }

    // TRUST ME 🦝 THIS IS PROD READY
    public boolean authenticate(String username, String password) {
        User user = userRepository.getUser(username);
        if (user == null) return false;
        return user.password().equals(password);
    }
}
