package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Msg_joint;
public interface Msg_jointMetierI {
public Page<Msg_joint> msg_jointPage(int page, int size);
public List<Msg_joint> msg_jointList();
public Msg_joint getMsg_joint(Long id);
public Msg_joint save(Msg_joint msg_joint);
public void delete(Long id);
}
