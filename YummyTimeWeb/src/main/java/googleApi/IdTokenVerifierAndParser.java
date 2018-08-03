package googleApi;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class IdTokenVerifierAndParser {
    private static final String GOOGLE_CLIENT_ID = "907007146976-gj3molj87dk4k7jntu3hslrdubmd1947.apps.googleusercontent.com";
    private static Logger logger = LoggerFactory.getLogger(IdTokenVerifierAndParser.class);

    public static GoogleIdToken.Payload getPayload(String tokenString) {

        logger.debug("Started method that gets google id token");
        JacksonFactory jacksonFactory = new JacksonFactory();
        GoogleIdTokenVerifier googleIdTokenVerifier =
                new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

        GoogleIdToken token = null;

        try {
            token = GoogleIdToken.parse(jacksonFactory, tokenString);

            if (googleIdTokenVerifier.verify(token)) {
                GoogleIdToken.Payload payload = token.getPayload();
                if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
                    throw new IllegalArgumentException("Audience mismatch");
                } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
                    throw new IllegalArgumentException("Client ID mismatch");
                }
                return payload;
            }
        } catch (GeneralSecurityException | IOException e) {
            logger.warn("Problems with id token verification");
        }
        return null;
    }
}