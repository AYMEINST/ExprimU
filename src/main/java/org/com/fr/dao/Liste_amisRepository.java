package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Amis;
public interface Liste_amisRepository extends JpaRepository<Amis, Long> {
}
