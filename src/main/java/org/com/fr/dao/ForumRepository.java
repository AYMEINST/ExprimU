package org.com.fr.dao;

import org.com.fr.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
