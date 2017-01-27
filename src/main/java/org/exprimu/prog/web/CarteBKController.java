package org.exprimu.prog.web;




import java.util.List;

import org.exprimu.prog.entity.CarteBK;
import org.exprimu.prog.entity.Utilisateur;
import org.exprimu.prog.metierImp.CarteBKMetierImp;
import org.exprimu.prog.metierImp.UtilisateurMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/CarteBK")
public class CarteBKController {
	@Autowired
	private UtilisateurMetierImp utilisateurI;
	@Autowired
	private CarteBKMetierImp CarteBKMetierI;
	
	
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public CarteBK save( @RequestBody CarteBK cartebk) {
		cartebk.setUtilisateur((Utilisateur) utilisateurI.getConnectedUser().get("utilisateur"));
		return CarteBKMetierI.save(cartebk);
	}

	
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Edit",method = RequestMethod.PUT)
	public CarteBK edit(@PathVariable( "id") long id) {
		CarteBK carteBK = null;
		if (id == 0) {
			carteBK = new CarteBK();
		} else {
			carteBK = CarteBKMetierI.getCarteBK(id);
			
			//*update 
		}
		return carteBK;
	}
	
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/list" ,method = RequestMethod.GET)
	public List<CarteBK> cartebkList() {
		return CarteBKMetierI.cartebkList();
	}
	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public CarteBK getCarteBK(@PathVariable Long id) {
		return CarteBKMetierI.getCarteBK(id);
	}


	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/Delete/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		CarteBKMetierI.delete(id);
	}
	
	
	
}
