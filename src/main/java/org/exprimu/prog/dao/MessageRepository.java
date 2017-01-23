package org.exprimu.prog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.exprimu.prog.entity.Message;
public interface MessageRepository extends JpaRepository<Message, Long> {
}
