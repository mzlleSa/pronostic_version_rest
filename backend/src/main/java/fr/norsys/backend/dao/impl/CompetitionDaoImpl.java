package fr.norsys.backend.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.ICompetitionDao;
import fr.norsys.backend.entity.Competition;

@Repository
public class CompetitionDaoImpl implements ICompetitionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Competition> findAll() throws DataAccessException {
		String sql = "select * from competition";
		return jdbcTemplate.query(sql, (resultSet, rowNum) -> new Competition(resultSet.getLong("id"),
				resultSet.getString("identifiant"), resultSet.getDate("date_competition")));
	}

	@Override
	public int add(Competition competition) throws SQLException {
		String sql = "INSERT INTO competition (identifiant,date_competition) VALUES (?, ?)";
		return jdbcTemplate.update(sql, competition.getIdentifiant(), competition.getDateCompetition());
	}

	@Override
	public int update(Competition competition) throws SQLException {
		String sql = "update competition set identifiant=? , date_competition=? where id=? ";
		return this.jdbcTemplate.update(sql, competition.getIdentifiant(), competition.getDateCompetition(),
				competition.getId());
	}

	@Override
	public void delete(Long idCompetition) throws SQLException {
		String sql = "delete from competition where id=? ";
		this.jdbcTemplate.update(sql, idCompetition);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
