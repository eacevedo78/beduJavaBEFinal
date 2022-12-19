package org.bedu.api.servidores.repository;

import org.bedu.api.servidores.entity.Application;
import org.bedu.api.servidores.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICredentialRepository extends JpaRepository<Credential,Long>{

    List<Credential> findByUserId(long userId);
}
