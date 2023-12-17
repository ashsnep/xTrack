package org.xtrackmedia.xTrack.configuration.security.token;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
