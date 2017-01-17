package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.ForumRepository;
import org.exprimu.prog.entity.Forum;
import org.exprimu.prog.metierImp.ForumMetierImp;
@Service
public class ForumMetier implements ForumMetierImp{
@Autowired
private ForumRepository forumRepository;
@Override
public Page<Forum> forumPage(int page, int size) {
return forumRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Forum> forumList() {
return forumRepository.findAll();
}
@Override
public Forum getForum(Long id) {
return forumRepository.findOne(id);
}
@Override
public Forum save(Forum forum) {
return forumRepository.save(forum);
}
@Override
public void delete(Long id) {
forumRepository.delete(forumRepository.findOne(id));
}
}
