package edu.missouristate.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import edu.missouristate.model.Player;

public interface PlayerService {
	public List<Player> getPlayers();
	public Player getPlayerById(Integer id);
	public void addPlayer(Player player);
	public int deletePlayer(Model model, int id);
	public void updatePlayer(Model model, Player player);
	public String prepareEditPlayer(HttpSession session, Model model, int parseInt);
	public String prepareAddPlayer(Model model);
}
