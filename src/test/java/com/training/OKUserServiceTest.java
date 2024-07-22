package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OKUserServiceTest {

    @Test
    @DisplayName("Should get user full name of a user")
    public void exercise_01_shouldGetUserFullName() {
        // Given
        User user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);
        var userService = new UserService(null);

        // Then
        var fullName = userService.getUserFullName(user);

        // Assert
        assertThat(fullName).contains("John Doe");
    }

    @Test
    @DisplayName("Should throw an exception while getting user full name if user is null")
    public void exercise_02_getUserFullNameShouldThrowException() {
        // Given
        var userService = new UserService(null);

        // Then / Assert
        assertThatThrownBy(() -> userService.getUserFullName(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Should get user full name for every type of users")
    @CsvSource({"DOCTOR, Dr.", "PROFESSOR, Pr.", "ENGINEER, Eng."})
    public void exercise_03_shouldGetUserFullNameForEveryTypeOfUsers(UserType userType, String expectedPrefix) {
        // Given
        var user = new User("john.doe", "password", "John", "Doe", userType);
        var userService = new UserService(null);

        // Then
        var fullName = userService.getUserFullName(user);

        // Assert
        assertThat(fullName).isEqualTo(String.format("%s John Doe", expectedPrefix));
    }

    @Test
    @DisplayName("Should authenticate user")
    public void exercise_04_shouldAuthenticateUser() {
        // Given
        var user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);
        var userRepository = mock(UserRepository.class);
        when(userRepository.getUser("john.doe")).thenReturn(user);
        var userService = new UserService(userRepository);

        // Then
        var isAuthenticated = userService.authenticate("john.doe", "password");

        // Assert
        assertThat(isAuthenticated).isTrue();
    }

    @Test
    @DisplayName("Should not authenticate user if password is wrong")
    public void exercise_05_shouldNotAuthenticateUser() {
        // Given
        var user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);
        var userRepository = mock(UserRepository.class);
        when(userRepository.getUser("john.doe")).thenReturn(user);
        var userService = new UserService(userRepository);

        // Then
        var isAuthenticated = userService.authenticate("john.doe", "wrongPassword");

        // Assert
        assertThat(isAuthenticated).isFalse();
    }

}
