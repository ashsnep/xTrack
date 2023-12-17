package org.xtrackmedia.xTrack.user;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin(allowedHeaders = "*", allowCredentials = "true", origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id).get());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<UserDTO>> getUserByUsername(String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserDTO>> getUserByEmail(String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.saveUser(createUserRequest.getUser(), createUserRequest.getPassword()));
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping()
    public ResponseEntity deleteUser(@RequestBody UserDTO user) {
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
