package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Liste_amis;
public interface Liste_amisRepository extends JpaRepository<Liste_amis, Long> {
}
