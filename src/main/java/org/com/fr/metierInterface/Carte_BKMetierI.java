package org.com.fr.metierInterface;

import java.util.List;
import org.springframework.data.domain.Page;
import org.com.fr.entity.CarteBK;

public interface Carte_BKMetierI {
	public Page<CarteBK> carte_bkPage(int page, int size);

	public List<CarteBK> carte_bkList();

	public CarteBK getCarte_BK(Long id);

	public CarteBK save(CarteBK carte_bk);

	public void delete(Long id);
}
