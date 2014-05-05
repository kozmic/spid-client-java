package no.spid.api.oauth;

import org.apache.oltu.oauth2.common.token.OAuthToken;

/**
 * OAuth token container with some SPiD specific values.
 */
public class SpidOAuthToken {
    private String accessToken;
    private String refreshToken;
    private String scope;
    private Long expiresIn;
    private Long expiresAt;
    private SpidOAuthTokenType type;

    public SpidOAuthToken(OAuthToken basicToken, SpidOAuthTokenType type) {
        accessToken = basicToken.getAccessToken();
        refreshToken = basicToken.getRefreshToken();
        scope = basicToken.getScope();
        expiresIn = basicToken.getExpiresIn();
        expiresAt = System.currentTimeMillis() + expiresIn * 1000;
        this.type = type;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public SpidOAuthTokenType getType() {
        return type;
    }

    /**
     * Refresh oauth token values from the newToken
     *
     * @param newToken the token to refresh values from
     */
    public void refresh( SpidOAuthToken newToken) {
        accessToken = newToken.getAccessToken();
        refreshToken = newToken.getRefreshToken();
        scope = newToken.getScope();
        expiresIn = newToken.getExpiresIn();
        expiresAt = System.currentTimeMillis() + expiresIn * 1000;
    }
}
