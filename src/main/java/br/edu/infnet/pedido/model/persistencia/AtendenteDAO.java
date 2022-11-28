package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Atendente;
import br.edu.infnet.pedido.model.entidade.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO extends JdbcDAO<Atendente>  {

	public AtendenteDAO() {
	}
	
	@Override
	public Boolean salvar(Atendente atendente) {
		String sql = "insert into atendente(idade, formacao) values (?,null)";
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
		String sql = "update atendente set turno = ? where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, atendente.getNome());
			pstm.setLong(2, atendente.getIdade());
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
			pstm.setLong(1, atendente.getIdade());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cliente obter(Long codigo) {
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
				String formacao = rs.getString("formacao");
				String turno = rs.getString("turno");
				int idade = rs.getInt("idade");
				Atendente atendente = new Atendente(idade,formacao,turno);
				atendentes.add(atendente);
			}
			return atendentes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
