package org.xtrackmedia.xTrack.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<UserRole> role;
}
