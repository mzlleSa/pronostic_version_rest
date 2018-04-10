package fr.norsys.backend.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.IEquipeDao;
import fr.norsys.backend.entity.Equipe;

@Repository
public class EquipeDaoImpl implements IEquipeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Equipe> getEquipesByMatch(Long idMatch) throws DataAccessException {
		String sql = "select e.id, e.identifiant from equipe e inner join resultat r on e.id=r.id_equipe where r.id_match=?";
		return jdbcTemplate.query(sql, statement -> statement.setLong(1, idMatch), this::mapEquipeTwoArgs);
	}

	@Override
	public List<Equipe> getEquipesOfPoule(Long idCompetition, int poule) throws SQLException {
		String sql = "select distinct e.id, e.identifiant, e.poule from ((resultat r inner join equipe e on e.id = r.id_equipe) inner join match m on m.id = r.id_match) where m.id_competition = ? and e.poule = ?";
		return jdbcTemplate.query(sql, statement -> {
			statement.setLong(1, idCompetition);
			statement.setInt(2, poule);
		}, this::mapEquipeThreeArgs);
	}

	@Override
	public int add(Equipe equipe) throws SQLException {
		String sql = "INSERT INTO equipe (identifiant,poule) VALUES (?, ?)";
		return jdbcTemplate.update(sql, equipe.getIdentifiant(), equipe.getPoule());
	}

	@Override
	public int update(Equipe equipe) throws SQLException {
		String sql = "update equipe set identifiant=? , poule=? where id=? ";
		return this.jdbcTemplate.update(sql, equipe.getIdentifiant(), equipe.getPoule(), equipe.getId());
	}

	@Override
	public void delete(Long idEquipe) throws SQLException {
		String sql = "delete from equipe where id=? ";
		this.jdbcTemplate.update(sql, idEquipe);
	}

	@Override
	public List<Equipe> findAll() throws SQLException {
		String sql = "select * from equipe ";
		return this.jdbcTemplate.query(sql, (resultSet, rowNum) -> new Equipe(resultSet.getLong("id"),
				resultSet.getString("identifiant"), resultSet.getInt("poule")));
	}

	private Equipe mapEquipeTwoArgs(ResultSet resultSet, int rowNum) throws SQLException {
		return new Equipe(resultSet.getLong("id"), resultSet.getString("identifiant"));
	}

	private Equipe mapEquipeThreeArgs(ResultSet resultSet, int rowNum) throws SQLException {
		return new Equipe(resultSet.getLong("id"), resultSet.getString("identifiant"), resultSet.getInt("poule"));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
