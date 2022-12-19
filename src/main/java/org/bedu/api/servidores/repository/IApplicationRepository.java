package org.bedu.api.servidores.repository;

import org.bedu.api.servidores.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findByServerId(long serverId);

}
