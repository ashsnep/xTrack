package org.xtrackmedia.xTrack.configuration.security.token;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
