package org.xtrackmedia.xTrack.configuration.security.token;

import org.xtrackmedia.xTrack.user.UserRole;

import java.util.List;
import java.util.Set;

public interface AccessToken {
    String getSubject();

    Long getStudentId();

    List<UserRole> getRoles();

}

