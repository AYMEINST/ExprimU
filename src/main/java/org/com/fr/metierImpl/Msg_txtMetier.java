package org.com.fr.metierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.com.fr.dao.Msg_txtRepository;
import org.com.fr.entity.Msg_txt;
import org.com.fr.metierInterface.Msg_txtMetierI;
@Service
public class Msg_txtMetier implements Msg_txtMetierI{
@Autowired
private Msg_txtRepository msg_txtRepository;
@Override
public Page<Msg_txt> msg_txtPage(int page, int size) {
return msg_txtRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Msg_txt> msg_txtList() {
return msg_txtRepository.findAll();
}
@Override
public Msg_txt getMsg_txt(Long id) {
return msg_txtRepository.findOne(id);
}
@Override
public Msg_txt save(Msg_txt msg_txt) {
return msg_txtRepository.save(msg_txt);
}
@Override
public void delete(Long id) {
msg_txtRepository.delete(msg_txtRepository.findOne(id));
}
}
