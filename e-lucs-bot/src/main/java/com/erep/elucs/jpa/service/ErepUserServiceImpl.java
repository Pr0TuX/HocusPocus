package com.erep.elucs.jpa.service;

import com.erep.elucs.jpa.domain.ErepUser;
import com.erep.elucs.jpa.repository.ErepUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dragos
 */

@Service
@Transactional
public class ErepUserServiceImpl implements ErepUserService {
    @Autowired
    ErepUserRepository erepUserRepository;


    @Override
    public ErepUser findByNick(String nick) {
        return erepUserRepository.findByNick(nick);
    }

    @Override
    public void addUser(ErepUser erepUser) {
        ErepUser byNick = erepUserRepository.findByNick(erepUser.getNick());
        byNick = byNick == null ? erepUser : byNick;
        byNick.setProfileId(erepUser.getProfileId());
        erepUserRepository.save(byNick);
    }


    @Override
    public Iterable<ErepUser> findAll() {
        return erepUserRepository.findAll();
    }
}
