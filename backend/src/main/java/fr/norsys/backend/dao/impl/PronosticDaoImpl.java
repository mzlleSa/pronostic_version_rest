package fr.norsys.backend.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.IPronosticDao;
import fr.norsys.backend.entity.Pronostic;

@Repository
public class PronosticDaoImpl implements IPronosticDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Pronostic pronostic) throws SQLException {
		String sql = "insert into pronostic(id_utilisateur,id_equipe,id_match,prediction) values (?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql, pronostic.getIdUtilisateur(), pronostic.getIdEquipe(),
				pronostic.getIdMatch(), pronostic.getPrediction());
	}

	@Override
	public int update(Pronostic pronostic) throws SQLException {
		String sql = "update pronostic set prediction=? where id_utilisateur=? and id_equipe=? and id_match=?";
		return this.jdbcTemplate.update(sql, pronostic.getPrediction(), pronostic.getIdUtilisateur(),
				pronostic.getIdEquipe(), pronostic.getIdMatch());
	}

	@Override
	public List<Pronostic> findByIdUtilisateurIdMatch(Long idUtilisateur, Long idMatch) throws SQLException {
		String sql = "select * from pronostic where id_utilisateur=? and id_match=?";
		return this.jdbcTemplate.query(sql, statement -> {
			statement.setLong(1, idUtilisateur);
			statement.setLong(2, idMatch);
		}, this::mapPronosticFourArgs);
	}

	@Override
	public List<Pronostic> findByIdMatch(Long idMatch) throws SQLException {
		String sql = "select distinct id_utilisateur from pronostic where id_match=?";
		return this.jdbcTemplate.query(sql, statement -> statement.setLong(1, idMatch), this::mapPronosticOneArgs);
	}

	private Pronostic mapPronosticFourArgs(ResultSet resultSet, int num) throws SQLException {
		return new Pronostic(resultSet.getLong("id_utilisateur"), resultSet.getLong("id_equipe"),
				resultSet.getLong("id_match"), (Integer) resultSet.getObject("prediction"));
	}

	private Pronostic mapPronosticOneArgs(ResultSet resultSet, int num) throws SQLException {
		return new Pronostic(resultSet.getLong("id_utilisateur"));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
