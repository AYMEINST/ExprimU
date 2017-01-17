package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Roles;
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
