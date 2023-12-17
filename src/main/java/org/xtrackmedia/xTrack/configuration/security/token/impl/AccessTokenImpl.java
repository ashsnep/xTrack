package org.xtrackmedia.xTrack.configuration.security.token.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.xtrackmedia.xTrack.configuration.security.token.AccessToken;
import org.xtrackmedia.xTrack.user.UserRole;

import java.util.List;

@EqualsAndHashCode
@Getter
public class AccessTokenImpl implements AccessToken {
    private final String subject;
    private final Long studentId;
    private final List<UserRole> roles;

    public AccessTokenImpl(String subject, Long studentId, List<UserRole> roles) {
        this.subject = subject;
        this.studentId = studentId;
        this.roles = roles;
    }
}

