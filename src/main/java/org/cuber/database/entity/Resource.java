package org.cuber.database.entity;

import java.util.List;

/**
 * Created by cuber on 2016/2/15.
 */
public class Resource {

    private String id;
    private String resourceName;
    private String resourceType;
    private String resource;
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
       return super.toString() + "{id:" + id + ",resourceName:" + resourceName + ",resourceType:" + resourceType
               +",resource:" + resource + ",roles:" + (roles != null ? roles.toString():"") +  "}";
    }
}
