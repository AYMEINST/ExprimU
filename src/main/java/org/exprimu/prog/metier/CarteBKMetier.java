package org.exprimu.prog.metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.exprimu.prog.dao.CarteBKRepository;
import org.exprimu.prog.entity.CarteBK;
import org.exprimu.prog.metierImp.CarteBKMetierImp;
@Service
public class CarteBKMetier implements CarteBKMetierImp{
@Autowired
private CarteBKRepository cartebkRepository;
@Override
public Page<CarteBK> cartebkPage(int page, int size) {
return cartebkRepository.findAll(new PageRequest(page, size));
}
@Override
public List<CarteBK> cartebkList() {
return cartebkRepository.findAll();
}
@Override
public CarteBK getCarteBK(Long id) {
return cartebkRepository.findOne(id);
}
@Override
public CarteBK save(CarteBK cartebk) {
return cartebkRepository.save(cartebk);
}
@Override
public void delete(Long id) {
cartebkRepository.delete(cartebkRepository.findOne(id));
}
}
