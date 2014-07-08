package com.erep.elucs.jpa.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author dragos
 */
@Entity
public class ErepUser extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String nick;

    private String profileId;

    public ErepUser() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Override
    public String toString() {
        return "SearchedUser{" +
                " id= " + getId() +
                ", nick='" + nick + '\'' +
                ", profileId='" + profileId + '\'' +
                '}';
    }
}
