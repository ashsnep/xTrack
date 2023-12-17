package org.xtrackmedia.xTrack.user.login;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.xtrackmedia.xTrack.configuration.security.token.AccessTokenEncoder;
import org.xtrackmedia.xTrack.configuration.security.token.impl.AccessTokenImpl;
import org.xtrackmedia.xTrack.user.*;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;
    private final UserService userService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserDTO user = UserConverter.ToUserDTO(userRepository.findByUsername(loginRequest.getUsername()));
        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {
         return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserDTO user) {
        Long userId = user.getId();
        String username = user.getUsername();
        List<UserRole> role = user.getRole();

        return accessTokenEncoder.encode(
                new AccessTokenImpl(username, userId, role));
    }

}
