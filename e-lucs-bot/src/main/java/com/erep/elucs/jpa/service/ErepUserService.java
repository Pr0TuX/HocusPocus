package com.erep.elucs.jpa.service;

import com.erep.elucs.jpa.domain.ErepUser;

/**
 * @author dragos
 */

public interface ErepUserService {
    ErepUser findByNick(String nick);

    void addUser(ErepUser erepUser);

    Iterable<ErepUser> findAll();
}
