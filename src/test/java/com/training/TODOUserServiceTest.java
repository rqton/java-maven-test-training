package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TODOUserServiceTest {

    @Test
    @DisplayName("Should get user full name of a user")
    public void exercise_01_shouldGetUserFullName() {
        // Given
        /* Init here a user and a userService */

        // Then
        /* Call the method to test */

        // Assert
        /* Assert name contains */
    }

    @Test
    @DisplayName("Should throw an exception while getting user full name if user is null")
    public void exercise_02_getUserFullNameShouldThrowException() {
        // Given
        /* Init here a userService */

        // Then / Assert
        /* Expect an exception when calling method */
    }

    @ParameterizedTest
    @DisplayName("Should get user full name for every type of users")
    @CsvSource({"DOCTOR, Dr.", "PROFESSOR, Pr.", "ENGINEER, Eng."})
    public void exercise_03_shouldGetUserFullNameForEveryTypeOfUsers(UserType userType, String expectedPrefix) {
        // Given
        /* Init here a user (using userType argument) and a userService */

        // Then
        /* Call the method to test */

        // Assert
        /* Assert name equals using expectedPrefix argument */
    }

    @Test
    @DisplayName("Should authenticate user")
    public void exercise_04_shouldAuthenticateUser() {
        // Given
        /* Init here a user (using userType argument), mock the repository, define a behavior while calling the repository method, and init a userService */

        // Then
        /* Call the method to test */

        // Assert
        /* Assert value returned from the method */
    }

    @Test
    @DisplayName("Should not authenticate user if password is wrong")
    public void exercise_05_shouldNotAuthenticateUser() {
        // Given
        /* Init here a user (using userType argument), mock the repository, define a behavior while calling the repository method, and init a userService */

        // Then
        /* Call the method to test */

        // Assert
        /* Assert value returned from the method */
    }
}
