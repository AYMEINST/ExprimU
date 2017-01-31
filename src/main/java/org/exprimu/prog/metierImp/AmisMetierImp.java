package org.exprimu.prog.metierImp;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.exprimu.prog.entity.Amis;
import org.exprimu.prog.entity.Utilisateur;

public interface AmisMetierImp {
	public Page<Amis> amisPage(int page, int size);

	public List<Amis> amisList();

	public Amis getAmis(Long id);

	public Amis save(Amis amis);

	public void delete(Long id);

	public List<Amis> getAmisByUtilisateur(Long idUtilisateur);

	public List<Utilisateur> getAmisByUtilisateurList(Long idUtilisateur);
}
