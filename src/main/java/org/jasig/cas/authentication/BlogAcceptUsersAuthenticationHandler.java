package org.jasig.cas.authentication;

import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.validation.constraints.NotNull;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by NS on 2016/3/16.
 */
public class BlogAcceptUsersAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
    @NotNull
    private Map<String, String> users;

    public BlogAcceptUsersAuthenticationHandler() {
    }
    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException {
        String username = credential.getUsername();
        String cachedPassword = (String)this.users.get(username);
        if(cachedPassword == null) {
            this.logger.debug("{} was not found in the map.", username);
            throw new AccountNotFoundException(username + " not found in backing map.");
        } else {
            String encodedPassword = this.getPasswordEncoder().encode(credential.getPassword());
            if(!cachedPassword.equals(encodedPassword)) {
                throw new FailedLoginException();
            } else {
                return this.createHandlerResult(credential, new SimplePrincipal(username), (List)null);
            }
        }
    }

    public final void setUsers(Map<String, String> users) {
        this.users = Collections.unmodifiableMap(users);
    }

}
