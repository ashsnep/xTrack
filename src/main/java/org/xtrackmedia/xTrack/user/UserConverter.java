package org.xtrackmedia.xTrack.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserConverter {

    public static UserDTO ToUserDTO(User user) {
        if (user == null)
            return null;

        // FIX THIS ASAP!!!!
        ArrayList<UserRole> tmp = new ArrayList<UserRole>();
        tmp.add(UserRole.ADMIN);

        return UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(tmp)
                .build();
    }

    public static User ToEntity(UserDTO userDTO) {
        if (userDTO == null)
            return null;

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(UserRole.ADMIN);
        return user;
    }
}
