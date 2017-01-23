package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.AmisRepository;
import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.metierImp.AmisMetierImp;
@Service
public class AmisMetier implements AmisMetierImp{
@Autowired
private AmisRepository amisRepository;
@Override
public Page<Amis> amisPage(int page, int size) {
return amisRepository.findAll(new PageRequest(page, size));
}
@Override
public List<Amis> amisList() {
return amisRepository.findAll();
}
@Override
public Amis getAmis(Long id) {
return amisRepository.findOne(id);
}
@Override
public Amis save(Amis amis) {
return amisRepository.save(amis);
}
@Override
public void delete(Long id) {
amisRepository.delete(amisRepository.findOne(id));
}
}
