package br.com.unipejet.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.unipejet.models.Registro;
import br.com.unipejet.models.Voos;

@Repository
public class RegistroCompraDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	// Salva Logs de Compra
	public void save(Registro rc){
		
		em.persist(rc);
		
	}
	
	
	// Lista Registros de Compra (logs)
	public List<Registro> lista() {
	return em.createQuery("select r from Registro r").getResultList();
	}

	public long contaRegistros(){
		String consulta = "SELECT COUNT(r) FROM Registro r";
		TypedQuery<Long> query = em.createQuery(consulta, Long.class);
		Long resultado = query.getSingleResult();

		return resultado;

		}

	//Método para buscar um registro específico
	public Registro find(Integer identificador) {
	return em.find(Registro.class, identificador);
	}
	
	// Método que remove um voo
	public void remove(Registro registro) {
		em.remove(registro);
		
	}

	
	
}
