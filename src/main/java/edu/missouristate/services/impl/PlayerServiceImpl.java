package edu.missouristate.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import edu.missouristate.dao.PlayerRepository;
import edu.missouristate.model.Player;
import edu.missouristate.services.PlayerService;
import edu.missouristate.util.Helper;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;

		@Override
		public List<Player> getPlayers() {
			return playerRepo.getPlayers();
		}
	
		@Override
		@Transactional
		public void addPlayer(Player player) {
			playerRepo.addPlayer(player);
		}
	
		@Override
		public String prepareAddPlayer(Model model) {
			// Create a new instance of 
			Player player = new Player();
	
			// Add the empty  and title to the model
			model.addAttribute("command", player);
			model.addAttribute("title", "Add Player");
			return "addEditPlayer";
		}
	
		@Override
		public String prepareEditPlayer(HttpSession session, Model model, int id) {
			// Get the Player by ID
			Player player = getPlayerById(id);
	
			if (player != null) {
	
				model.addAttribute("command", player);
				model.addAttribute("title", "Edit Player");
	
				// Return the addEditPlayer page
				return "addEditPlayer";
			} else {
				// Provide error message to the  and redirect to the Players page
				Helper.addSessionMessage(session, "Sorry, Player with ID = " + id + " not found.");
				return "redirect:/players";
			}
		}
	
		@Override
		public Player getPlayerById(Integer id) {
			return playerRepo.getPlayerById(id);
		}
	
		@Override
		public void updatePlayer(Model model, Player player) {
			playerRepo.updatePlayer(player);
		}
	
		@Override
		public int deletePlayer(Model model, int id) {
			return playerRepo.deletePlayer(id);
		}

}
