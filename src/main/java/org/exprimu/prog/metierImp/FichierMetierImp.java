package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.exprimu.prog.entity.Fichier;
public interface FichierMetierImp {
	
	public Fichier findOne(Long arg0);
	public Page<Fichier> findAll(Pageable arg0);
	public List<Fichier> findAll();
	public Fichier save(Fichier u);
	public void delete(Long arg0);
}
