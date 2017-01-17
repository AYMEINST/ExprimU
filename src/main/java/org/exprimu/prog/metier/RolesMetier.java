package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.RolesRepository;
import org.exprimu.prog.entity.Roles;
import org.exprimu.prog.metierImp.RolesMetierImp;
@Service
public class RolesMetier implements RolesMetierImp{
@Autowired
private RolesRepository rolesRepository;
@Override
public Page<Roles> rolesPage(int page, int size) {
return rolesRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Roles> rolesList() {
return rolesRepository.findAll();
}
@Override
public Roles getRoles(Long id) {
return rolesRepository.findOne(id);
}
@Override
public Roles save(Roles roles) {
return rolesRepository.save(roles);
}
@Override
public void delete(Long id) {
rolesRepository.delete(rolesRepository.findOne(id));
}
}
