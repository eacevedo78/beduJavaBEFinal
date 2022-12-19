package org.bedu.api.servidores.repository;

import org.bedu.api.servidores.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IServerRepository extends JpaRepository<Server,Long> {
}
