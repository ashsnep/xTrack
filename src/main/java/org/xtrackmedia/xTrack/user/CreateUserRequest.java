package org.xtrackmedia.xTrack.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateUserRequest {
    private UserDTO user;
    private String password;
}
