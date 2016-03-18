package org.jasig.cas.web.flow;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCaptchaCredential;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;

/**
 * Created by NS on 2016/3/15.
 */
public class CnBlogAuthenticationViaFormAction extends AuthenticationViaFormAction{
    public final String validatorCaptcha(final RequestContext context, final Credential credential,
                                         final MessageContext messageContext) throws GeneralSecurityException {

        final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
        HttpSession session = request.getSession();
        String captcha = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
//        String captcha = (String)session.getAttribute("code");
//        session.removeAttribute("code");

        UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)credential;
        String submitAuthcodeCaptcha =upc.getCaptcha();


        if(!StringUtils.hasText(submitAuthcodeCaptcha) || !StringUtils.hasText(captcha)){
            messageContext.addMessage(new MessageBuilder().error().code("required.captcha").build());
            return "error";
        }
        if(submitAuthcodeCaptcha.equals(captcha)){
            return "success";
        }
        messageContext.addMessage(new MessageBuilder().error().code("error.authentication.captcha.bad").build());
        return "error";
    }
}
