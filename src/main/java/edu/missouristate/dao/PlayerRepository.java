package edu.missouristate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.missouristate.model.Player;
import edu.missouristate.util.MSU;

@Repository
public class PlayerRepository {

	@Autowired
	JdbcTemplate template;

	public PlayerRepository() {
	}

	public List<Player> getPlayers() {
		
		String sql = "SELECT * " + 
                "  FROM players ";
	
		Object[] args = null;		
		List<Player> playerList = template.query(sql, args, MSU.PLAYER_BPRM);		
		return playerList;

	}

	public void addPlayer(Player player) {
		String sql = "INSERT INTO PLAYERS (first_name, last_name, position, eligibility, number) " + 
                     "VALUES (?, ?, ?, ?, ?)";
	
		Object[] args = {player.getFirstName(), player.getLastName(), player.getPosition(), player.getEligibility(), player.getNumber()};
		template.update(sql, args);
	}
    

	public Player getPlayerById(Integer id) {
		String sql = "SELECT * " + 
                     "  FROM players " +
				     " WHERE id = ? ";
	
		Object[] args = {id};
		Player player = template.queryForObject(sql, args, MSU.PLAYER_BPRM);		
		return player;
	}

	public void updatePlayer(Player player) {
		String sql = "UPDATE PLAYERS " + 
                     "   SET first_name = ?, " +
                     "       last_name = ?, " +
                     "       position = ?, " +
                     "       eligibility = ?, " +
                     "       number= ? " +
                     " WHERE id = ? ";

		Object[] args = {player.getFirstName(), player.getLastName(), player.getPosition(), player.getEligibility(), player.getNumber(), player.getId()};
		template.update(sql, args);
	}

	public int deletePlayer(int id) {
		String sql = "DELETE FROM players " + 
                     " WHERE id = ? ";

		Object[] args = {id};
		return template.update(sql, args);
	}

	
}
