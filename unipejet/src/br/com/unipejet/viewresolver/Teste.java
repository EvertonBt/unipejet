package br.com.unipejet.viewresolver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unipejet.models.*;

public class Teste {

	Connection connection = new ConnectionFactory().getConnection();
	
	public List<Voos> list() {
	
	
	try {	
	
	PreparedStatement stmt = this.connection.prepareStatement("select * from voos");
	ResultSet rs = stmt.executeQuery();
	
	List<Voos> voos = new ArrayList<Voos>();

	while (rs.next()) {

	    // criando o objeto Contato
	    Voos voo = new Voos();
	    voo.setIdentificador((int) rs.getLong("identificador"));
	    voo.setData(rs.getString("data"));
	    voo.setPreco(rs.getDouble("preco"));
        voo.setStatus( (int) rs.getLong("status"));
	    // adicionando o objeto à lista
	     voos.add(voo);
	}

	rs.close();
	stmt.close();

	return voos;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
	}

	public void altera(Voos voo) {
	     String sql = "update voos set preco=?, status=? where identificador = ?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         stmt.setDouble(1, voo.getPreco());
	         stmt.setLong(2, voo.getStatus());
	         stmt.setLong(3, voo.getIdentificador());
	         stmt.executeUpdate();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	
}
