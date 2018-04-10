package fr.norsys.backend.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.IMatchDao;
import fr.norsys.backend.entity.Match;

@Repository
public class MatchDaoImpl implements IMatchDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int update(Match match) throws SQLException {
		String sql = "update match set identifiant=?, type=?, date_match=?, est_jouer=?, id_competition=?, est_traite=? where id=?";
		return jdbcTemplate.update(sql, match.getIdentifiant(), match.getType(), match.getDateMatch(),
				match.isEstJouer(), match.getIdCompetition(), match.isEstTraite(), match.getId());
	}

	@Override
	public List<Match> getMatchsPoule(Long idCompetition, int poule) throws SQLException {
		String sql = "select distinct m.id,m.identifiant,m.date_match from ((resultat inner join match m on m.id=resultat.id_match)"
				+ "inner join equipe e on e.id=resultat.id_equipe) where m.id_competition=? and m.type='poule' and e.poule=?";
		return jdbcTemplate.query(sql, statement -> {
			statement.setLong(1, idCompetition);
			statement.setInt(2, poule);
		}, this::mapMatchThreeArgs);
	}

	@Override
	public Optional<Match> getById(Long idMatch) throws SQLException {
		String sql = "select * from match where id=?";
		List<Match> matchs = jdbcTemplate.query(sql, statement -> statement.setLong(1, idMatch), this::mapMatchSixArgs);
		return matchs.isEmpty() ? Optional.empty() : Optional.of(matchs.get(0));
	}

	@Override
	public List<Match> getNotPlayedMatch() throws SQLException {
		String sql = "select * from match where date_match <=? and est_jouer=false";
		return jdbcTemplate.query(sql,
				statement -> statement.setTimestamp(1, new Timestamp(System.currentTimeMillis())),
				this::mapMatchSixArgs);
	}

	@Override
	public List<Match> getPlayedMatch() throws SQLException {
		String sql = "select distinct m.id, m.identifiant, m.type, m.date_match, m.est_jouer, m.id_competition, m.est_traite from match m inner join resultat r on r.id_match = m.id where m.est_jouer=true and m.est_traite=false and r.score is not null";
		return jdbcTemplate.query(sql, this::mapMatchSevenArgs);
	}

	@Override
	public void delete(Long idMatch) throws SQLException {
		String sql = "delete from match where id=? ";
		this.jdbcTemplate.update(sql, idMatch);
	}

	@Override
	public int add(Match match) throws SQLException {
		String sql = "insert into match(identifiant,type,date_match,est_jouer,id_competition) values (?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql, match.getIdentifiant(), match.getType(), match.getDateMatch(),
				match.isEstJouer(), match.getIdCompetition());
	}

	@Override
	public List<Match> findAll() throws SQLException {
		String sql = "select * from match";
		return jdbcTemplate.query(sql, this::mapMatchSevenArgs);
	}

	private Match mapMatchThreeArgs(ResultSet resultSet, int rowNum) throws SQLException {
		return new Match(resultSet.getLong("id"), resultSet.getString("identifiant"),
				resultSet.getTimestamp("date_match"));
	}

	private Match mapMatchSixArgs(ResultSet resultSet, int rowNum) throws SQLException {
		return new Match(resultSet.getLong("id"), resultSet.getString("identifiant"), resultSet.getString("type"),
				resultSet.getTimestamp("date_match"), resultSet.getBoolean("est_jouer"),
				resultSet.getLong("id_competition"));
	}

	private Match mapMatchSevenArgs(ResultSet resultSet, int rowNum) throws SQLException {
		return new Match(resultSet.getLong("id"), resultSet.getString("identifiant"), resultSet.getString("type"),
				resultSet.getTimestamp("date_match"), resultSet.getBoolean("est_jouer"),
				resultSet.getLong("id_competition"), resultSet.getBoolean("est_traite"));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Optional<Match> getNextMatch() throws SQLException {
		String sql = "select * from match where date_match >= ? order by date_match asc";
		List<Match> matchs = jdbcTemplate.query(sql,
				statement -> statement.setTimestamp(1, new Timestamp(System.currentTimeMillis())),
				this::mapMatchSevenArgs);
		return matchs.isEmpty() ? Optional.empty() : Optional.of(matchs.get(0));
	}

}
