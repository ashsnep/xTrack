package org.xtrackmedia.xTrack.user.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.user.User;
import org.xtrackmedia.xTrack.user.UserRole;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        // Create a user instance
        User user = new User();

        // Test setters
        user.setId(1L);
        user.setUsername("john.doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        user.setRole(UserRole.ADMIN);

        // Test getters
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getUsername()).isEqualTo("john.doe");
        assertThat(user.getPassword()).isEqualTo("password123");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getRole()).isEqualTo(UserRole.ADMIN);
    }

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        assertNull(user.getId());
        assertNull(user.getUsername());
        assertNull(user.getPassword());
        assertNull(user.getEmail());
        assertNull(user.getRole());
    }

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        String username = "testUser";
        String password = "testPassword";
        String email = "test@example.com";
        UserRole role = UserRole.ADMIN;

        User user = new User(id, username, password, email, role);

        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
    }

    @Test
    void testBuilder() {
        Long id = 1L;
        String username = "testUser";
        String password = "testPassword";
        String email = "test@example.com";
        UserRole role = UserRole.ADMIN;

        User user = User.builder()
                .id(id)
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .build();

        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
    }

    @Test
    void testCustomConstructor() {
        String username = "testUser";
        String password = "testPassword";
        String email = "test@example.com";

        User user = new User(username, password, email);

        assertNull(user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertNull(user.getRole());
    }
//    @Test
//    void testDataAnnotation() {
//        Long id = 1L;
//        String username = "testUser";
//        String password = "testPassword";
//        String email = "test@example.com";
//        UserRole role = UserRole.ADMIN;
//
//        User user1 = new User(id, username, password, email, role);
//        User user2 = new User(id, username, password, email, role);
//
//        // Test equals method
//        assertEquals(user1, user2);
//
//        // Test hashCode method
//        assertEquals(user1.hashCode(), user2.hashCode());
//
//        // Test toString method
//        String expectedToString = "User(id=1, username=testUser, password=testPassword, email=test@example.com, role=USER)";
//        assertEquals(expectedToString, user1.toString());
//    }
}