package org.cuber.config;

import org.springframework.security.access.*;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by cuber on 2016/2/18.
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes != null && configAttributes.size() != 0) {
            Iterator<ConfigAttribute> ite = configAttributes.iterator();
            while (ite.hasNext()) {
                ConfigAttribute ca = ite.next();
                String needRole = ((org.springframework.security.access.SecurityConfig) ca).getAttribute();
                for (GrantedAuthority ga : authentication.getAuthorities()) {
                    if(ga.getAuthority().equals(needRole)){
                        return;
                    }
                }
            }
            throw new AccessDeniedException("");
        }
    }
        @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
