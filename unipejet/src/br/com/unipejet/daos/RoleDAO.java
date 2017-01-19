package br.com.unipejet.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.unipejet.models.Role;
import br.com.unipejet.models.User;

@Repository
public class RoleDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public Role find(String name) {
		return em.find(Role.class, name);
		}

	
}
