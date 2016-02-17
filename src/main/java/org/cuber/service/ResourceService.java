package org.cuber.service;

import org.cuber.database.entity.Resource;
import org.cuber.database.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cuber on 2016/2/17.
 */
@Service
public class ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public Set<String> findResourceByUri(String requestUri){
        List<Resource> allResources = resourceMapper.getAllResources();
        Set<String> retRoles = new HashSet<>();
        allResources.
                stream().
                filter(resource -> new AntPathMatcher().match(resource.getResource(), requestUri))
                .forEach(resource -> retRoles.addAll(resource.getRoles()));
        return retRoles;
    }
}
