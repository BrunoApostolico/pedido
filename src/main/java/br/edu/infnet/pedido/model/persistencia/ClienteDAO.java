package br.edu.infnet.pedido.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedido.model.JdbcUtil;
import br.edu.infnet.pedido.model.entidade.Cliente;

public class ClienteDAO {

	private Connection con;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	public ClienteDAO() {
		con = JdbcUtil.obterConexao();
	}
	
	//CRUD
	//CREATE RETRIEVE UPDATE DELETE
	public Boolean salvar(Cliente cliente) {
		String sql = "insert into cliente(nome, codigo) values (?,null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome()); //sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Cliente> listarTodos(){
		String sql = "select * from cliente";
		List<Cliente> clientes = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString("nome");
				Long codigo = rs.getLong("codigo");
				Cliente cliente = new Cliente(nome, codigo);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
