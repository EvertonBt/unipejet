package br.com.unipejet.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


import br.com.unipejet.models.Role;
import br.com.unipejet.models.User;
import br.com.unipejet.models.Voos;


@Repository
public class UserDAO implements UserDetailsService{

@PersistenceContext
private EntityManager em;


// Método responsável por validar Login
@Override
public UserDetails loadUserByUsername(String username)
throws UsernameNotFoundException {
String jpql = "select u from User u where u.login = :login";

List<User> users = em.createQuery(jpql,User.class).setParameter("login", username).getResultList();
if(users.isEmpty()){
throw new UsernameNotFoundException
("O usuario "+username+" não existe");
}
return users.get(0);
}


// Método responsável por gravar os dados, cadastrando novos usuários
public void save(User user) throws MySQLIntegrityConstraintViolationException{

	em.persist(user);


}

// Método para buscar a lista de usuários do banco

public List<User> lista() {
return em.createQuery("select u from User u").getResultList();
}

public User find(String login) {
return em.find(User.class, login);
}


public void altera(User user) {
	em.merge(user);
}


// Método que remove usuario
public void remove(User user) {
	em.remove(user);
	
}

public long contaRegistros(){
String consulta = "SELECT COUNT(u) FROM User u";
TypedQuery<Long> query = em.createQuery(consulta, Long.class);
Long resultado = query.getSingleResult();

return resultado;

}
}



