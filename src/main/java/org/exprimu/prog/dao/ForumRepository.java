package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Forum;
public interface ForumRepository extends JpaRepository<Forum, Long> {
}
