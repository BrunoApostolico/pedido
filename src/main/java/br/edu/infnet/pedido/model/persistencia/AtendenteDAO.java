package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Atendente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO extends JdbcDAO<Atendente>  {

	public AtendenteDAO() {
	}
	
	@Override
	public Boolean salvar(Atendente atendente) {
		String sql = "insert into atendente(nome, codigo) values (?,null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, atendente.getNome()); //sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Boolean atualizar(Atendente atendente) {
		String sql = "update atendente set nome = ? where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, atendente.getNome());
			pstm.setLong(2, atendente.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean deletar(Atendente atendente) {
		String sql = "delete from atendente where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, atendente.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public Atendente obter(Long codigo){
		String sql = "select * from atendente where codigo = ?";
		Atendente atendente = new Atendente();
		try {
			pstm = con.prepareStatement(sql); 
			pstm.setLong(1, codigo); 
			rs = pstm.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				Long codigoDB = rs.getLong("codigo");
				atendente = new Atendente(nome, codigoDB);
			}
			return atendente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Atendente> listarTodos(){
		String sql = "select * from atendente";
		List<Atendente> atendentes = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString("nome");
				Long codigo = rs.getLong("codigo");
				Atendente atendente = new Atendente(nome, codigo);
				atendentes.add(atendente);
			}
			return atendentes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
