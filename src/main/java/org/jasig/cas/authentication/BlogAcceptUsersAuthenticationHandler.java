package org.jasig.cas.authentication;

import ns.inner.IUserOperation;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    private IUserOperation userOperation;

    public BlogAcceptUsersAuthenticationHandler() {
    }
    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential) throws GeneralSecurityException, PreventedException {

        Assert.assertNotNull("userOperate注入失败", userOperation);

        String username = credential.getUsername();
        String cachedPassword = "";
        try {
            cachedPassword = userOperation.selectUserByName(username).getPassword();
        }catch (NullPointerException npe){
            this.logger.debug("{} was not found in the map.", username);
            throw new AccountNotFoundException(username + " not found in backing map.");
        }
        String encodedPassword = this.getPasswordEncoder().encode(credential.getPassword());
        if(!cachedPassword.equals(encodedPassword)) {
            throw new FailedLoginException();
        } else {
            return this.createHandlerResult(credential, new SimplePrincipal(username), (List)null);
        }

    }
}
