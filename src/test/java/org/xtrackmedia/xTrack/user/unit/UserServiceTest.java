package org.xtrackmedia.xTrack.user.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xtrackmedia.xTrack.user.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSaveUser() {
        // Arrange
        UserDTO userDTO = UserDTO.builder()
                .username("ash")
                .password("ashwashere")
                .email("ash@snep.uwu")
                .role(UserRole.ADMIN)
                .build();

        User user = UserConverter.ToEntity(userDTO);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserDTO savedUserDTO = userService.saveUser(userDTO);

        // Assert
        assertNotNull(savedUserDTO);
        assertEquals(userDTO.getUsername(), savedUserDTO.getUsername());
        assertEquals(userDTO.getPassword(), savedUserDTO.getPassword());
        assertEquals(userDTO.getEmail(), savedUserDTO.getEmail());
        assertEquals(userDTO.getRole(), savedUserDTO.getRole());
    }

    @Test
    public void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User user = new User("bluebearry_", "snepenjoyer420", "blue@derg.uwu");
        user.setId(userId);
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        // Act
        Optional<UserDTO> userDTO = userService.getUserById(userId);

        // Assert
        assertTrue(userDTO.isPresent());
        assertEquals(user.getUsername(), userDTO.get().getUsername());
        assertEquals(user.getPassword(), userDTO.get().getPassword());
        assertEquals(user.getEmail(), userDTO.get().getEmail());
        assertEquals(user.getRole(), userDTO.get().getRole());
    }

    @Test
    public void testGetUserByUsername() {
        // Arrange
        String username = "likfont";
        User user = new User(username, "iloveleague69", "vic@memes.ro");
        Mockito.when(userRepository.findByUsername(anyString())).thenReturn(user);

        // Act
        Optional<UserDTO> userDTO = userService.getUserByUsername(username);

        // Assert
        assertTrue(userDTO.isPresent());
        assertEquals(user.getUsername(), userDTO.get().getUsername());
        assertEquals(user.getPassword(), userDTO.get().getPassword());
        assertEquals(user.getEmail(), userDTO.get().getEmail());
        assertEquals(user.getRole(), userDTO.get().getRole());
    }

    @Test
    public void testGetUserByEmail() {
        // Arrange
        String email = "stef@ilovemogirls.owo";
        User user = new User("arhivor", "whaaaaaaaaaaat", email);
        Mockito.when(userRepository.findByEmail(anyString())).thenReturn(user);

        // Act
        Optional<UserDTO> userDTO = userService.getUserByEmail(email);

        // Assert
        assertTrue(userDTO.isPresent());
        assertEquals(user.getUsername(), userDTO.get().getUsername());
        assertEquals(user.getPassword(), userDTO.get().getPassword());
        assertEquals(user.getEmail(), userDTO.get().getEmail());
        assertEquals(user.getRole(), userDTO.get().getRole());
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        UserDTO userDTO = UserDTO.builder()
                .username("susanoo12344")
                .password("leaguemoment")
                .email("david@law.ro")
                .role(UserRole.ADMIN)
                .build();

        User user = UserConverter.ToEntity(userDTO);
        Mockito.doNothing().when(userRepository).delete(any(User.class));

        // Act
        userService.deleteUser(userDTO);

        // Verify that delete method is called with the correct user entity
        Mockito.verify(userRepository, Mockito.times(1)).delete(user);
    }
}

