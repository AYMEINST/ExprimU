package org.com.fr.metierInterface;

import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Carte_BK;

public interface Carte_BKMetierI {
	public Page<Carte_BK> carte_bkPage(int page, int size);

	public List<Carte_BK> carte_bkList();

	public Carte_BK getCarte_BK(Long id);

	public Carte_BK save(Carte_BK carte_bk);

	public void delete(Long id);
}
