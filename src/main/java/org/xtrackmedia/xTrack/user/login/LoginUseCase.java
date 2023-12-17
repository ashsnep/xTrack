package org.xtrackmedia.xTrack.user.login;

import org.xtrackmedia.xTrack.user.login.LoginRequest;
import org.xtrackmedia.xTrack.user.login.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}
