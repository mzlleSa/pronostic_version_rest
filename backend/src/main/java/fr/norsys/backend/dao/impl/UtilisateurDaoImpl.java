package fr.norsys.backend.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.norsys.backend.dao.IUtilisateurDao;
import fr.norsys.backend.entity.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Utilisateur utilisateur) throws DataAccessException {
		String sql = "INSERT INTO utilisateur (nom,prenom,email,identifiant,mdp) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(),
				utilisateur.getIdentifiant(), utilisateur.getMotDePasse());
	}

	@Override
	public int update(Utilisateur utilisateur) throws SQLException {
		String sql = "update utilisateur set email= ?, mdp= ?, score= ?, classement= ? where id=?";
		return this.jdbcTemplate.update(sql, utilisateur.getEmail(), utilisateur.getMotDePasse(),
				utilisateur.getScore(), utilisateur.getClassement(), utilisateur.getId());
	}

	@Override
	public Optional<Utilisateur> findByIdentifiant(String identifiant) throws DataAccessException {
		String sql = "select * from utilisateur where identifiant=?";
		List<Utilisateur> utilisateurs = jdbcTemplate.query(sql, statement -> statement.setString(1, identifiant),
				this::mapUtilisateurFourArgs);
		return utilisateurs.isEmpty() ? Optional.empty() : Optional.of(utilisateurs.get(0));
	}

	@Override
	public Optional<Utilisateur> findByEmail(String email) throws DataAccessException {
		String sql = "select * from utilisateur where email=?";
		List<Utilisateur> utilisateurs = jdbcTemplate.query(sql, statement -> statement.setString(1, email),
				this::mapUtilisateurFourArgs);
		return utilisateurs.isEmpty() ? Optional.empty() : Optional.of(utilisateurs.get(0));
	}

	@Override
	public Optional<Utilisateur> findByIdentifiantMotDePasse(String identifiant, String motDePasse)
			throws DataAccessException {
		String sql = "select * from utilisateur where identifiant = ? and mdp= ?";
		List<Utilisateur> utilisateurs = jdbcTemplate.query(sql, statement -> {
			statement.setString(1, identifiant);
			statement.setString(2, motDePasse);
		}, this::mapUtilisateurNineArgs);
		return utilisateurs.isEmpty() ? Optional.empty() : Optional.of(utilisateurs.get(0));
	}

	@Override
	public Optional<Utilisateur> findById(Long idUtilisateur) throws SQLException {
		String sql = "select * from utilisateur where id=?";
		List<Utilisateur> utilisateurs = jdbcTemplate.query(sql, statement -> statement.setLong(1, idUtilisateur),
				this::mapUtilisateurNineArgs);
		return utilisateurs.isEmpty() ? Optional.empty() : Optional.of(utilisateurs.get(0));
	}

	@Override
	public List<Utilisateur> findAll() throws SQLException {
		String sql = "select * from utilisateur";
		return jdbcTemplate.query(sql, this::mapUtilisateurNineArgs);
	}

	@Override
	public void delete(Long idUtilisateur) throws SQLException {
		String sql = "delete from utilisateur where id=? ";
		this.jdbcTemplate.update(sql, idUtilisateur);
	}

	private Utilisateur mapUtilisateurFourArgs(ResultSet resultSet, int num) throws SQLException {
		return new Utilisateur(resultSet.getString("identifiant"), resultSet.getString("email"),
				resultSet.getString("mdp"), resultSet.getString("role"));
	}

	private Utilisateur mapUtilisateurNineArgs(ResultSet resultSet, int num) throws SQLException {
		return new Utilisateur(resultSet.getLong("id"), resultSet.getString("nom"), resultSet.getString("prenom"),
				resultSet.getString("email"), resultSet.getString("identifiant"), resultSet.getInt("score"),
				(Integer) resultSet.getObject("classement"), resultSet.getString("mdp"), resultSet.getString("role"));
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
