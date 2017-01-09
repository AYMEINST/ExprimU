package org.com.fr.metierInterface;
import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Roles;
public interface RolesMetierI {
public Page<Roles> rolesPage(int page, int size);
public List<Roles> rolesList();
public Roles getRoles(Long id);
public Roles save(Roles roles);
public void delete(Long id);
}
