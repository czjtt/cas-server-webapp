package org.jasig.cas.authentication;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

/**
 * Created by NS on 2016/3/14.
 */
public class UsernamePasswordCaptchaCredential extends UsernamePasswordCredential {

    private static final long serialVersionUID = -864745145551932618L;

    @NotNull
    @Size(min=1,message = "required.captcha")
    private String captcha;

    public UsernamePasswordCaptchaCredential() {
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
