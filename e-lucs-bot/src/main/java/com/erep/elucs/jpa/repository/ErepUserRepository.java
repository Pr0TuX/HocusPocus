package com.erep.elucs.jpa.repository;

import com.erep.elucs.jpa.domain.ErepUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author dragos
 */
public interface ErepUserRepository extends CrudRepository<ErepUser, Long> {

    ErepUser findByNick(String nick);

    @Query(value = "select u from ErepUser u where u.profileId = :profileId")
    List<ErepUser> findAllByProfileId(@Param("profileId") String profileId);

    ErepUser findByProfileId(String profileId);
}
