package com.sam.userlogin.repository;


import com.sam.userlogin.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Arrange
        String email = "jones@admin.com";
        User user = new User();
        user.setEmail(email);

        // Act
        User found = userRepository.findByEmail(email);

        // Assert
        assertThat(found.getEmail()).isEqualTo(email);
    }
}

