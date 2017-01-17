package org.exprimu.prog.metierImp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.exprimu.prog.entity.CarteBK;
public interface CarteBKMetierImp {
public Page<CarteBK> cartebkPage(int page, int size);
public List<CarteBK> cartebkList();
public CarteBK getCarteBK(Long id);
public CarteBK save(CarteBK cartebk);
public void delete(Long id);
}
