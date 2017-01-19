package br.com.unipejet.daos;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.unipejet.infra.NegocioException;

import br.com.unipejet.models.User;
import br.com.unipejet.models.Voos;



@Repository
public class VoosDAO implements Serializable{

//	@PersistenceContext(name="PersistentUnitName", type=PersistenceContextType.EXTENDED)
	@PersistenceContext
	private EntityManager voo_manager;
	private static final long serialVersionUID = 1L;



	// Método responsável por gravar os dados, cadastrando novos voos
	
	public void save(Voos voo){
	voo_manager.persist(voo);

	}

	// Método para buscar a lista de usuários do banco

	public List<Voos> lista() {
	return voo_manager.createQuery("select v from Voos v").getResultList();
	}

	
	
	
	//Método para buscar um voo específico
	public Voos find(Integer identificador) {
	return voo_manager.find(Voos.class, identificador);
	}


	// Método para editar voo
	@Transactional 
	public Voos altera(Voos voo) {
	
		
		try {
		voo = this.voo_manager.merge(voo);
			return voo;
		} catch (OptimisticLockException e) {
			throw new NegocioException("Erro de concorrência. Esse usuário já foi alterado anteriormente.");
		}
	
	}

	// Método que remove um voo
	public void remove(Voos voo) {
		voo_manager.remove(voo);
		
	}

	// Método para buscar voo com base na pesquisa por origem e destino
  
	public List<Voos> buscaVoo(String origem, String destino, String data) {
  /*
		try{
			TypedQuery<Voos> query = voo_manager
					.createQuery(
							"select v from Voos v  where v.origem = :origem and v. = :destino and v.data = :data",
							Voos.class);
			query.setParameter("origem", origem);
			query.setParameter("destino", destino);
			query.setParameter("data", data);
	         return query.();
		
		}catch (NoResultException nre){
			return null;
		}
	*/
		Query query = voo_manager.createQuery("select v from Voos v where v.origem = :origem and v.destino = :destino and v.data = :data", Voos.class);
		query.setParameter("origem", origem);
		query.setParameter("destino", destino);
		query.setParameter("data", data);
       try{
		return query.getResultList();
       }catch(NoResultException nre){
    	   return null;
       }
       
	}
		
	public long contaRegistros(){
		String consulta = "SELECT COUNT(v) FROM Voos v";
		TypedQuery<Long> query = voo_manager.createQuery(consulta, Long.class);
		Long resultado = query.getSingleResult();

		return resultado;

		}
		
	}
		
		


	





	


