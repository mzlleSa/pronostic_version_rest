package fr.norsys.backend.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.IResultatDao;
import fr.norsys.backend.entity.Resultat;

@Repository
public class ResultatDaoImpl implements IResultatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<Resultat> findByIdMatchIdEquipe(Long idMatch, Long idEquipe) throws SQLException {
		String sql = "select * from resultat where id_match=? and id_equipe=?";
		List<Resultat> resultats = jdbcTemplate.query(sql, statement -> {
			statement.setLong(1, idMatch);
			statement.setLong(2, idEquipe);
		}, this::mapResultatThreeArgs);
		return resultats.isEmpty() ? Optional.empty() : Optional.of(resultats.get(0));
	}

	@Override
	public List<Resultat> findByIdMatch(Long idMatch) throws SQLException {
		String sql = "select * from resultat where id_match=? and score is not null";
		return jdbcTemplate.query(sql, statement -> statement.setLong(1, idMatch), this::mapResultatThreeArgs);
	}

	@Override
	public int add(Resultat resultat) throws SQLException {
		String sql = "insert into resultat(id_match,id_equipe,score) values (?, ?, ?)";
		return this.jdbcTemplate.update(sql, resultat.getIdMatch(), resultat.getIdEquipe(), resultat.getScore());
	}

	@Override
	public int update(Resultat resultat) throws SQLException {
		String sql = "update resultat set score=? where id_equipe=? and id_match=?";
		return this.jdbcTemplate.update(sql, resultat.getScore(), resultat.getIdEquipe(), resultat.getIdMatch());
	}

	@Override
	public void delete(Long idEquipe, Long idMatch) throws SQLException {
		String sql = "delete from resultat where id_equipe=? and id_match=? ";
		this.jdbcTemplate.update(sql, idEquipe, idMatch);
	}

	@Override
	public List<Resultat> findAll() throws SQLException {
		String sql = "select * from resultat";
		return this.jdbcTemplate.query(sql, this::mapResultatThreeArgs);
	}

	private Resultat mapResultatThreeArgs(ResultSet resultSet, int num) throws SQLException {
		return new Resultat(resultSet.getLong("id_match"), resultSet.getLong("id_equipe"),
				(Integer) resultSet.getObject("score"));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
