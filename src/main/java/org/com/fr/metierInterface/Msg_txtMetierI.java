package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Msg_txt;
public interface Msg_txtMetierI {
public Page<Msg_txt> msg_txtPage(int page, int size);
public List<Msg_txt> msg_txtList();
public Msg_txt getMsg_txt(Long id);
public Msg_txt save(Msg_txt msg_txt);
public void delete(Long id);
}
