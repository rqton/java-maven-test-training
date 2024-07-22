package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mandatory to be able to use mockito annotations
public class OKWithAnnotationsUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should get user full name of a user")
    public void exercise_01_shouldGetUserFullName() {
        // Given
        User user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);

        // Then
        String fullName = userService.getUserFullName(user);

        // Assert
        assertThat(fullName).contains("John Doe");
    }

    @Test
    @DisplayName("Should throw an exception while getting user full name if user is null")
    public void exercise_02_getUserFullNameShouldThrowException() {
        // Then / Assert
        assertThatThrownBy(() -> userService.getUserFullName(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Should get user full name for every type of users")
    @CsvSource({"DOCTOR, Dr.", "PROFESSOR, Pr.", "ENGINEER, Eng."})
    public void exercise_03_shouldGetUserFullNameForEveryTypeOfUsers(UserType userType, String expectedPrefix) {
        // Given
        User user = new User("john.doe", "password", "John", "Doe", userType);

        // Then
        String fullName = userService.getUserFullName(user);

        // Assert
        assertThat(fullName).isEqualTo(String.format("%s John Doe", expectedPrefix));
    }

    @Test
    @DisplayName("Should authenticate user")
    public void exercise_04_shouldAuthenticateUser() {
        // Given
        User user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);
        when(userRepository.getUser("john.doe")).thenReturn(user);

        // Then
        Boolean isAuthenticated = userService.authenticate("john.doe", "password");

        // Assert
        assertThat(isAuthenticated).isTrue();
    }

    @Test
    @DisplayName("Should not authenticate user if password is wrong")
    public void exercise_05_shouldNotAuthenticateUser() {
        // Given
        User user = new User("john.doe", "password", "John", "Doe", UserType.ENGINEER);
        when(userRepository.getUser("john.doe")).thenReturn(user);

        // Then
        Boolean isAuthenticated = userService.authenticate("john.doe", "wrongPassword");

        // Assert
        assertThat(isAuthenticated).isFalse();
    }

}
