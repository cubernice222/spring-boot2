package org.cuber.config;

import org.cuber.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.*;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by cuber on 2016/2/18.
 */
@Service
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ResourceService resourceService;
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequestUrl();
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        System.out.println("url:" + url);
        List<ConfigAttribute> result = new ArrayList<ConfigAttribute>();
        Set<String> roleNames = resourceService.findResourceByUri(url);
        for (String roleName: roleNames
             ) {
            ConfigAttribute conf = new SecurityConfig(roleName);
            result.add(conf);
        }
        return result;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return true;
    }
}
