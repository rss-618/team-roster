package edu.missouristate.util;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import edu.missouristate.model.Player;

public class MSU {

	public static BeanPropertyRowMapper<Player> PLAYER_BPRM = new BeanPropertyRowMapper<Player>(Player.class);

}
