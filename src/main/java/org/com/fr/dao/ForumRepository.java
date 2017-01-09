package org.com.fr.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Forum;
public interface ForumRepository extends JpaRepository<Forum, Long> {
}
