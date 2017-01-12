package org.com.fr.metierInterface;

import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.Statue;

public interface StatueMetierI {
	public Page<Statue> statuePage(int page, int size);

	public List<Statue> statueList();

	public Statue getStatue(Long id);

	public Statue save(Statue statue);

	public void delete(Long id);
}
