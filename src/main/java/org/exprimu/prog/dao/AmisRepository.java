package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Amis;
public interface AmisRepository extends JpaRepository<Amis, Long> {
}
