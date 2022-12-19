package org.bedu.api.servidores.repository;

import org.bedu.api.servidores.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
}
