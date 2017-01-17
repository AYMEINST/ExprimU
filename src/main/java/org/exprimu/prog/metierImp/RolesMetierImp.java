package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.Roles;
public interface RolesMetierImp {
public Page<Roles> rolesPage(int page, int size);
public List<Roles> rolesList();
public Roles getRoles(Long id);
public Roles save(Roles roles);
public void delete(Long id);
}
