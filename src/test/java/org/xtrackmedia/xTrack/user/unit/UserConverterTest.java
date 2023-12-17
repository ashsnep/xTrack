package org.xtrackmedia.xTrack.user.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.user.User;
import org.xtrackmedia.xTrack.user.UserConverter;
import org.xtrackmedia.xTrack.user.UserDTO;
import org.xtrackmedia.xTrack.user.UserRole;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserConverterTest {
    @Test
    void toUserDTO_ShouldConvertUserToUserDTO() {
        // Arrange
        User user = new User("testUser", "password123", "test@example.com");
        user.setId(1L);
        user.setRole(UserRole.ADMIN);

        // Act
        UserDTO userDTO = UserConverter.ToUserDTO(user);

        // Assert
        assertEquals(user.getUsername(), userDTO.getUsername());
        assertEquals(user.getPassword(), userDTO.getPassword());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getRole(), userDTO.getRole());
    }

    @Test
    void toUserDTO_WithNullUser_ShouldReturnNull() {
        // Act
        UserDTO userDTO = UserConverter.ToUserDTO(null);

        // Assert
        assertNull(userDTO);
    }

    @Test
    void toEntity_ShouldConvertUserDTOToUser() {
        // Arrange
        UserDTO userDTO = UserDTO.builder()
                .username("testUser")
                .password("password123")
                .email("test@example.com")
                .role(UserRole.ADMIN)
                .build();

        // Act
        User user = UserConverter.ToEntity(userDTO);

        // Assert
        assertEquals(userDTO.getUsername(), user.getUsername());
        assertEquals(userDTO.getPassword(), user.getPassword());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getRole(), user.getRole());
    }

    @Test
    void toEntity_WithNullUserDTO_ShouldReturnNull() {
        // Act
        User user = UserConverter.ToEntity(null);

        // Assert
        assertNull(user);
    }

}
