package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Statue;

public interface StatueRepository extends JpaRepository<Statue, Long> {
}
