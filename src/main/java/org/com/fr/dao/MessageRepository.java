package org.com.fr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.com.fr.entity.Message;


public interface MessageRepository extends JpaRepository<Message,Long> {
}
