package org.cuber.database.entity;

import java.util.List;

/**
 * Created by cuber on 2016/2/15.
 */
public class Resouce {
    private String id;
    private String resouceName;

    public String getResouceName() {
        return resouceName;
    }

    public void setResouceName(String resouceName) {
        this.resouceName = resouceName;
    }

    private String resouceType;
    private String resouceMatch;
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getResouceType() {
        return resouceType;
    }

    public void setResouceType(String resouceType) {
        this.resouceType = resouceType;
    }

    public String getResouceMatch() {
        return resouceMatch;
    }

    public void setResouceMatch(String resouceMatch) {
        this.resouceMatch = resouceMatch;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
