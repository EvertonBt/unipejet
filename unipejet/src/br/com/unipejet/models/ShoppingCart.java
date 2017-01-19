package br.com.unipejet.models;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart{

	private  Map<Integer, Compras> items = new LinkedHashMap<Integer, Compras>();

	
	public void add(long numero_compra, Compras item){
		items.put((int) numero_compra, item);

	}

	public void setItems(Map<Integer, Compras> items) {
		this.items = items;
	}

	public Integer getQuantity() {
		return items.size();
		
	}

	public Collection<Compras> getList() {
		return items.values();
	}

	public double getTotal(Compras item) {
		return item.getTotal();
	}
	
	public void remove(Integer chave) {
		items.remove(chave);
	}

	
	
	public Map<Integer, Compras> getItems() {
		return items;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}



	public Collection<Integer> getValues() {
		return items.keySet();
	}

	
	
}